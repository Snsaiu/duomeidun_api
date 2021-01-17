package com.lmxdawn.api.admin.dto.product;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductClassDto {

    public ProductClassDto() {
        this.children=new ArrayList<>();
    }

    private long id;
    private String name;
    private long parentId;
    private String summary;
    private List<ProductClassDto> children;

}
