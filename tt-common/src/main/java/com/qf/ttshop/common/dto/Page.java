package com.qf.ttshop.common.dto;

/**
 * 封装分页的请求参数
 * User: asus
 * Date: 2017/11/20
 * Time: 20:33
 * Version:V1.0
 */
public class Page {
    //当前页
    private int page;
    //每页显示的数据条数
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    /**
     * 偏移量，查询数据的起始位置
     */
    public int getOffset(){
        return  (page-1)*rows;
    }
}
