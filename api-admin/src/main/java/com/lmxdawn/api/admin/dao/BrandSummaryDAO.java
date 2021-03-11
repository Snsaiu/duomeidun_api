package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.BrandSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BrandSummaryDAO {

    BrandSummary GetBrandSummaryById(@Param("id") int id);

    boolean UpdateSummary( BrandSummary entity);

}
