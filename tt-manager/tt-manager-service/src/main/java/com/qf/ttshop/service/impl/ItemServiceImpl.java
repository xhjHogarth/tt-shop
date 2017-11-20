package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.dao.TbItemCustomMapper;
import com.qf.ttshop.dao.TbItemMapper;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: asus
 * Date: 2017/11/17
 * Time: 20:41
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItem> listItems(Page page) {
        Result<TbItem> result = null;
        try {
            //1 先查总记录数 int--Long
            Long total = itemCustomDao.countItems()*1L;
            //2 查询指定页码的记录集合
            List<TbItem> list = itemCustomDao.listItems(page);
            //3 存放result中
            result = new Result<>();
            result.setTotal(total);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
}
