import java.util.Date;

public class Sach {
    private String ID;
    private String tenSach;
    private String tacGia;
    private int tongSoLuong;
    private int soLuongDaMuon;
    private Date ngayMuon;
    private Date ngayTra;

    public Sach(String ID, String tenSach, String tacGia, int tongSoLuong) {
        this.ID = ID;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.tongSoLuong = tongSoLuong;
        this.soLuongDaMuon = 0;     
    }

    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public int getSoLuongDaMuon() {
        return soLuongDaMuon;
    }

    public void setSoLuongDaMuon(int soLuongDaMuon) {
        this.soLuongDaMuon = soLuongDaMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void capNhatSoLuongDaMuon(int thayDoi) {
        this.soLuongDaMuon += thayDoi;
        if (this.soLuongDaMuon < 0) {
            this.soLuongDaMuon = 0;
        } else if (this.soLuongDaMuon > this.tongSoLuong) {
            this.soLuongDaMuon = this.tongSoLuong;
        }
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Ten sach: " + tenSach + "\n" +
                "Tac gia: " + tacGia + "\n" +
                "Tong so luong: " + tongSoLuong + "\n" +
                "So luong da muon: " + soLuongDaMuon + "\n" +
                "So luong con lai: " + (tongSoLuong - soLuongDaMuon);
    }
}
