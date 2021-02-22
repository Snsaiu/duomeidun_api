package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductImages {
    private  Long productImageId;
    private  Long imagPath;
    private Long parentId;
    private Date createTime;
    private Integer type;

}
