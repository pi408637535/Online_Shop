package com.it.taotao.dao;

import com.it.taotao.pojo.TbItemParam;

import java.util.List;

/**
 * Created by 55 on 2016/5/11.
 */
public interface TbItemParamDao {
    public TbItemParam getTbItemDescByItemCatId(Long itemCatId);
    public List<TbItemParam> getItemParamList();
    public int saveTbItemParam(TbItemParam tbItemParam);
}
