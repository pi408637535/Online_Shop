package com.it.taotao.server;

import com.it.train.po.EasyUITreeNode;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 55 on 2016/5/13.
 */
public interface TbContentCategoryService {
    public List<EasyUITreeNode> getEasyUITreeNode(Long pid);
}
