package com.lmxdawn.api.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetailDTO {



    private String title;
    private String summary;
    private List<String> imgs;

}
