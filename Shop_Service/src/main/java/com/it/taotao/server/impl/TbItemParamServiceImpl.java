package com.it.taotao.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.taotao.dao.TbItemParamDao;
import com.it.taotao.pojo.TbItemParam;
import com.it.taotao.server.TbItemParamService;
import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 55 on 2016/5/11.
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    @Autowired
    TbItemParamDao tbItemParamDao;

    @Override
    public TaotaoResult getTbItemParamByItemCatId(Long itemCatId) {
        TaotaoResult taotaoResult = new TaotaoResult();
        TbItemParam tbItemParam = tbItemParamDao.getTbItemDescByItemCatId(itemCatId);
      /*  taotaoResult.setStatus(200);
        taotaoResult.setData(tbItemParam);*/
        if(tbItemParam != null){
            return  TaotaoResult.ok(tbItemParam);
        }else{
            return TaotaoResult.ok();
        }
    }

    @Override
    public EasyUIResult getItemParamList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //获取数据
        List<TbItemParam> listTbItemParam = tbItemParamDao.getItemParamList();
        //取分页信息
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(listTbItemParam);
        //返回处理结果
        EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), listTbItemParam);
        return result;
    }

    @Override
    public TaotaoResult saveTbItemParam(Long itemCatId, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        Date date = new Date();
        tbItemParam.setItemCatId(itemCatId);
        tbItemParam.setParamData(paramData);
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        int result = tbItemParamDao.saveTbItemParam(tbItemParam);
        if(result != 1){
            return TaotaoResult.build(500, "save tbItemParam error");
        }else{
            return TaotaoResult.ok();
        }
    }


}
