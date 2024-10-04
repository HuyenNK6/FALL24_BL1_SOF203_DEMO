package com.b5.product.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    private Integer id;
    private String code;
    private String name;
    private Float price;
    private String description;
    private Category category;
}
