package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ServiceImgs {

    private int serviceimgId;
    private String img;
    private Date createTime;
    private  int pid;
}
