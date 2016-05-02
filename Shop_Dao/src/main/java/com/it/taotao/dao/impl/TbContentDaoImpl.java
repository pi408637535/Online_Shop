package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbContentDao;
import com.it.taotao.dao.mapper.TbContentMapper;
import com.it.taotao.pojo.TbContent;
import com.it.taotao.pojo.TbContentExample;
import com.it.train.util.CollectionUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 55 on 5/3/2016.
 */
public class TbContentDaoImpl implements TbContentDao {

    @Resource
    TbContentMapper tbContentMapper;


    @Override
    public TbContent findContentById(Long id) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbContent> listContent = tbContentMapper.selectByExample(tbContentExample);
        if(!CollectionUtil.isEmpty(listContent)){
            return listContent.get(0);
        }else{
            return null;
        }

    }
}
