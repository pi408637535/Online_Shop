package com.it.taotao.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.taotao.dao.TbContentCategoryDao;
import com.it.taotao.pojo.TbContentCategory;
import com.it.taotao.pojo.TbItemParam;
import com.it.taotao.server.TbContentCategoryService;
import com.it.train.po.EasyUIResult;
import com.it.train.po.EasyUITreeNode;
import com.it.train.po.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 55 on 2016/5/13.
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<EasyUITreeNode> getEasyUITreeNode(Long pid) {
        List<TbContentCategory> list = tbContentCategoryDao.getContentCategoryList(pid);
        List<EasyUITreeNode> listEasyUITreeNode = new ArrayList<EasyUITreeNode>();
        for(TbContentCategory tbContentCategory:list){
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbContentCategory.getId());
            easyUITreeNode.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            easyUITreeNode.setText(tbContentCategory.getName());
            listEasyUITreeNode.add(easyUITreeNode);
        }
        return listEasyUITreeNode;
    }

    @Override
    public TaotaoResult createEasyUITreeNode(Long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setName(name);
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setStatus(1);
        Date date = new Date();
        tbContentCategory.setCreated(date);
        tbContentCategory.setUpdated(date);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setSortOrder(1);
        /**
         *  现在返回的是插入值的Id值
         *  利用mysql last_insert_id
         * */
        int result = tbContentCategoryDao.saveContentCategory(tbContentCategory);
        TbContentCategory tbContentCategoryNow= tbContentCategoryDao.getTbContentCategoryById(parentId);
        if(!tbContentCategoryNow.getIsParent()){
            tbContentCategory.setIsParent(true);
            tbContentCategoryDao.updateContentCategory(tbContentCategoryNow);
        }
        return  TaotaoResult.ok(result);
    }


}
