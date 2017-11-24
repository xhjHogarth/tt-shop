package com.qf.ttshop.pojo.vo;

import com.qf.ttshop.pojo.po.TbItem;

/**
 * User: asus
 * Date: 2017/11/21
 * Time: 14:24
 * Version:V1.0
 */
public class TbItemCustom extends TbItem{
    private String catName;
    private String statusName;
    private String createtime;
    private String updatetime;
    private String priceView;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }
}
