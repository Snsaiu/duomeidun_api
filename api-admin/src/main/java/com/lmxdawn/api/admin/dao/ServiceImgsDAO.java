package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.ServiceImgs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceImgsDAO {
    int insert(ServiceImgs entity);
    boolean remove(int pid);
    List<ServiceImgs> getallbyid(int pid);
    boolean removebyid(int id);
}
