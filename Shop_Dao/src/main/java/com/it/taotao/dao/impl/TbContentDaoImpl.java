package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbContentDao;
import com.it.taotao.dao.mapper.TbContentMapper;
import com.it.taotao.pojo.TbContent;
import com.it.taotao.pojo.TbContentExample;
import com.it.train.util.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 55 on 5/3/2016.
 */
@Repository
public class TbContentDaoImpl implements TbContentDao {

    private static final Logger logger = LoggerFactory.getLogger(TbContentDaoImpl.class);

    @Autowired
    private TbContentMapper tbContentMapper;


    @Override
    public TbContent findContentById(Long id) {
        try{
            TbContentExample tbContentExample = new TbContentExample();
            TbContentExample.Criteria criteria = tbContentExample.createCriteria();
            criteria.andIdEqualTo(id);
            List<TbContent> listContent = tbContentMapper.selectByExample(tbContentExample);
            if(!CollectionUtil.isEmpty(listContent)){
                return listContent.get(0);
            }else{
                return null;
            }
        }catch(Exception e){
            logger.error("TbContentDaoImpl findContentById", e);
        }finally {
            logger.info("TbContentDaoImpl findContentById");
        }
        return  null;
        /*
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbContent> listContent = tbContentMapper.selectByExample(tbContentExample);
        if(!CollectionUtil.isEmpty(listContent)){
            return listContent.get(0);
        }else{
            return null;
        }*/
    }

    @Override
    public List<TbContent> getTbContentList(Long categoryId) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return tbContentMapper.selectByExample(tbContentExample);
    }

    @Override
    public int saveContent(TbContent tbContent) {
        return tbContentMapper.insert(tbContent);
    }
}
