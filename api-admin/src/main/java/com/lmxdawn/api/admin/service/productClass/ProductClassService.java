package com.lmxdawn.api.admin.service.productClass;

import com.lmxdawn.api.admin.dto.product.ProductClassDto;
import com.lmxdawn.api.admin.dto.product.ProductClassImageDTO;
import com.lmxdawn.api.admin.dto.product.ProductClassSoloDTO;
import com.lmxdawn.api.admin.dto.product.UpdateProductClassDTO;
import com.lmxdawn.api.admin.entity.ProductClass;
import com.lmxdawn.api.admin.entity.ProductclassCarouseImages;
import com.lmxdawn.api.admin.entity.ProductclassImages;

import java.util.List;


public interface ProductClassService {

    ProductClass InsertProductClass(ProductClass entity);

    ProductClassDto GetProductClasses();

    boolean updateProductClass(UpdateProductClassDTO entity);

    boolean deleteProductClassWithChildren(Long id);

    ProductclassImages inserClassImage(ProductclassImages entity);

    boolean removeClassImage(int id);

    ProductclassCarouseImages insertCarouseImage(ProductclassCarouseImages entity);

    boolean  remoceCarouseimage(int id);

    List<ProductClassImageDTO> getproductimagebypid(int pid);

    ProductClassSoloDTO getproductsolobyid(int id);

}
