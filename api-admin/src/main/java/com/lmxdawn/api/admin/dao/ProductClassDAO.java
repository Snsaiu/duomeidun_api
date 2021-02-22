package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.dto.product.UpdateProductClassDTO;
import com.lmxdawn.api.admin.entity.ProductClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductClassDAO {

    long Insert(ProductClass entity);

    List<ProductClass> GetAll();

    boolean updateProductClass(UpdateProductClassDTO entity);

    boolean deleteProdoctClassWithChildren(Long id);


}
