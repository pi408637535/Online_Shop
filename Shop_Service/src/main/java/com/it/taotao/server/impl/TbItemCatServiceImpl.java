package com.it.taotao.server.impl;

import com.it.taotao.dao.TbItemCatDao;
import com.it.taotao.dao.TbItemDao;
import com.it.taotao.pojo.TbContent;
import com.it.taotao.pojo.TbItemCat;
import com.it.taotao.server.TbContentService;
import com.it.taotao.server.TbItemCatService;
import com.sun.deploy.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 55 on 2016/5/6.
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Autowired
    TbItemCatDao tbItemCatDao;

    @Override
    public List getItemCatList(Long parentId) {
        List<TbItemCat> listTbItemCat = tbItemCatDao.getItemCategoryList(parentId);
       // List list = Collections.emptyList();
        List list = new ArrayList();
        for(TbItemCat tbItemCat : listTbItemCat){
            Map node = new HashMap();
            node.put("id",tbItemCat.getId());
            node.put("text", tbItemCat.getName());
            node.put("state", tbItemCat.getIsParent()? "closed":"open");
            list.add(node);
        }
        return list;
    }
}
