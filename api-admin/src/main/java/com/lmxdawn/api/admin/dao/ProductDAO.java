package com.lmxdawn.api.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDAO {


    /**
     * 获得当前产品分类下的产品数量
     * @param id 产品分类id
     * @return
     */
    Long listProductCountByParentId(Long id);
}
