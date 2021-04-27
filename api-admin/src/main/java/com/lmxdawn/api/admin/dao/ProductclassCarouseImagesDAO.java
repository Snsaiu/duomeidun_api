package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.ProductclassCarouseImages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductclassCarouseImagesDAO {
    int insert(ProductclassCarouseImages image);
    boolean remove(int id);
    List<ProductclassCarouseImages> getListByPid(int pid);
}
