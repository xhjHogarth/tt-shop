package com.qf.ttshop.service.impl;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.dao.TbItemParamCustomMapper;
import com.qf.ttshop.dao.TbItemParamMapper;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.po.TbItemParamExample;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;
import com.qf.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2017/11/25
 * Time: 11:26
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private TbItemParamMapper itemParamDao;
    @Autowired
    private TbItemParamCustomMapper tbItemParamCustomDao;

    @Override
    public Result<TbItemParamCustom> itemParamList(Page page, Order order) {
        Result<TbItemParamCustom> result = new Result<>();
        try {
            //0 创建一个map
            Map<String,Object> map = new HashMap<>();
            map.put("page",page);
            map.put("order",order);
            //1 先查总记录数 int--Long
            long tatal = tbItemParamCustomDao.countItemParams();
            //2 查询指定页码的记录集合
            List<TbItemParamCustom> list = tbItemParamCustomDao.listItemParams(map);
            //3 存放result中
            result.setTotal(tatal);
            result.setRows(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    @Override
    public int saveItemParam(Long cid, String paramData) {
        int i = 0;
        try {
            TbItemParam tbItemParam = new TbItemParam();
            tbItemParam.setItemCatId(cid);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(new Date());
            tbItemParam.setUpdated(new Date());
            i = itemParamDao.insertSelective(tbItemParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public TbItemParam getByCid(Long cid) {
        TbItemParam tbItemParam = null;
        try {
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            List<TbItemParam> tbItemParams = itemParamDao.selectByExampleWithBLOBs(example);
            if(tbItemParams!=null && tbItemParams.size()>0){
                tbItemParam = tbItemParams.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  tbItemParam;
    }
}
