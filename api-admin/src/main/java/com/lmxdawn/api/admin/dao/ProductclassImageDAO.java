package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.ProductclassImages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductclassImageDAO {

    int Insert(ProductclassImages entity);

    boolean remove(Integer id);

    List<ProductclassImages> getAllByPid(Integer pid);



}
