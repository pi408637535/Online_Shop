package com.it.taotao.controller;

import com.it.taotao.server.TbContentCategoryService;
import com.it.train.po.EasyUITreeNode;
import com.it.train.po.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 55 on 2016/5/12.
 */
@Controller
@RequestMapping("/content/category")
public class TbContentCategoryController {
    @Autowired
    TbContentCategoryService tbContentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getEasyUITreeNode(@RequestParam(value="id", defaultValue = "0")Long pid){
       return tbContentCategoryService.getEasyUITreeNode(pid);
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createEasyUITreeNode(Long parentId, String name){
       return tbContentCategoryService.createEasyUITreeNode(parentId, name);
    }

}
