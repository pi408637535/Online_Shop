package com.it.taotao.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.it.taotao.server.PictureService;
import com.it.train.po.PictureResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 55 on 2016/5/10.
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public PictureResult uploadFile(MultipartFile uploadFile) {
        PictureResult result = pictureService.uploadPicure(uploadFile);
        return  result;
    //    return JSONUtils.toJSONString(result);
    }

}
