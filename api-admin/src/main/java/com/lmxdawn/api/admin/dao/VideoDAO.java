package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoDAO {

    List<Video> GetByTypeId(@Param("id") int id);

    boolean UpdateById(@Param("entity") Video entity);

    boolean DeleteByTypeId(@Param("id") int id);
    int Insert( Video entity);



}
