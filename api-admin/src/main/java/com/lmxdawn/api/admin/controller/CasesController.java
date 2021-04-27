package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.dao.CasesDAO;
import com.lmxdawn.api.admin.dto.CreateCaseDTO;
import com.lmxdawn.api.admin.entity.Cases;
import com.lmxdawn.api.admin.entity.Video;
import com.lmxdawn.api.common.enums.ResultEnum;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class CasesController {

    @Autowired
    private CasesDAO casesDAO;

    @PostMapping("/cases")
    public BaseResponse Insert(MultipartFile file, CreateCaseDTO video)
    {

        if (file.isEmpty())
        {
            return ResultVOUtils.error(ResultEnum.DATA_NOT);
        }


        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = System.getProperty("user.dir")+"/video/"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/api/video/" + fileName;

        Cases cases=new Cases();
        cases.setVideoPath(filename);
        cases.setSummary(video.getSummary());
        cases.setCreateTime(new Date());
        cases.setTitle(video.getTitle());
        cases.setKeywords(video.getKeywords());
        cases.setImg(video.getImg());
        int id= this.casesDAO.Insert(cases);
        cases.setCaseId(id);
        return ResultVOUtils.success(cases);

    }


    @GetMapping("/cases/all")
    public BaseResponse Getall()
    {
        List<Cases> cases = this.casesDAO.Getall();
        return ResultVOUtils.success(cases);

    }

    @DeleteMapping("/cases/{id}")
    public BaseResponse DeleteById(@PathVariable("id") int id)
    {
       return ResultVOUtils.success( this.casesDAO.DeleteById(id));
    }



}
