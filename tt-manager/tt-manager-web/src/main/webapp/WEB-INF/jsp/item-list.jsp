<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="itemListToolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" panelMaxHeight="80px">
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<%--容器放好--%>
<table id="dgItems"></table>
<%--通过js代码来渲染容器--%>
<script>
    function searchForm() {
        $('#dgItems').datagrid('load',{
            title: $('#title').val(),
            status: $('#status').combobox('getValue')
        });
    }
    function add() {
        ttshop.addTab('新增商品','item-add');
    }
    function edit() {
        console.log('edit');
    }
    function remove() {
        var rows = $('#dgItems').datagrid('getSelections');
//            console.log(rows);
        if(rows.length == 0){
            $.messager.alert('警告','未选中记录','warning');
            return;
        }
        $.messager.confirm('确认','您确认想要删除记录吗?',function(r){
            if(r){
                //获取用户选中的记录
                var ids = [];
                for(var i = 0;i<rows.length;i++){
                    ids.push(rows[i].id);
                }
                //发送ajax请求
                $.post(
                    //url地址
                    'items/batch',
                    //data请求数据
                    {'ids[]':ids},
                    //callback回调函数
                    function (data) {
                        if(data>0){
//                                alert(data);
                            $('#dgItems').datagrid('reload');
                        }
                    }
                );
            }
        });
    }
    function up() {
        var rows = $('#dgItems').datagrid('getSelections');
        if(rows.length == 0){
            $.messager.alert('警告','未选中记录','warning');
            return;
        }
        $.messager.confirm('确认','你确认要上架吗?',function (r) {
            if(r){
                var ids = [];
                for(var i = 0;i<rows.length;i++){
                    ids.push(rows[i].id);
                }
                //发送ajax请求
                $.post(
                    'items/up',
                    {'ids[]':ids},
                    function (data) {
                        if(data>0){
                            $('#dgItems').datagrid('reload');
                        }
                    }
                );
            }
        });
    }
    function down() {
        var rows = $('#dgItems').datagrid('getSelections');
        if(rows.length == 0){
            $.messager.alert('警告','未选中记录','warning');
            return;
        }
        $.messager.confirm('确认','你确认要下架吗?',function (r) {
            if(r){
                var ids = [];
                for(var i = 0;i<rows.length;i++){
                    ids.push(rows[i].id);
                }
                //发送ajax请求
                $.post(
                    'items/down',
                    {'ids[]':ids},
                    function (data) {
                        if(data>0){
                            $('#dgItems').datagrid('reload');
                        }
                    }
                );
            }
        });
    }

    $('#dgItems').datagrid({
        //允许多列排序
        multiSort:true,
        toolbar:'#itemListToolbar',
        pageSize:20,
        pageList:[20,50,100],
        //请求服务器端数据
        url:'items',
        //请求方式，默认是post
        method:'get',
        //是否显示分页工具栏
        pagination:true,
        fit:true,
        //列属性
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',sortable:true},
            {field:'title',title:'商品标题',width:300,sortable:true},
            {field:'sellPoint',title:'打折信息',width:300},
//            {field:'price',title:'商品价格',width:100},
            {field:'priceView',title:'商品价格'},
            {field:'catName',title:'类目名称'},
//            {field:'statusName',title:'商品状态',width:100}
            {field:'status',title:'商品状态',formatter:function(value,row,index){
//                console.group();
//                console.log(value);
//                console.log(row);
//                console.log(index);
//                console.groupEnd();
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                }
            }},
            //{field:'createtime',title:'创建时间',width:100}
            {field:'created',title:'创建时间',width:100,formatter:function (value,row,index) {
                return moment(value).format('YYYY-MM-DD');
//                return value;
            }},
            //{field:'updatetime',title:'更新时间',width:100}
            {field:'updated',title:'更新时间',width:100,formatter:function (value,row,index) {
                //return moment(value).format('L');
                return moment(value).format('YYYY-MM-DD');
            }}
        ]]
    });
</script>