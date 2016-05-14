package com.it.taotao.server;

import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;

/**
 * Created by 55 on 2016/5/14.
 */
public interface TbContentServer {
    public EasyUIResult getTbContentList(Long categoryId,int page, int rows);
}
