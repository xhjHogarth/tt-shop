package com.qf.ttshop.service.impl;

import com.qf.ttshop.dao.TbItemMapper;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: asus
 * Date: 2017/11/17
 * Time: 20:41
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemDao;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }
}
