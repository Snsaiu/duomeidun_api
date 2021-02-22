package com.lmxdawn.api.admin.service.carouel;

import com.lmxdawn.api.admin.entity.Carousel;

import java.util.List;

public interface CarouselService {
     boolean Insert(Carousel entity);
    boolean Update(Carousel entity);
    List<Carousel> GetAll();
    boolean Delete(int id);

}
