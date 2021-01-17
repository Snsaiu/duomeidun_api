package com.lmxdawn.api.admin.service.productClass;

import com.lmxdawn.api.admin.dto.product.ProductClassDto;
import com.lmxdawn.api.admin.dto.product.UpdateProductClassDTO;
import com.lmxdawn.api.admin.entity.ProductClass;

import java.util.List;


public interface ProductClassService {

    ProductClass InsertProductClass(ProductClass entity);

    ProductClassDto GetProductClasses();

    boolean updateProductClass(UpdateProductClassDTO entity);

    boolean deleteProductClassWithChildren(Long id);

}
