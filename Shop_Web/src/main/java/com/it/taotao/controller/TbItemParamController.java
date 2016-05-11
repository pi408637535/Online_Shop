package com.it.taotao.controller;

import com.it.taotao.server.TbItemParamService;
import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 55 on 2016/5/11.
 */
@Controller
@RequestMapping("/item/param")
public class TbItemParamController {

    @Autowired
    TbItemParamService tbItemParamService;

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemParam(@PathVariable Long cid){
        return  tbItemParamService.getTbItemParamByItemCatId(cid);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemParamList(int page, int rows){
        return tbItemParamService.getItemParamList(page, rows);
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult saveItemParam(@PathVariable Long cid, String paramData){
        return tbItemParamService.saveTbItemParam(cid, paramData);
    }
}
