package com.it.taotao.server.impl;

import com.it.taotao.dao.TbContentCategoryDao;
import com.it.taotao.pojo.TbContentCategory;
import com.it.taotao.server.TbContentCategoryService;
import com.it.train.po.EasyUIResult;
import com.it.train.po.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
