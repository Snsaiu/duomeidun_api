package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Product {


    private Long productId;
    private String name;
    private String summary;
    private Date createTime;
    private Long parentId;
}
