<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#pic_add").linkbutton({
            onClick: function () {
                $('#dd').dialog({
                    title: '添加轮播图',
                    width: 400,
                    height: 200,
                    close: true,
                    href: '${pageContext.request.contextPath}/addSlideshow.jsp',
                    buttons: [{
                        text: '添加',
                        handler: function () {
                            $("#ff").form("submit", {
                                url:'${pageContext.request.contextPath}/slideshow/add',
                                success: function (e) {
                                    $('#dg').datagrid('reload');
                                    $('#dd').dialog('close');
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        handler: function () {
                            $('#dd').dialog('close');
                        }
                    }],
                });
            }
        });

        $('#dg').datagrid({
            pagination: true,
            pageList: [5, 10, 15],
            fitColumns: true,
            singleSelect: true,
            remoteSort: false,
            nowrap: false,
            pageSize: 5,
            striped: true,
            toolbar: '#tb',
            resizeHandle: 'both',
            url: 'http://localhost:8989/slideshow/queryAll',
            columns: [[
                {field: 'slideshowId', title: '标识编号', width: '15%'},
                {field: 'slideshowImg', title: '文件名', width: '15%'},
                {field: 'slideshowDec', title: '描述信息', width: '20%'},
                {field: 'status', title: '轮播图状态', width: '15%'},
                {
                    field: 'publishTime', title: '轮播图创建时间', width: '20%',
                    formatter: function (value, row, index) {
                        var date = new Date(value);
                        var year = date.getFullYear();
                        var month = date.getMonth() + 1;
                        var day = date.getDate();
                        var hour = date.getHours();
                        var minutes = date.getMinutes();
                        var seconds = date.getSeconds();
                        return year + "年" + month + "月" + day + "日" + "\t" + hour + ":" + minutes + ":" + seconds;
                    }
                },
                {
                    field: 'operation',
                    title: '操作',
                    width: '15%',

                    formatter: function (value, row, index) {
                        return '<a href="#" onclick="update(' + index + ')">修改</a>';
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="img/6.gif" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });

    });
    /*
        function update(index) {
    //        $('#dg').datagrid('selectRow',index);
            var rowData = $("#dg").datagrid('getSelected');
    //            console.log(rowData);
            $('#dd').dialog({
                title: '编辑员工信息',
                width: 400,
                height: 200,
                href: '/form.html',
                onLoad: function () {
                    $("#ff").form('load', rowData);
                },
                buttons: [{
                    text: '修改',
                    handler: function () {
                        $("#ff").form("submit", {
                            success: function (e) {
                                console.log(e);
                                $('#dg').datagrid('reload');
                                $('#dd').dialog('close');
                            }
                        });

                    }
                }, {
                    text: '关闭',
                    handler: function () {
                        $('#dd').dialog('close');
                    }
                }],
            });
        }*/
    /*
        $(function () {
            $("#del").linkbutton({
                onClick: function () {
                    var r = $("#dg").datagrid('getSelected');
    //                    console.log(r.empid);
                    $.messager.confirm('确认', '您确认想要删除记录吗？', function (mes) {
                        if (mes) {
                            $.ajax({
                                url: '/emp/delete?empid=' + r.empid,
                                success: function () {
                                    $('#dg').datagrid('reload');
                                }
                            });
                        }
                    });

                }
            })
        });*/
</script>


<table id="dg"></table>
<div id="tb">
    <a id="pic_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'"></a>
    <a id="pic_help" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'帮助',onClick:update"></a>
</div>
<div id="dd"></div>
