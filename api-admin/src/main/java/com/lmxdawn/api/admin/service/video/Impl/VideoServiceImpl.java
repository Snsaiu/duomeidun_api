package com.lmxdawn.api.admin.service.video.Impl;

import com.lmxdawn.api.admin.dao.VideoDAO;
import com.lmxdawn.api.admin.entity.Video;
import com.lmxdawn.api.admin.service.video.VideoIService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoIService {

    @Autowired
    private VideoDAO videoDAO;

    @Override
    public List<Video> GetByTypeId(int id) {
      return   this.videoDAO.GetByTypeId(id);
    }

    @Override
    public boolean UpdateByTypeId(Video entity) {
       return this.videoDAO.UpdateById(entity);
    }

    @Override
    public boolean DeleteById(int id) {
        return this.videoDAO.DeleteByTypeId(id);
    }

    @Override
    public int Insert(Video entity) {
        if(entity.getTypeId()==-1)
        {
            var temps= this.videoDAO.GetByTypeId(-1);
            if(temps.size()!=0)
            {
               int id= temps.get(0).getVideoId();
               entity.setVideoId(id);
               this.videoDAO.UpdateById(entity);
               return id;
            }

        }
        return this.videoDAO.Insert(entity);

    }
}
