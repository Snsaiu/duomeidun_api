package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.Carousel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarouselDAO {

     List<Carousel> GetAll();

     boolean  Add(Carousel entity);

     boolean Remove(int id);

     boolean Update(Carousel entity);


}
