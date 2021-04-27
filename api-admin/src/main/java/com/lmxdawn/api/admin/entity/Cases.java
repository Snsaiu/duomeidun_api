package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Cases {

    private int caseId;
    private String title;
    private  String summary;
    private  String img;
    private String  videoPath;
    private String keywords;
    private Date createTime;
}
