package com.qf.ttshop.common.dto;

import java.util.List;

/**
 * 封装分页的响应参数
 * User: asus
 * Date: 2017/11/20
 * Time: 20:34
 * Version:V1.0
 */
public class Result<T> {
    //符合条件的记录条数
    private  long total;
    //符合条件的数据集
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
