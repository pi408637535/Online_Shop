package com.it.taotao.dao;

import com.it.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by 55 on 5/3/2016.
 */
public interface TbContentDao {
    public TbContent findContentById(Long id);
    public List<TbContent> getTbContentList(Long categoryId);
}


