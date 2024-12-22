import java.util.ArrayList;
import java.util.List;

public class ThuVien{
    private String ID;
    private String tenThuVien;
    private List<Sach> danhSachSach;
    private List<NguoiDung> danhSachNguoiDung;

    public ThuVien(String ID, String tenThuVien) {
        this.ID = ID;
        this.tenThuVien = tenThuVien;
        this.danhSachSach = new ArrayList<>();
        this.danhSachNguoiDung = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenThuVien() {
        return tenThuVien;
    }

    public void setTenThuVien(String tenThuVien) {
        this.tenThuVien = tenThuVien;
    }

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public void setDanhSachSach(List<Sach> danhSachSach) {
        this.danhSachSach = danhSachSach;
    }

    public List<NguoiDung> getDanhSachNguoiDung() {
        return danhSachNguoiDung;
    }

    public void setDanhSachNguoiDung(List<NguoiDung> danhSachNguoiDung) {
        this.danhSachNguoiDung = danhSachNguoiDung;
    }

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
        System.out.println("Them sach: " + sach.getTenSach() + " thành công! ");
    }

    public void xoaSach(Sach sach) {
        danhSachSach.remove(sach);
        System.out.println("Da xoa sach: " +  sach.getTenSach());
    }

    public void themNguoiDung(NguoiDung nguoiDung) {
        danhSachNguoiDung.add(nguoiDung);
        System.out.println("Da them nguoi dung: " + nguoiDung.getTen());
    }

    public void xoaNguoiDung(NguoiDung nguoiDung) {
        danhSachNguoiDung.remove(nguoiDung);
        System.out.println("Da xoa nguoi dung: " + nguoiDung.getTen());
    }

    public void inDanhSachNguoiDung() {
        System.out.println("Danh sach nguoi dung:");
        for (NguoiDung nguoiDung : danhSachNguoiDung) {
            System.out.println(nguoiDung);
        }
    }

    public void inDanhSachSach() {
        System.out.println("Danh sach sach: ");
        for (Sach sach : danhSachSach) {
            System.out.println(sach);
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Ten thu vien: " + tenThuVien + "\n" +
                "So luong sach: " + danhSachSach.size() + "\n" +
                "So luong nguoi dung: " + danhSachNguoiDung.size() + "\n";
    }
}
