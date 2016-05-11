package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemParamItemDao;
import com.it.taotao.dao.mapper.TbItemParamItemMapper;
import com.it.taotao.pojo.TbItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 55 on 2016/5/11.
 */
@Repository
public class TbItemParamItemDaoImpl implements TbItemParamItemDao {
    @Autowired
    TbItemParamItemMapper tbItemParamItemMapper;

    @Override
    public int saveTbItemParamItem(TbItemParamItem tbItemParamItem) {
        return tbItemParamItemMapper.insert(tbItemParamItem);
    }
}
