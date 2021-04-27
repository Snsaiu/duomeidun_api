package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductclassImages {

    private Integer pcimageId;
    private  Integer pid;
    private String image;
    private Date createTime;
}
