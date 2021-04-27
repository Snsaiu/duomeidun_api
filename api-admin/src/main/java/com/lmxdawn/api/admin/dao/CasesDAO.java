package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.Cases;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CasesDAO {

    int Insert(Cases entity);

    List<Cases> GetByPage(int start,int end);

    boolean DeleteById(int id);
    List<Cases> Getall();



}
