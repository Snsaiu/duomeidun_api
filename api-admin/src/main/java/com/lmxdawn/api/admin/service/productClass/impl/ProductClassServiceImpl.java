package com.lmxdawn.api.admin.service.productClass.impl;

import com.lmxdawn.api.admin.dao.ProductClassDAO;
import com.lmxdawn.api.admin.dao.ProductclassCarouseImagesDAO;
import com.lmxdawn.api.admin.dao.ProductclassImageDAO;
import com.lmxdawn.api.admin.dto.product.*;
import com.lmxdawn.api.admin.entity.ProductClass;
import com.lmxdawn.api.admin.entity.ProductclassCarouseImages;
import com.lmxdawn.api.admin.entity.ProductclassImages;
import com.lmxdawn.api.admin.service.productClass.ProductClassService;
import com.lmxdawn.api.admin.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.AssertFalse;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductClassServiceImpl implements ProductClassService {

    @Autowired
    private ProductClassDAO productClassDao;
    @Autowired
    private ProductclassImageDAO productclassImageDAO;
    @Autowired
    private ProductclassCarouseImagesDAO productclassCarouseImagesDAO;

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
    public List<SearchProductDTO> Search(String keyword) {

        ProductClassDto all = this.GetProductClasses();
        if(all.getChildren().size()==0)
            return null;

        List<ProductClassDto> outs=new ArrayList<>();
        this.childsearch(all.getChildren(),outs,keyword, false);

        List<SearchProductDTO> res=new ArrayList<>();
        for (ProductClassDto item: outs) {

            // 根据id获得图片
            String img= this.productclassImageDAO.getImageByPid((int) item.getId());
            SearchProductDTO s=new SearchProductDTO();
            s.setImage(img);
            s.setId(item.getId());
            s.setName(item.getName());
            s.setSummary(item.getSummary());
            res.add(s);
        }

        return res;






    }

    private void childsearch(List<ProductClassDto> source, List<ProductClassDto> out, String keyword, boolean need)
    {

        for (ProductClassDto item :
                source) {
            if(need)
            {
                if(item.getChildren()==null||item.getChildren().size()==0)
                {
                    out.add(item);
                }
                else{
                    this.childsearch(item.getChildren(),out,keyword,true);
                }
            }

            else if(item.getName().contains(keyword)||item.getSummary().contains(keyword))
            {
               if(item.getChildren()==null||item.getChildren().size()==0)
               {
                   out.add(item);
               }
               else{
                   this.childsearch(item.getChildren(),out,keyword,true);
               }
            }
        }

    }



    @Override
    public boolean updateProductClass(UpdateProductClassDTO entity) {
        return this.productClassDao.updateProductClass(entity);
    }

    @Override
    public boolean deleteProductClassWithChildren(Long id) {
        return this.productClassDao.deleteProdoctClassWithChildren(id);
    }

    @Override
    public ProductclassImages inserClassImage(ProductclassImages entity) {
       entity.setCreateTime(new Date());
       int res= this.productclassImageDAO.Insert(entity);
       entity.setPid(res);
       return entity;
    }

    @Override
    public boolean removeClassImage(int id) {
        return this.productclassImageDAO.remove(id);
    }

    @Override
    public ProductclassCarouseImages insertCarouseImage(ProductclassCarouseImages entity) {
       entity.setCreateTime(new Date());
        int insert = this.productclassCarouseImagesDAO.insert(entity);
        entity.setPccimageId(insert);
        return entity;
    }

    @Override
    public boolean remoceCarouseimage(int id) {
        return this.productclassCarouseImagesDAO.remove(id);
    }

    @Override
    public List<ProductClassImageDTO> getproductimagebypid(int pid) {

        List<ProductClassImageDTO> res=new ArrayList<>();
        List<ProductclassImages> images = this.productclassImageDAO.getAllByPid(pid);
        for (ProductclassImages item:
             images) {

            ProductClassImageDTO i=new ProductClassImageDTO();
            i.setImage(item.getImage());
            i.setPid(pid);
            i.setId(item.getPcimageId());
            i.setType(1);

            res.add(i);
        }
        List<ProductclassCarouseImages> carouses = this.productclassCarouseImagesDAO.getListByPid(pid);
        for (ProductclassCarouseImages item :
                carouses) {
            ProductClassImageDTO i=new ProductClassImageDTO();
            i.setImage(item.getImage());
            i.setPid(pid);
            i.setTitle(item.getTitle());
            i.setSummary(item.getSummary());
            i.setId(item.getPccimageId());
            i.setType(0);

            res.add(i);
        }
        return res;

    }

    @Override
    public ProductClassSoloDTO getproductsolobyid(int id) {

        ProductClassSoloDTO res=new ProductClassSoloDTO();
        ProductClass aClass = this.productClassDao.getbyid(id);
        res.setTitle(aClass.getTitle());
        res.setContent(aClass.getContent());
         res.setImages( getproductimagebypid(id));
         return res;

    }
}
