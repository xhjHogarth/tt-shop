<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="title" name="title"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">商品卖点：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="sellPoint" name="sellPoint"
                           data-options="validType:'length[0,150]',multiline:true" style="width:100%;height:60px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品价格：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="priceView" name="priceView"
                           data-options="required:true,min:0,precision:2">
                    <input type="hidden" id="price" name="price">
                </td>
            </tr>
            <tr>
                <td class="label">商品库存：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="num" name="num"
                           data-options="required:true,min:0,precision:0">
                </td>
            </tr>
            <tr>
                <td class="label">条形码：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="barcode" name="barcode"
                           data-options="validType:'length[0,30]'">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain">商品描述</script>
                </td>
            </tr>

            <tr class="paramsShow" style="display:none;">
                <td class="label">商品规格：</td>
                <td>

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
        <input name="paramData" id="paramData" style="display:none;">
    </form>
</div>

<script>
    //初始化类别选择树
    $('#cid').combotree({
        //请求数据的url地址
        url:'itemCats?parentId=0',
        //必填项
        required:true,
        //请求方式
        method:'get',
        //在节点展开之前触发，返回false可以取消展开操作
        onBeforeExpand:function (node) {
            //console.log(node);
            //获得树对象
            var $tree = $('#cid').combotree('tree');
            //console.log($tree);
            //获得当前树控件的属性
            var option = $tree.tree('options');
            //console.log(option);
            //修改option的url属性
            option.url = 'itemCats?parentId=' + node.id;
        },
        //在用户选择一个节点之前触发，返回false可以取消选择动作
        onBeforeSelect:function (node) {
            //判断是否是叶子节点
            var isLeaf = $('#cid').tree('isLeaf',node.target);
            //console.log(node.target);
            if(!isLeaf){
                $.messager.alert('警告','请选择最终类目!','warning');
                return false;
            }
        }
    });
    //实例化编辑器
    var ue = UE.getEditor('container');
    //提交表单
    function submitForm() {
        $('#itemAddForm').form('submit',{
            //提交的url
            url:'item',
            //在提交之前出发，返回false可以中止提交
            onSubmit:function () {
                $('#price').val($('#priceView').val()*100);
                return $(this).form('validate');
            },
            //在表单提交成功以后触发
            success:function (data) {
                //console.log('success');
                if(data>0){
                    $.messager.alert('消息','添加成功','info');
                    ttshop.closeTab('新增商品');
                    ttshop.addTab('查询商品','item-list');
                }
            }
        });
    }
</script>
