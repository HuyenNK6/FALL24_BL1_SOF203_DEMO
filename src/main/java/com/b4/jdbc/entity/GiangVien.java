package com.b4.jdbc.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class GiangVien {
    private String maGV;
    private String ten;
    private String loai;
    private int tuoi;
    private int bac;
    private boolean gioiTinh;
}
