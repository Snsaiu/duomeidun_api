package com.lmxdawn.api.admin.dto.product;

import lombok.Data;

@Data
public class ProductClassImageDTO {
    // 0 liu  1 lun
    private int type;
    private int id;
    private String title;
    private String summary;
    private  String image;
    private  int pid;

}
