package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemParamDao;
import com.it.taotao.dao.mapper.TbItemParamMapper;
import com.it.taotao.pojo.TbItemDesc;
import com.it.taotao.pojo.TbItemParam;
import com.it.taotao.pojo.TbItemParamExample;
import com.it.train.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Created by 55 on 2016/5/11.
 */
@Repository
public class TbItemParamDaoImpl implements TbItemParamDao {
    @Autowired
    TbItemParamMapper tbItemParamMapper;


    @Override
    public TbItemParam getTbItemDescByItemCatId(Long itemCatId) {
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria =tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(itemCatId);
        List<TbItemParam> listTbTtemParam = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        if(CollectionUtil.isEmpty(listTbTtemParam)){
            return null;
        }else{
            return listTbTtemParam.get(0);
        }
    }

    @Override
    public List<TbItemParam> getItemParamList() {
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        return tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
    }

    @Override
    public int saveTbItemParam(TbItemParam tbItemParam) {
        return tbItemParamMapper.insert(tbItemParam);
    }
}
