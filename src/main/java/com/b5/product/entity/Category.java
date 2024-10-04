package com.b5.product.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {
    private Integer id;
    private String code;
    private String name;
}
