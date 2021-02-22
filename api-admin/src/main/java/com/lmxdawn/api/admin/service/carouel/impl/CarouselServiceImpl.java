package com.lmxdawn.api.admin.service.carouel.impl;

import com.lmxdawn.api.admin.dao.CarouselDAO;
import com.lmxdawn.api.admin.entity.Carousel;
import com.lmxdawn.api.admin.service.carouel.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDAO carouselDao;

    /**
     * 添加轮播图
     * @param entity 轮播图实体
     * @return 成功返回true，否则返回false
     */
    @Override
    public boolean Insert(Carousel entity) {

      return this.carouselDao.Add(entity);
    }

    @Override
    public boolean Update(Carousel entity) {
        return this.carouselDao.Update(entity);
    }

    @Override
    public List<Carousel> GetAll() {
        return this.carouselDao.GetAll();
    }

    @Override
    public boolean Delete(int id) {
        return this.carouselDao.Remove(id);
    }
}
