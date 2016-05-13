package com.it.taotao.dao;

import com.it.taotao.pojo.TbContentCategory;

import java.util.List;

/**
 * Created by 55 on 2016/5/12.
 */
public interface TbContentCategoryDao {
    public List<TbContentCategory> getContentCategoryList(Long id);
}
