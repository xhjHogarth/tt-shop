package com.qf.ttshop.dao;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.pojo.po.TbItem;

import java.util.List;

/**
 * User: asus
 * Date: 2017/11/20
 * Time: 20:55
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    public int countItems();

    public List<TbItem> listItems(Page page);
}
