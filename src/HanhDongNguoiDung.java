import java.util.List;

public interface HanhDongNguoiDung {
    void muonSach(Sach sach);
    void traSach(Sach sach);
    List<Sach> timKiemSach(String tenSach);
}
