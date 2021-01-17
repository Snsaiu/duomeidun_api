package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.dto.product.ProductClassDto;
import com.lmxdawn.api.admin.dto.product.UpdateProductClassDTO;
import com.lmxdawn.api.admin.entity.ProductClass;
import com.lmxdawn.api.admin.service.productClass.ProductClassService;
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
public class ProductController {

    @Autowired
    private ProductClassService productClassService;


    /**
     * 插入广告分类
     * @param entity
     * @return
     */
    @PostMapping("/productclass")
    public BaseResponse InsertProductClass(ProductClass entity)
    {
        entity.setCreateTime(new Date());
        ProductClass resentity= this.productClassService.InsertProductClass(entity);
        Map<String ,Object> resmap=new HashMap<>();
        resmap.put("entity",resentity);
        return ResultVOUtils.success(resmap);

    }
    @GetMapping("/productclass")
    public  BaseResponse GetProductClasses()
    {
        ProductClassDto res = this.productClassService.GetProductClasses();
        Map<String,Object> resmap=new HashMap<>();
        resmap.put("entity",res);
        return ResultVOUtils.success(resmap);
    }

    @PutMapping("/productclass")
    public BaseResponse UpdateProductClass(UpdateProductClassDTO entity)
    {
        boolean update_res=this.productClassService.updateProductClass(entity);
        if (update_res)
            return ResultVOUtils.success();
        return ResultVOUtils.error(ResultEnum.DATA_UPDATE_FALL);
    }


    @DeleteMapping("/productclass/{id}")
    public BaseResponse deleteProductClassWithChildren(@PathVariable("id") Long id)
    {
        boolean update_res=this.productClassService.deleteProductClassWithChildren(id);
        if (update_res)
            return ResultVOUtils.success();
        return ResultVOUtils.error(ResultEnum.DATA_DELETE_FALL);
    }

}
