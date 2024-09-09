package com.b3.listfixcung.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter //Tự động sinh mã phương thức getter cho tất cả các trường (fields) trong lớp.
@Setter //Tự động sinh mã phương thức setter cho tất cả các trường trong lớp.
@AllArgsConstructor //Tạo constructor với tất cả các trường trong lớp.
@NoArgsConstructor //Tạo constructor không có tham số (mặc định).
@Builder //Tạo ra một builder pattern cho lớp, giúp việc tạo đối tượng dễ dàng hơn với các trường tùy chọn.
//nói cách khác: tạo constructor tùy ý
public class SinhVien {
    private String mssv;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
