package com.lmxdawn.api.admin.dto.product;

import lombok.Data;

import java.util.Date;

@Data
public class InsertProductDTO {

    private Long productId;
    private String name;
    private String summary;
    private Date createTime;
    private Long parentId;

}
