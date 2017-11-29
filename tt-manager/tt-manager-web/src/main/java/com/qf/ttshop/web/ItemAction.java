package com.qf.ttshop.web;

import com.qf.ttshop.common.dto.Order;
import com.qf.ttshop.common.dto.Page;
import com.qf.ttshop.common.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.pojo.vo.TbItemQuery;
import com.qf.ttshop.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem printJsonById(@PathVariable("itemId") Long itemId) {
        return itemService.getById(itemId);
    }

    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query, HttpServletRequest request) {
        Result<TbItemCustom> result = null;
        try {
            String str = request.getParameter("title");
            if(StringUtils.isNotBlank(str)) {
                String title = new String(str.getBytes("ISO-8859-1"), "UTF-8");
                query.setTitle(title);
            }
            result = itemService.listItems(page, order, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/items/batch", method = RequestMethod.POST)
    public int updateItemByIds(@RequestParam("ids[]") List<Long> ids) {
        int i = 0;
        try {
            i = itemService.updateItemsByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "items/up", method = RequestMethod.POST)
    public int updateItemByIds2(@RequestParam("ids[]") List<Long> ids) {
        int i = 0;
        try {
            i = itemService.updateItemsByIds2(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "items/down", method = RequestMethod.POST)
    public int updateItemByIds3(@RequestParam("ids[]") List<Long> ids) {
        int i = 0;
        try {
            i = itemService.updateItemsByIds3(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "item",method = RequestMethod.POST)
    public int saveItem(TbItem tbItem,String content,String paramData){
        int i = 0;
        try {
            i = itemService.saveItem(tbItem,content,paramData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
