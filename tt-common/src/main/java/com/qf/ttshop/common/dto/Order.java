package com.qf.ttshop.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装排序信息的类
 * User: asus
 * Date: 2017/11/22
 * Time: 14:40
 * Version:V1.0
 */
public class Order {
    private String sort;
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<String> getOrderParams(){
        List<String> list = new ArrayList<>();
        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        for (int i = 0;i<sorts.length; i++){
            String temp;
            if("title".equals(sorts[i].trim())) {
                temp = "CONVERT(i." + "title USING gbk)" + " " + orders[i];
            }else{
                temp = sorts[i] + " " + orders[i];
            }
            list.add(temp);
        }
        return  list;
    }
}
