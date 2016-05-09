package com.it.taotao.dao;

import com.it.taotao.pojo.TbItemCat;

import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
public interface TbItemCatDao {
    public List<TbItemCat> getItemCategoryList(Long parentId);
}
