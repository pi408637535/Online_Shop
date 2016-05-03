package com.it.taotao.server.impl;

import com.it.taotao.dao.TbContentDao;
import com.it.taotao.pojo.TbContent;
import com.it.taotao.server.TbContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 55 on 5/3/2016.
 */
@Service
public class tbContentServiceImpl implements TbContentService{

    @Resource
    TbContentDao tbContentDao;

    @Override
    public TbContent findTbContentById(Long id) {
        TbContent content = tbContentDao.findContentById(new Long(28));
        return content;
    }
}
