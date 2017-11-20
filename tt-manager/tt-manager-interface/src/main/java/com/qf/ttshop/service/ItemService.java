package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;

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

    public Result<TbItem> listItems(Page page);
}
