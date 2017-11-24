package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: asus
 * Date: 2017/11/17
 * Time: 20:40
 * Version:V1.0
 */
public interface ItemService {
    /**
     * 通过商品主键查询单个商品
     * @param itemId
     * @return
     */
    TbItem getById(Long itemId);

    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query);

    public int updateItemsByIds(List<Long> ids);

    public int updateItemsByIds2(List<Long> ids);

    public int updateItemsByIds3(List<Long> ids);

    public int saveItem(TbItem tbItem, String content);
}
