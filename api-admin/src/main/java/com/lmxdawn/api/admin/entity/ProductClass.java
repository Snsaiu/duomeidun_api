package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductClass {

    private long proclassId;
    private String name;
    private  String summary;
    private Date createTime;
    private  long parentId;
    private  String title;
    private  String content;


}
