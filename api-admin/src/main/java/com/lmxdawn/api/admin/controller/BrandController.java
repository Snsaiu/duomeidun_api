package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.dto.VideoDTO;
import com.lmxdawn.api.admin.entity.BrandSummary;
import com.lmxdawn.api.admin.entity.Video;
import com.lmxdawn.api.admin.service.brandsummary.BrandSummaryIService;
import com.lmxdawn.api.admin.service.video.VideoIService;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
public class BrandController {

    @Autowired
    private BrandSummaryIService brandSummaryIService;

    @Autowired
    private VideoIService videoIService;

    @GetMapping("/brandsummary/{id}")
    public BaseResponse GetSummary(@PathVariable("id") int id)
    {
        BrandSummary brandSummary = this.brandSummaryIService.GetById(id);
        return ResultVOUtils.success(brandSummary);
    }

    @PostMapping("/brandsummary")
    public BaseResponse UpdateSummary(BrandSummary entity)
    {
        boolean res=this.brandSummaryIService.UpdateBrandSummary(entity);
        return ResultVOUtils.success(res);
    }



    @PostMapping("/brandImage")
    public  String UploadBrandImage(MultipartFile file, HttpServletRequest request)
    {
        if (file.isEmpty())
        {
            return "";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = System.getProperty("user.dir")+"/image/"; // 上传后的路径
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
        String filename = "/api/image/" + fileName;
        return filename;
    }


    @PostMapping("/uploadvideo")
    public String UploadVideo(MultipartFile file, VideoDTO video)
    {
        if (file.isEmpty())
        {
            return "";
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
        Video v=new Video();
        v.setVideoPath(filename);
        v.setTitle(video.getTitle());
        v.setTypeId(video.getType());
        v.setSummary(video.getSummary());
        v.setUpdateTime(new Date());
        this.videoIService.Insert(v);
        return filename;
    }




}
