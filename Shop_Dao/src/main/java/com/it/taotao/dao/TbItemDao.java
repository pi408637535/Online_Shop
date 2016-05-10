package com.it.taotao.dao;

import com.it.taotao.pojo.TbItem;

import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
public interface TbItemDao {
    public List<TbItem> getItemList();
    public int saveTbItem(TbItem tbItem);
}
