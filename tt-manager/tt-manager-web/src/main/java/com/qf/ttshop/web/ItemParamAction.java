package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItemParam;
import com.qf.ttshop.pojo.vo.TbItemParamCustom;
import com.qf.ttshop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: asus
 * Date: 2017/11/24
 * Time: 15:46
 * Version:V1.0
 */
@Controller
public class ItemParamAction {

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping(value = "itemParams",method = RequestMethod.POST)
    public Result<TbItemParamCustom> itemParamList(Page page, Order order){
        Result<TbItemParamCustom> result = new Result<>();
        try {
            result = itemParamService.itemParamList(page,order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.POST)
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData") String paramData){
        int i = 0;
        try {
            if (paramData!=null && paramData!="") {
                i = itemParamService.saveItemParam(cid, paramData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.GET)
    public TbItemParam getByCid(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam = null;
        try {
            tbItemParam = itemParamService.getByCid(cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  tbItemParam;
    }
}
