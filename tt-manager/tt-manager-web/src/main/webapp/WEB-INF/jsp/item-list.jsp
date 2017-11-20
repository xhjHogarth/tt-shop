<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--容器放好--%>
<table id="dgItems"></table>
<%--通过js代码来渲染容器--%>
<script>
    $('#dgItems').datagrid({
        //请求服务器端数据
        url:'items',
        //请求方式，默认是post
        method:'get',
        //是否显示分页工具栏
        pagination:true,
        fit:true,
        //列属性
        columns:[[
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品标题',width:100},
            {field:'sellPoint',title:'打折信息',width:100},
            {field:'price',title:'商品价格',width:100}
        ]]
    });
</script>