package com.it.taotao.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.taotao.dao.TbContentCategoryDao;
import com.it.taotao.dao.TbContentDao;
import com.it.taotao.pojo.TbContent;
import com.it.taotao.pojo.TbContentCategory;
import com.it.taotao.server.TbContentServer;
import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 55 on 2016/5/14.
 */
@Service
public class TbContentServerImpl implements TbContentServer {

    @Autowired
    TbContentDao tbContentDao;

    @Override
    public EasyUIResult getTbContentList(Long categoryId,int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //获取数据
        List<TbContent> listTbContent = tbContentDao.getTbContentList(categoryId);
        //取分页信息
        PageInfo<TbContent> pageInfo = new PageInfo<>(listTbContent);
        //返回处理结果
        EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), listTbContent);
        return result;
    }

    @Override
    public TaotaoResult saveTbContent(TbContent tbContent) {
        Date date = new Date();
        tbContent.setCreated(date);
        tbContent.setUpdated(date);
        int result = tbContentDao.saveContent(tbContent);
        return TaotaoResult.ok(result);
    }
}
