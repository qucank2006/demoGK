import java.util.ArrayList;
import java.util.List;

public class NguoiDung {
    private String ID;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String lop;
    private String maSinhVien;
    private List<Sach> sachDangMuon;

    public NguoiDung(String ID, String ten, String gioiTinh, String ngaySinh, String lop, String maSinhVien) {
        this.ID = ID;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.maSinhVien = maSinhVien;
        this.sachDangMuon = new ArrayList<>();
    }


    public String getID() {
        return ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public List<Sach> getSachDangMuon() {
        return sachDangMuon;
    }

    public void setSachDangMuon(List<Sach> sachDangMuon) {
        this.sachDangMuon = sachDangMuon;
    }


    public void muonSach(Sach sach) {
        if (sachDangMuon.size() < 5) {
            sachDangMuon.add(sach);
            sach.capNhatSoLuongDaMuon(1);
            System.out.println("Muon sach thanh cong: " + sach.getTenSach());
        } else {
            System.out.println("Ban da muon du 5 quyen sach! Khong the muon them.");
        }
    }


    public void traSach(Sach sach) {
        if (sachDangMuon.contains(sach)) {
            sachDangMuon.remove(sach);
            sach.capNhatSoLuongDaMuon(-1);
            System.out.println("Tra sach thanh cong: " + sach.getTenSach());
        } else {
            System.out.println("Ban khong muon sach nay.");
        }
    }


    public List<Sach> timKiemSach(String tenSach) {
        List<Sach> ketQua = new ArrayList<>();
        for (Sach sach : sachDangMuon) {
            if (sach.getTenSach().toLowerCase().contains(tenSach.toLowerCase())) {
                ketQua.add(sach);
            }
        }
        return ketQua;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID: ").append(ID).append("\n");
        result.append("Ten: ").append(ten).append("\n");
        result.append("Gioi tinh: ").append(gioiTinh).append("\n");
        result.append("Ngay sinh: ").append(ngaySinh).append("\n");
        result.append("Lop: ").append(lop).append("\n");
        result.append("Ma sinh vien: ").append(maSinhVien).append("\n");
        result.append("Sach dang muon: \n");
        for (Sach sach : sachDangMuon) {
            result.append("   - ").append(sach.getTenSach()).append(" (Ngay muon: ").append(sach.getNgayMuon()).append(", Ngay tra: ").append(sach.getNgayTra()).append(")\n");
        }
        return result.toString();
    }
}
