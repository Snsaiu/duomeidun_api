package com.lmxdawn.api.admin.service.productClass.impl;

import com.lmxdawn.api.admin.dao.ProductClassDao;
import com.lmxdawn.api.admin.dto.product.ProductClassDto;
import com.lmxdawn.api.admin.dto.product.UpdateProductClassDTO;
import com.lmxdawn.api.admin.entity.ProductClass;
import com.lmxdawn.api.admin.service.productClass.ProductClassService;
import com.lmxdawn.api.admin.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductClassServiceImpl implements ProductClassService {

    @Autowired
    private ProductClassDao productClassDao;

    @Override
    public ProductClass InsertProductClass(ProductClass entity) {
      this.productClassDao.Insert(entity);

        return  entity;
    }

    @Override
    public ProductClassDto GetProductClasses() {
        List<ProductClass> all = this.productClassDao.GetAll();
        if (all.size()!=0)
        {
            Map<Long, List<ProductClass>> collect = all.stream().collect(Collectors.groupingBy(ProductClass::getParentId));
            if (collect.size()==0)
                return  null;

           Map<Long,List<ProductClassDto>> res_collect=new HashMap<>();

           collect.forEach((key,value)->{

               List<ProductClassDto> temp=new ArrayList<>();

               value.forEach(item->{
                   ProductClassDto p=new ProductClassDto();
                   p.setName(item.getName());
                   p.setId(item.getProclassId());
                   p.setSummary(item.getSummary());
                   p.setParentId(key);
                 temp.add(p);
               });
               res_collect.put(key,temp);
           });

           ProductClassDto root=res_collect.get(Long.valueOf(0)).get(0);

            TreeUtils.ConvertProductClassToTree(res_collect,root);
            return root;

        }
        return null;
    }


    @Override
    public boolean updateProductClass(UpdateProductClassDTO entity) {
        return this.productClassDao.updateProductClass(entity);
    }

    @Override
    public boolean deleteProductClassWithChildren(Long id) {
        return this.productClassDao.deleteProdoctClassWithChildren(id);
    }
}
