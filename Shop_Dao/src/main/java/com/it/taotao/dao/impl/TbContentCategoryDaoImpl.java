package com.it.taotao.dao.impl;

import com.it.taotao.dao.TbContentCategoryDao;
import com.it.taotao.dao.mapper.TbContentCategoryMapper;
import com.it.taotao.pojo.TbContentCategory;
import com.it.taotao.pojo.TbContentCategoryExample;
import com.it.train.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by 55 on 2016/5/13.
 */
@Repository
public class TbContentCategoryDaoImpl implements TbContentCategoryDao {

    @Autowired
    TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> getContentCategoryList(Long pid) {
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        if(CollectionUtil.isEmpty(list)){
            return  Collections.emptyList();
        }else{
            return list;
        }
    }

    @Override
    public int saveContentCategory(TbContentCategory tbContentCategory) {
        /**
         *  返回插入值的主键ID
         * */
        int id = tbContentCategoryMapper.insert(tbContentCategory);
        return id;
    }

    @Override
    public int updateContentCategory(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
    }

    @Override
    public TbContentCategory getTbContentCategoryById(Long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }
}
