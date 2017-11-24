package com.qf.ttshop.dao;

import com.qf.ttshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2017/11/20
 * Time: 20:55
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    public int countItems(Map<String,Object> map);

//    public List<TbItemCustom> listItems(@Param("page") Page page,@Param("order") Order order);
    public List<TbItemCustom> listItems(Map<String,Object> map);
}
