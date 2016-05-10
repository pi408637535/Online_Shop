package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbItemDao;
import com.it.taotao.dao.mapper.TbItemMapper;
import com.it.taotao.pojo.TbItem;
import com.it.taotao.pojo.TbItemExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
@Repository
public class TbItemDaoImpl implements TbItemDao {

    private static final Logger logger = LoggerFactory.getLogger(TbItemDaoImpl.class);


    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> getItemList() {
        try {
            TbItemExample tbItemExample = new TbItemExample();

            return tbItemMapper.selectByExample(tbItemExample);
        }catch(Exception e){
            logger.error("TbItemDao getItemList", e);
        }finally {
            logger.info("TbItemDao getItemList");
        }
        return Collections.emptyList();
    }

    @Override
    public int saveTbItem(TbItem tbItem) {
        return  tbItemMapper.insert(tbItem);
    }
}
