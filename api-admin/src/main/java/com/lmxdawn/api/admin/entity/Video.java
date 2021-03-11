package com.lmxdawn.api.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Video {

    private int  videoId;
    private String videoPath;
    private Date updateTime;
    private int typeId;
    private String title;
    private String summary;

}
