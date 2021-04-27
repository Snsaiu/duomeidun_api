package com.lmxdawn.api.admin.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductClassSoloDTO {

    private String title;
    private  String content;
    private List<ProductClassImageDTO> images;
}
