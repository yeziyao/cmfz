<%--
  Created by IntelliJ IDEA.
  User: dyy
  Date: 2018/7/6
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#pic_add1").linkbutton({
            onClick: function () {
                $('#dd1').dialog({
                    title: '添加上师信息',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/addMaster.jsp',
                    buttons: [{
                        text: '添加',
                        handler: function () {
                            $("#ff1").form("submit", {
                                url: '${pageContext.request.contextPath}/master/add',
                                success: function (e) {
                                    $('#dg1').datagrid('reload');
                                    $('#dd1').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        handler: function () {
                            $('#dd1').dialog('close');
                        }
                    }],
                });
            }
        });

        $("#pic_edit").linkbutton({
            onClick: function () {
                var rowData = $("#dg1").datagrid('getSelected');
                $('#dd1').dialog({
                    title: '修改上师信息',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/modifyMaster.jsp',
                    onLoad: function () {
                        $("#ff1").form('load', rowData);
                    },
                    buttons: [{
                        text: '修改',
                        handler: function () {
                            $("#ff1").form("submit", {
                                url: '${pageContext.request.contextPath}/master/update',
                                success: function (e) {
                                    $('#dg1').datagrid('reload');
                                    $('#dd1').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        handler: function () {
                            $('#dd1').dialog('close');
                        }
                    }],
                });
            }
        });


        $('#dg1').datagrid({
            pagination: true,
            pageList: [5, 10, 15],
            fitColumns: true,
            singleSelect: true,
            remoteSort: false,
            nowrap: false,
            pageSize: 5,
            striped: true,
            toolbar: '#tb1',
            resizeHandle: 'both',
            url: 'http://localhost:8989/master/queryAll',
            columns: [[
                {field: 'masterId', title: '上师编号', width: '25%'},
                {field: 'masterName', title: '法名', width: '25%'},
                {field: 'masterImg', title: '头像', width: '25%'},
                {field: 'intro', title: '简介', width: '25%'}
            ]],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://localhost:8989/upload/' + rowData.masterImg + '" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });
    });





    function qq(value, name) {
//            alert(value+":"+name)
        $('#dg1').datagrid({
            queryParams: {
                value: value,
                sort: name
            },
            url:'${pageContext.request.contextPath}/master/queryBlur'
        });
    }
</script>
<table id="dg1"></table>
<div id="tb1">
    <a id="pic_add1" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'新增上师'"></a>
    <a id="pic_edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改上师'"></a>

    <input id="ss" class="easyui-searchbox" style="width:300px"
           data-options="searcher:qq,prompt:'请输入上师法名',menu:'#mm'"></input>
    <div id="mm" style="width:120px">
        <div data-options="name:'masterName',iconCls:'icon-ok'">法名</div>
    </div>
</div>
<div id="dd1"></div>

