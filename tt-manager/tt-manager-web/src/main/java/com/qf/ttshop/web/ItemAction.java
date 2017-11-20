package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: asus
 * Date: 2017/11/17
 * Time: 20:36
 * Version:V1.0
 */
@Controller
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem printJsonById(@PathVariable("itemId") Long itemId){
        return itemService.getById(itemId);
    }

    @ResponseBody
    @RequestMapping(value = "/items",method=RequestMethod.GET)
    public Result<TbItem> listItems(Page page){
        Result<TbItem> result = null;
        try {
           result = itemService.listItems(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
}
