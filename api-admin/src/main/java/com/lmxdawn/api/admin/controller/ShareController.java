package com.lmxdawn.api.admin.controller;

import com.lmxdawn.api.admin.entity.Share;
import com.lmxdawn.api.admin.service.share.ShareService;
import com.lmxdawn.api.common.enums.ResultEnum;
import com.lmxdawn.api.common.res.BaseResponse;
import com.lmxdawn.api.common.util.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShareController {

    @Autowired
    private ShareService shareService;


    @GetMapping("/share")
    public BaseResponse get()
    {
        List<Share> res= this.shareService.listShare();
        Map<String ,Object> resmap=new HashMap<>();
        resmap.put("entity",res);
        return ResultVOUtils.success(resmap);
    }

    @PostMapping("/share")
    public BaseResponse post(Share entity)
    {
        int res= this.shareService.insert(entity);
        if (res>=0)
        {
            Map<String ,Object> resmap=new HashMap<>();
            resmap.put("id",res);
            return ResultVOUtils.success(resmap);
        }
        else{
            return ResultVOUtils.error(ResultEnum.DATA_INSERT_FALL);
        }
    }

    @DeleteMapping("/share/{id}")
    public BaseResponse delete(@PathVariable("id") int id)
    {
        boolean res= this.shareService.delete(id);
        if (res)
            return ResultVOUtils.success();
        return ResultVOUtils.error(ResultEnum.DATA_DELETE_FALL);
    }

}
