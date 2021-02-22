package com.lmxdawn.api.admin.service.product.impl;

import com.lmxdawn.api.admin.dao.ProductDAO;
import com.lmxdawn.api.admin.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public boolean listProductCountByParentId(Long id) {
       return this.productDAO.listProductCountByParentId(id)>0?true:false;
    }
}
