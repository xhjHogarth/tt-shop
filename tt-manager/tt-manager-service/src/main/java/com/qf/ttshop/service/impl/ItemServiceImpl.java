package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.common.util.IDUtils;
import com.qf.ttshop.dao.TbItemCustomMapper;
import com.qf.ttshop.dao.TbItemDescMapper;
import com.qf.ttshop.dao.TbItemMapper;
import com.qf.ttshop.dao.TbItemParamItemMapper;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.po.TbItemDesc;
import com.qf.ttshop.pojo.po.TbItemExample;
import com.qf.ttshop.pojo.po.TbItemParamItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;
import com.qf.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TbItemDescMapper itemDescDao;
    @Autowired
    private TbItemParamItemMapper itemParamItemDao;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            //0 创建一个map
            Map<String,Object> map = new HashMap<>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //1 先查总记录数 int--Long
            Long total = itemCustomDao.countItems(map)*1L;
            //2 查询指定页码的记录集合
            List<TbItemCustom> list = itemCustomDao.listItems(map);
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

    @Override
    public int updateItemsByIds(List<Long> ids) {
        int i = 0;
        try {
            //创建模板
            TbItem tbItem = new TbItem();
            tbItem.setStatus((byte)3);
            TbItemExample tbItemExample = new TbItemExample();
            TbItemExample.Criteria criteria = tbItemExample.createCriteria();
            criteria.andIdIn(ids);
            //执行修改操作
            i = itemDao.updateByExampleSelective(tbItem,tbItemExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateItemsByIds2(List<Long> ids) {
        int i = 0;
        try {
            //创建模板
            TbItem tbItem = new TbItem();
            tbItem.setStatus((byte)1);
            TbItemExample tbItemExample = new TbItemExample();
            TbItemExample.Criteria criteria = tbItemExample.createCriteria();
            criteria.andIdIn(ids);
            //执行修改操作
            i = itemDao.updateByExampleSelective(tbItem,tbItemExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateItemsByIds3(List<Long> ids) {
        int i = 0;
        try {
            //创建模板
            TbItem tbItem = new TbItem();
            tbItem.setStatus((byte)2);
            TbItemExample tbItemExample = new TbItemExample();
            TbItemExample.Criteria criteria = tbItemExample.createCriteria();
            criteria.andIdIn(ids);
            //执行修改操作
            i = itemDao.updateByExampleSelective(tbItem,tbItemExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content,String paramData) {
        int i = 0;
        try {
            //设置商品的属性值
            //获得一个随机的商品id
            Long id = IDUtils.getItemId();
            tbItem.setId(id);
            tbItem.setStatus((byte) 1);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            //添加商品
            i = itemDao.insert(tbItem);
            //设置商品描述
            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(id);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(new Date());
            itemDesc.setItemDesc(content);
            i += itemDescDao.insert(itemDesc);
            //存在表tb_item_param_item
            TbItemParamItem itemParamItem = new TbItemParamItem();
            itemParamItem.setItemId(id);
            itemParamItem.setParamData(paramData);
            itemParamItem.setCreated(new Date());
            itemParamItem.setUpdated(new Date());
            i += itemParamItemDao.insert(itemParamItem);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
