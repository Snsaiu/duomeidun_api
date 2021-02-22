package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.annotation.AuthRuleAnnotation;
import com.lmxdawn.api.admin.entity.Carousel;
import com.lmxdawn.api.admin.service.carouel.CarouselService;
import com.lmxdawn.api.common.enums.ResultEnum;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @AuthRuleAnnotation("carousel")
    @PostMapping("carousel")
    public BaseResponse InsertCarousel(Carousel entity)
    {
        entity.setCreateTime(new Date());
       boolean res= this.carouselService.Insert(entity);
       if (res)
           return ResultVOUtils.success();
       return ResultVOUtils.error(ResultEnum.DATA_INSERT_FALL);
    }

    @GetMapping("carousel")
    public BaseResponse GetAll()
    {
        List<Carousel> res= this.carouselService.GetAll();
        Map<String,Object> map=new HashMap<>();
        map.put("carousels",res);
        return ResultVOUtils.success(res);
    }



    @DeleteMapping("carousel/{id}")
    public BaseResponse Delete(@PathVariable("id") int id)
    {
        boolean res= this.carouselService.Delete(id);
        if (res)
        {
            return ResultVOUtils.success();
        }
        return ResultVOUtils.error(ResultEnum.DATA_NOT);
    }



}
