package com.it.taotao.server;

import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;

/**
 * Created by 55 on 2016/5/11.
 */
public interface TbItemParamService {
    public TaotaoResult getTbItemParamByItemCatId(Long itemCatId);
    public EasyUIResult getItemParamList(int page, int rows);
    public TaotaoResult saveTbItemParam(Long itemCatId, String paramData);
}
