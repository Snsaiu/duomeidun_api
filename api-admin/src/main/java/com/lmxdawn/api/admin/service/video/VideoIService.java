package com.lmxdawn.api.admin.service.video;

import com.lmxdawn.api.admin.entity.Video;

import java.util.List;

public interface VideoIService {

    List<Video> GetByTypeId(int id);

    boolean UpdateByTypeId(Video entity);

    boolean DeleteById(int id);

    int Insert(Video entity);
}
