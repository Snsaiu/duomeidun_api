package com.lmxdawn.api.admin.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Carousel {

    @Id
    private long caro_id;
    private String title;
    private String content;
    private Date createTime;
    private String imgPath;
    private long productClassId;

}
