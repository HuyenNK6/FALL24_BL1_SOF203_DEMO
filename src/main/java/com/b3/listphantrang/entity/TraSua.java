package com.b3.listphantrang.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TraSua {
    private String ma;
    private String vi;
    private int gia;
    private char size;
    private String thuongHieu;
}
