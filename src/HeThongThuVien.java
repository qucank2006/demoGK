import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class HeThongThuVien {
    private ThuVien thuVien;
    private Scanner scanner;

    public HeThongThuVien() {
        this.thuVien = new ThuVien("1", "Thu Vien ABC");
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean thoat = false;

        while (!thoat) {
            hienThiMenu();
            int luaChon = scanner.nextInt();
            scanner.nextLine();  

            switch (luaChon) {
                case 1:
                    taoThuVien();
                    break;
                case 2:
                    xemThongTinThuVien();
                    break;
                case 3:
                    quanLyNguoiDung();
                    break;
                case 4:
                    quanLySach();
                    break;
                case 5:
                    timKiem();
                    break;
                case 6:
                    muonSach();
                    break;
                case 7:
                    traSach();
                    break;
                case 8:
                    xemDanhSachSach();
                    break;
                case 9:
                    xemDanhSachNguoiDung();
                    break;
                case 10:
                    thoat = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long thu lai.");
            }
        }
    }

    private void hienThiMenu() {
        System.out.println("1. Tao thu vien");
        System.out.println("2. Xem thong tin thu vien");
        System.out.println("3. Them, sua, xoa nguoi dung");
        System.out.println("4. Them, sua, xoa sach");
        System.out.println("5. Tim kiem sach, nguoi dung theo ten");
        System.out.println("6. Muon sach");
        System.out.println("7. Tra sach");
        System.out.println("8. Xem danh sach sach");
        System.out.println("9. Xem danh sach nguoi dung");
        System.out.println("10. Thoat");
        System.out.println("Nhap lua chon cua ban: ");
    }

    private void taoThuVien() {
        System.out.println("Tao thu vien moi");
        System.out.print("Nhap ID thu vien: ");
        String ID = scanner.nextLine();
        System.out.print("Nhap ten thu vien: ");
        String ten = scanner.nextLine();
        thuVien = new ThuVien(ID, ten);
        System.out.println("Tao thu vien thanh cong!");
    }

    private void xemThongTinThuVien() {
        System.out.println(thuVien);
    }

    private void quanLyNguoiDung() {
        System.out.println("1. Them nguoi dung");
        System.out.println("2. Sua thong tin nguoi dung");
        System.out.println("3. Xoa nguoi dung");
        System.out.print("Chon thao tac: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();
        switch (luaChon) {
            case 1:
                themNguoiDung();
                break;
            case 2:
                suaNguoiDung();
                break;
            case 3:
                xoaNguoiDung();
                break;
            default:
                System.out.println("Lua chon khong hop le! Vui long thu lai.");
            }
    }

    private void themNguoiDung() {
        System.out.print("Nhap ID nguoi dung: ");
        String ID = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhap lop: ");
        String lop = scanner.nextLine();
        System.out.print("Nhap ma sinh vien: ");
        String maSinhVien = scanner.nextLine();

        NguoiDung nguoiDung = new NguoiDung(ID, ten, gioiTinh, ngaySinh, lop, maSinhVien);
        thuVien.themNguoiDung(nguoiDung);

        System.out.println("Da them nguoi dung: " + ten);
    }

    private void suaNguoiDung() {
        System.out.print("Nhap ID nguoi dung can sua: ");
        String ID = scanner.nextLine();
        NguoiDung nguoiDung = timNguoiDungTheoId(ID);

        if (nguoiDung != null) {
            System.out.print("Nhap ten moi: ");
            nguoiDung.setTen(scanner.nextLine());
            System.out.print("Nhap gioi tinh moi: ");
            nguoiDung.setGioiTinh(scanner.nextLine());
            System.out.print("Nhap ngay sinh moi: ");
            nguoiDung.setNgaySinh(scanner.nextLine());
            System.out.print("Nhap lop moi: ");
            nguoiDung.setLop(scanner.nextLine());
            System.out.print("Nhap ma sinh vien moi: ");
            nguoiDung.setMaSinhVien(scanner.nextLine());
            System.out.println("Da cap nhat thong tin nguoi dung.");
        } else {
            System.out.println("Khong tim thay nguoi dung voi ID da nhap.");
        }
    }

    private void xoaNguoiDung() {
        System.out.print("Nhap ID nguoi dung can xoa: ");
        String ID = scanner.nextLine();
        NguoiDung nguoiDung = timNguoiDungTheoId(ID);

        if (nguoiDung != null) {
            thuVien.xoaNguoiDung(nguoiDung);
            System.out.println("Da xoa nguoi dung: " + nguoiDung.getTen());
        } else {
            System.out.println("Khong tim thay nguoi dung voi ID da nhap.");
        }
    }

    private NguoiDung timNguoiDungTheoId(String ID) {
        for (NguoiDung nguoiDung : thuVien.getDanhSachNguoiDung()) {
            if (nguoiDung.getID().equals(ID)) {
                return nguoiDung;
            }
        }
        return null;
    }

    private void quanLySach() {
        System.out.println("1. Them sach");
        System.out.println("2. Sua thong tin sach");
        System.out.println("3. Xoa sach");
        System.out.print("Chon thao tac: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();

        switch (luaChon) {
            case 1:
                themSach();
                break;
            case 2:
                suaSach();
                break;
            case 3:
                xoaSach();
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long thu lai.");
        }
    }

    private void themSach() {
        System.out.print("Nhap ID sach: ");
        String id = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        System.out.print("Nhap tong so luong: ");
        int tongSoLuong = scanner.nextInt();
        scanner.nextLine();

        Sach sach = new Sach(id, tenSach, tacGia, tongSoLuong);
        thuVien.themSach(sach);
        System.out.println("Da them sach: " + tenSach);
    }

    private void suaSach() {
        System.out.print("Nhap ID sach can sua: ");
        String id = scanner.nextLine();
        Sach sach = timSachTheoId(id);

        if (sach != null) {
            System.out.print("Nhap ten sach moi: ");
            sach.setTenSach(scanner.nextLine());
            System.out.print("Nhap tac gia moi: ");
            sach.setTacGia(scanner.nextLine());
            System.out.print("Nhap tong so luong moi: ");
            sach.setTongSoLuong(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Da cap nhat thong tin sach.");
        } else {
            System.out.println("Khong tim thay sach voi ID da nhap.");
        }
    }

    private void xoaSach() {
        System.out.print("Nhap ID sach can xoa: ");
        String id = scanner.nextLine();
        Sach sach = timSachTheoId(id);

        if (sach != null) {
            thuVien.xoaSach(sach);
            System.out.println("Da xoa sach: " + sach.getTenSach());
        } else {
            System.out.println("Khong tim thay sach voi ID da nhap.");
        }
    }

    private Sach timSachTheoId(String id) {
        for (Sach sach : thuVien.getDanhSachSach()) {
            if (sach.getId().equals(id)) {
                return sach;
            }
        }
        return null;
    }

    private void timKiem() {
        System.out.println("1. Tim kiem sach theo ten");
        System.out.println("2. Tim kiem nguoi dung theo ten");
        System.out.print("Chon thao tac: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();

        switch (luaChon) {
            case 1:
                timKiemSach();
                break;
            case 2:
                timKiemNguoiDung();
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long thu lai.");
        }
    }

    private void timKiemSach() {
        System.out.print("Nhap ten sach can tim: ");
        String tenSach = scanner.nextLine();

        List<Sach> ketQua = new ArrayList<>();
        for (Sach sach : thuVien.getDanhSachSach()) {
            if (sach.getTenSach().toLowerCase().contains(tenSach.toLowerCase())) {
                ketQua.add(sach);
            }
        }

        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay sach nao voi ten: " + tenSach);
        } else {
            System.out.println("Ket qua tim kiem sach:");
            for (Sach sach : ketQua) {
                System.out.println(sach);
            }
        }
    }

    private void timKiemNguoiDung() {
        System.out.print("Nhap ten nguoi dung can tim: ");
        String tenNguoiDung = scanner.nextLine();

        List<NguoiDung> ketQua = new ArrayList<>();
        for (NguoiDung nguoiDung : thuVien.getDanhSachNguoiDung()) {
            if (nguoiDung.getTen().toLowerCase().contains(tenNguoiDung.toLowerCase())) {
                ketQua.add(nguoiDung);
            }
        }

        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay nguoi dung nao voi ten: " + tenNguoiDung);
        } else {
            System.out.println("Ket qua tim kiem nguoi dung:");
            for (NguoiDung nguoiDung : ketQua) {
                System.out.println(nguoiDung);
            }
        }
    }

    private void muonSach() {
        System.out.print("Nhap ID nguoi dung: ");
        String idNguoiDung = scanner.nextLine();
        NguoiDung nguoiDung = timNguoiDungTheoId(idNguoiDung);

        if (nguoiDung == null) {
            System.out.println("Khong tim thay nguoi dung voi ID da nhap.");
            return;
        }

        System.out.print("Nhap ID sach can muon: ");
        String idSach = scanner.nextLine();
        Sach sach = timSachTheoId(idSach);

        if (sach == null) {
            System.out.println("Khong tim thay sach voi ID da nhap.");
            return;
        }

        if (sach.getTongSoLuong() - sach.getSoLuongDaMuon() <= 0) {
            System.out.println("Sach da het, khong the muon.");
            return;
        }

        if (nguoiDung.getSachDangMuon().size() >= 5) {
            System.out.println("Ban da muon du 5 quyen sach, khong the muon them.");
            return;
        }

        nguoiDung.muonSach(sach);
        System.out.println("Muon sach thanh cong: " + sach.getTenSach());
    }

    private void traSach() {
        System.out.print("Nhap ID nguoi dung: ");
        String idNguoiDung = scanner.nextLine();
        NguoiDung nguoiDung = timNguoiDungTheoId(idNguoiDung);

        if (nguoiDung == null) {
            System.out.println("Khong tim thay nguoi dung voi ID da nhap.");
            return;
        }

        System.out.print("Nhap ID sach can tra: ");
        String idSach = scanner.nextLine();
        Sach sach = timSachTheoId(idSach);

        if (sach == null) {
            System.out.println("Khong tim thay sach voi ID da nhap.");
            return;
        }

        if (!nguoiDung.getSachDangMuon().contains(sach)) {
            System.out.println("Nguoi dung khong muon sach nay.");
            return;
        }

        nguoiDung.traSach(sach);
        System.out.println("Tra sach thanh cong: " + sach.getTenSach());
    }

    private void xemDanhSachSach() {
        List<Sach> danhSachSach = thuVien.getDanhSachSach();

        if (danhSachSach.isEmpty()) {
            System.out.println("Thu vien hien khong co sach nao.");
        } else {
            System.out.println("Danh sach sach trong thu vien:");
            for (Sach sach : danhSachSach) {
                System.out.println(sach);
            }
        }
    }

    private void xemDanhSachNguoiDung() {
        List<NguoiDung> danhSachNguoiDung = thuVien.getDanhSachNguoiDung();

        if (danhSachNguoiDung.isEmpty()) {
            System.out.println("Thu vien hien khong co nguoi dung nao.");
        } else {
            System.out.println("Danh sach nguoi dung trong thu vien:");
            for (NguoiDung nguoiDung : danhSachNguoiDung) {
                System.out.println(nguoiDung);
            }
        }
    }

    public static void main(String[] args) {
        HeThongThuVien heThongThuVien = new HeThongThuVien();
        heThongThuVien.run();
    }
}