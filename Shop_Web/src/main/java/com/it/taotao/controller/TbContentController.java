package com.it.taotao.controller;

import com.it.taotao.pojo.TbContent;
import com.it.taotao.server.TbContentService;
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
    private TbContentService tbContentService;

    @RequestMapping("/findContent")
    @ResponseBody
    public TbContent findTbContentById(){
        return tbContentService.findTbContentById(1l);
    }
}