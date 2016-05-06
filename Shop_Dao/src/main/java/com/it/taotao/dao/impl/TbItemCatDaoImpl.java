package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemCatDao;
import com.it.taotao.dao.mapper.TbItemCatMapper;
import com.it.taotao.pojo.TbContentCategoryExample;
import com.it.taotao.pojo.TbItemCat;
import com.it.taotao.pojo.TbItemCatExample;
import com.it.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
@Repository
public class TbItemCatDaoImpl implements TbItemCatDao {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getItemCatList() {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
        return list;
    }
}
