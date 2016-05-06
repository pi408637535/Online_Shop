package com.it.taotao.controller;

import com.it.taotao.server.TbItemService;
import com.it.train.po.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 55 on 2016/5/6.
 */
@Controller
@RequestMapping("/item")
public class TbItemController {

    @Autowired
    TbItemService tbItemService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemList(int page, int rows){
        return  tbItemService.getItemList(page,rows);
    }
}
