package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.ServiceClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceClassDAO {

    int insert(ServiceClass entity);


    boolean remove(int id);

    boolean update(ServiceClass entity);

    List<ServiceClass> getall();
    ServiceClass getbyid(int id);

}
