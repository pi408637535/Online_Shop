package com.it.taotao.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.taotao.dao.TbItemDao;
import com.it.taotao.dao.TbItemDescDao;
import com.it.taotao.pojo.TbItem;
import com.it.taotao.pojo.TbItemDesc;
import com.it.taotao.server.TbItemService;
import com.it.train.po.EasyUIResult;
import com.it.train.po.TaotaoResult;
import com.it.train.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 55 on 2016/5/6.
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    TbItemDao tbItemDao;
    @Autowired
    TbItemDescDao tbItemDescDao;

    /** Mybatis PageHelper分页插件使用方法
     * 使用方法：
     第一步：需要在SqlMapConfig.xml，配置一个plugin。
     第二步：在sql语句执行之前，添加一个PageHelper.startPage(page,rows);
     第三步：取分页结果。创建一个PageInfo对象需要参数，查询结果返回的list。从PageInfo对象中取分页结果。
     *
     * */
    @Override
    public EasyUIResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //获取数据
        List<TbItem> listTbItem = tbItemDao.getItemList();
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(listTbItem);
        //返回处理结果
        EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), listTbItem);
        return result;
    }

    @Override
    public TaotaoResult saveItem(TbItem tbItem, String desc) {
        TaotaoResult taotaoResult = new TaotaoResult();

        Date date = new Date();
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItem.setStatus((byte) 1);
        int tbItemResult = tbItemDao.saveTbItem(tbItem);

        TbItemDesc  tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setCreated(date);
        tbItemDesc.setItemDesc(desc);

        int tbItemDescResult = tbItemDescDao.insertTbItemDesc(tbItemDesc);

        if(tbItemResult != 1 && tbItemDescResult != 1){
            return  TaotaoResult.build(400,"create Item error！");
        }else{
            return TaotaoResult.ok();
        }


    }

}
