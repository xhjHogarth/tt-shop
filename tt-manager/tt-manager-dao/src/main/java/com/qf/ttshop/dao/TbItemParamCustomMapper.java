package com.qf.ttshop.dao;

import com.qf.ttshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {

    public int countItemParams();

    public List<TbItemParamCustom> listItemParams(Map<String, Object> map);
}