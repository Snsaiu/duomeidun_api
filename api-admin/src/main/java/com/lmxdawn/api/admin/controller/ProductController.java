package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.dto.product.*;
import com.lmxdawn.api.admin.entity.ProductClass;
import com.lmxdawn.api.admin.entity.Product;
import com.lmxdawn.api.admin.entity.ProductclassCarouseImages;
import com.lmxdawn.api.admin.entity.ProductclassImages;
import com.lmxdawn.api.admin.service.product.ProductService;
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

    @Autowired
    private ProductService productService;


    /**
     * 添加新的产品分类
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

    @PostMapping("/updateproductclass")
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

    @PostMapping("/productclass/insertimage")
    public BaseResponse insertClassImage(ProductclassImages image)
    {
        ProductclassImages classImage = this.productClassService.inserClassImage(image);
        return  ResultVOUtils.success(classImage);
    };

    @DeleteMapping("/productclass/removeimage/{id}")
    public BaseResponse deleteClassImage(@PathVariable("id") int id)
    {
        boolean res=this.productClassService.removeClassImage(id);
        return ResultVOUtils.success(res);
    }

    @PostMapping("/productclass/insertcarouse")
    public  BaseResponse insertcarouseimage(ProductclassCarouseImages image)
    {
        ProductclassCarouseImages images = this.productClassService.insertCarouseImage(image);
        return ResultVOUtils.success(images);

    }

    @DeleteMapping("/productclass/removecaouseimage/{id}")
    public  BaseResponse removecarouseImage(@PathVariable("id") int id)
    {
        boolean res=this.productClassService.remoceCarouseimage(id);
        return ResultVOUtils.success(res);
    }

    @GetMapping("/productclass/getimagecarouse/{pid}")
    public  BaseResponse getimageCarouseByid(@PathVariable("pid") int pid)
    {
        List<ProductClassImageDTO> getproductimagebypid = this.productClassService.getproductimagebypid(pid);
        return ResultVOUtils.success(getproductimagebypid);
    }


    /**
     * 查看指定分类下是否有产品
     * @param id 产品分类
     * @return
     */
    @GetMapping("/productclass/{id}/existproducts")
    public BaseResponse checkClassHasProduct(@PathVariable("id") Long id)
    {
       boolean res= this.productService.listProductCountByParentId(id);
        Map<String,Object> resmap=new HashMap<>();
        resmap.put("entity",res);
        return ResultVOUtils.success(resmap);
    }

    @GetMapping("/product/solo/{id}")
    public  BaseResponse getproductsolobyid(@PathVariable("id") Long id)
    {
        ProductClassSoloDTO res = this.productClassService.getproductsolobyid(Math.toIntExact(id));
        return ResultVOUtils.success(res);

    }

    @GetMapping("/product/search/{param}")
    public  BaseResponse searchProduct(@PathVariable("param") String param)
    {
        List<SearchProductDTO> res = this.productClassService.Search(param);
        return ResultVOUtils.success(res);
    }





//    /**
//     * 添加产品
//     * @param product
//     * @return
//     */
//    @PostMapping("/product")
//    public  BaseResponse insertProduct(Product product)
//    {
//
//    }


}
