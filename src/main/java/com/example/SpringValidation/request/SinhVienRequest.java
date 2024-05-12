package com.example.SpringValidation.request;

import com.example.SpringValidation.validation.ValidationCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class SinhVienRequest {

    @NotEmpty(message = "MSSV không được để trống")
    @ValidationCode(value = "HE130461", message = "Mã số Sinh Vien phải bắt đầu bằng HE130461")
    private String maSoSinhVien;

    @ValidationCode(value = "PH", message = "Họ tên Sinh Vien phải bắt đầu bằng PH")
    @NotEmpty(message = "Họ tên không được để trống")
    private String hoTen;

    @NotNull(message = "Bạn chưa nhập tuổi")
//    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private Integer tuoi;

    private String gioiTinh;

    private String kyHoc;

    @NotEmpty(message = "Quê quán không được để trống")
    private String queQuan;

    private String soThich;

    @NotEmpty(message = "Mật khẩu không được để trống")
    private String matKhau;

    @NotEmpty(message = "Mật khẩu xác nhận không được để trống")
    private String matKhauXacNhan;
}
