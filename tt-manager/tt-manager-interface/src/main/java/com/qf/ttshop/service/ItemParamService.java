package com.qf.ttshop.service;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;

/**
 * User: asus
 * Date: 2017/11/25
 * Time: 11:25
 * Version:V1.0
 */
public interface ItemParamService {
    public Result<TbItemParamCustom> itemParamList(Page page, Order order);

    public int saveItemParam(Long cid, String paramData);

    public TbItemParam getByCid(Long cid);
}
