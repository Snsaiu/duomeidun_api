package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.dao.ServiceClassDAO;
import com.lmxdawn.api.admin.dao.ServiceImgsDAO;
import com.lmxdawn.api.admin.dto.ServiceDetailDTO;
import com.lmxdawn.api.admin.entity.ServiceClass;
import com.lmxdawn.api.admin.entity.ServiceImgs;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceClassDAO serviceClassDAO;

    @Autowired
    private ServiceImgsDAO serviceImgsDAO;

    @GetMapping("/services")
    public BaseResponse GetClasses()
    {
        List<ServiceClass> all = this.serviceClassDAO.getall();
        return ResultVOUtils.success(all);
    }

    @PostMapping("/services")
    public  BaseResponse InsertClass(ServiceClass entity)
    {
        int id= this.serviceClassDAO.insert(entity);
        return ResultVOUtils.success(id);
    }

    @DeleteMapping("/services/{id}")
    public BaseResponse DeleteClass(@PathVariable("id") int id)
    {
        this.serviceClassDAO.remove(id);
        this.serviceImgsDAO.remove(id);
        return ResultVOUtils.success();
    }

    @PostMapping("/services/insertimage")
    public  BaseResponse InsertImage(ServiceImgs entity)
    {
            entity.setCreateTime(new Date());
            int id= this.serviceImgsDAO.insert(entity);
            entity.setServiceimgId(id);
            return ResultVOUtils.success(entity);
    }

    @GetMapping("/services/img/{pid}")
    public BaseResponse GetServiceImgsByPid(@PathVariable("pid") int pid)
    {
        List<ServiceImgs> imgs = this.serviceImgsDAO.getallbyid(pid);
        return ResultVOUtils.success(imgs);

    }
    @DeleteMapping("/services/img/{id}")
    public BaseResponse deleteimgbyid(@PathVariable("id") int id)
    {
    this.serviceImgsDAO.removebyid(id);
    return ResultVOUtils.success();

    }
    @GetMapping("/services/detail/{id}")
    public  BaseResponse gettypeAimgsbyid(@PathVariable("id") int id)
    {
        ServiceClass type = this.serviceClassDAO.getbyid(id);
        List<ServiceImgs> imgs = this.serviceImgsDAO.getallbyid(id);
        List<String> reimgs=new ArrayList<>();
        for (ServiceImgs item :
                imgs) {
            reimgs.add(item.getImg());
        }
        ServiceDetailDTO res=new ServiceDetailDTO(type.getTitle(),type.getSummary(),reimgs);
        return ResultVOUtils.success(res);

    }

}
