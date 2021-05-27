package com.lmxdawn.api.admin.entity;

import lombok.Data;

@Data
public class Agent {

    private int id;

    private String name;

    private String phone;
    private String area;
    private  String branded;
    private String summary;
    private int state;
}
