package com.it.taotao.server;

import com.it.taotao.pojo.TbItem;
import com.it.train.po.EasyUIResult;

/**
 * Created by 55 on 2016/5/6.
 */
public interface TbItemService {
    public EasyUIResult getItemList(int page, int rows);
}
