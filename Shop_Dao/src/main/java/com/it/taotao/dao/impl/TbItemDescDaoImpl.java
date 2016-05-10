package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemDescDao;
import com.it.taotao.dao.mapper.TbItemDescMapper;
import com.it.taotao.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 55 on 2016/5/10.
 */
@Repository
public class TbItemDescDaoImpl implements TbItemDescDao {

    @Autowired
    TbItemDescMapper tbItemDescMapper;

    @Override
    public int insertTbItemDesc(TbItemDesc tbItemDesc) {
        return tbItemDescMapper.insert(tbItemDesc);
    }
}
