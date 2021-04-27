package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductclassCarouseImages {
    private Integer pccimageId;
    private String title;
    private String summary;
    private String image;
    private Date createTime;
    private  int pid;
}
