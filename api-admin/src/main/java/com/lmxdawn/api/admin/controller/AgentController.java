package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.entity.Agent;
import com.lmxdawn.api.admin.entity.AgentContent;
import com.lmxdawn.api.admin.service.agent.AgentService;
import com.lmxdawn.api.common.enums.ResultEnum;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;


    @PostMapping("/agent")
    public BaseResponse InsertAgent(Agent agent)
    {

        this.agentService.Add(agent);
        return ResultVOUtils.success();
    }

    @GetMapping("/agentcontent")
    public  BaseResponse GetContent()
    {
        String content = this.agentService.GetContent();
        return ResultVOUtils.success(content);
    }

    @PostMapping("/agentcontent")
    public BaseResponse UpdateContent(AgentContent content)
    {
        boolean res = this.agentService.UpdateContent(content);
        if(res)
            return ResultVOUtils.success();
        else
            return ResultVOUtils.error(ResultEnum.DATA_CHANGE,"提交失败");


    }

    @PostMapping("/agentcontentImage")
    public  String AgentContentImage(MultipartFile file, HttpServletRequest request)
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

    @GetMapping("/agents")
    public BaseResponse GetAgents()
    {
        return ResultVOUtils.success(this.agentService.AgentList());
    }

    @PostMapping("/agentupdate")
    public  BaseResponse Update(Agent entity)
    {
        boolean updateres= this.agentService.Update(entity);

        return ResultVOUtils.success();
    }

}
