package com.it.taotao.controller;

import com.it.taotao.pojo.TbItem;
import com.it.taotao.server.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 55 on 2016/5/9.
 */
@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
    @Autowired
    TbItemCatService tbItemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List getCategoryList(@RequestParam(value="id", defaultValue = "0")Long parentId) {
        return tbItemCatService.getItemCatList(parentId);
    }
}
