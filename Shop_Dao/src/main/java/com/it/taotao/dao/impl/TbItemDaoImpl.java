package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemDao;
import com.it.taotao.dao.mapper.TbItemMapper;
import com.it.taotao.pojo.TbItem;
import com.it.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
@Repository
public class TbItemDaoImpl implements TbItemDao {

    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> getItemList() {
        TbItemExample tbItemExample = new TbItemExample();
        return tbItemMapper.selectByExample(tbItemExample);
    }
}
