package com.lmxdawn.api.admin.util;

import com.lmxdawn.api.admin.dto.product.ProductClassDto;
import com.lmxdawn.api.admin.entity.ProductClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 树形结构工具类
 */
public class TreeUtils{


    public static void ConvertProductClassToTree(Map<Long,List<ProductClassDto>> collect,ProductClassDto treeMenuNode)
    {
        List<ProductClassDto> treeMenuNodes = collect.get(treeMenuNode.getId());
        if(collect.get(treeMenuNode.getId())!=null){
            //排序
            treeMenuNode.setChildren(treeMenuNodes);
            treeMenuNode.getChildren().forEach(t->{
                ConvertProductClassToTree(collect,t);
            });
        }
    };

}
