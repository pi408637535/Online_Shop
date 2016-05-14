package com.it.taotao.controller;

import com.it.taotao.pojo.TbContent;
import com.it.taotao.server.TbContentServer;
import com.it.taotao.server.TbContentService;
import com.it.train.po.EasyUIResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 55 on 5/3/2016.
 */

@Controller
@RequestMapping("/content")
public class TbContentController {
    @Resource
    private TbContentServer tbContentService;

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIResult getContentList(Long categoryId,int page, int rows){
        return  tbContentService.getTbContentList(categoryId, page, rows);
    }

}
