<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div id="paramListToolbar">
    <div>
        <button type="button" onclick="add()" class="easyui-linkbutton"
                data-options="iconCls:'icon-add',plain:true">新增</button>
        <button type="button" onclick="edit()" class="easyui-linkbutton"
                data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button type="button" onclick="del()" class="easyui-linkbutton"
                data-options="iconCls:'icon-cancel',plain:true">删除</button>
    </div>
</div>
<table id="dgParamList"></table>
<script>
    $('#dgParamList').datagrid({
        title:'商品规格模板列表',
        url:'itemParams',
        //自适应
        fit:true,
        //显示行数
        rownumbers:true,
        //显示分页工具
        pagination:true,
        pageSize:20,
        pageList:[20,50,100],
        toolbar:'#paramListToolbar',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'ID',sortable:true},
            {field:'itemCatName',title:'商品类目'},
            //规格,只显示分组名
            {field:'paramData',title:'规格(只显示分组名称)',formatter:function (value,row,index) {
                //js中把字符串转换为对象(反序列化)
                //js中把对象转换字符串(序列化)
                var json = JSON.parse(value);
                var array = [];
                $.each(json,function (i,e) {
                    array.push(e.group);
                });
                return array.join(',');
            }},
            {field:'created',title:'创建日期', formatter:function (value,row,index) {
                return moment(value).format('YYYY年MM月DD日,HH:mm:ss');
            }},
            {field:'updated',title:'更新日期',formatter:function (value,row,index) {
                return moment(value).format('YYYY年MM月DD日,HH:mm:ss');
            }}
        ]]
    });
    function add() {
        ttshop.addTab('新增规格参数','item-param-add');
    }
    function edit() {
        
    }
    function del() {
        
    }
</script>