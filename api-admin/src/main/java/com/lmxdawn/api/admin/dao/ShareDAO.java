package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.Share;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShareDAO {

    List<Share> listShare();

    int insert(@Param("entity") Share entity);

    boolean delete(@Param("id") int id);




}
