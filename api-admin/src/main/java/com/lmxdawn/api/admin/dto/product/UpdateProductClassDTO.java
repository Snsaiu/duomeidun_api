package com.lmxdawn.api.admin.dto.product;

import lombok.Data;

@Data
public class UpdateProductClassDTO {

    private Long id;
    private String name;
    private String summary;
    private  String title;
    private  String content;
}
