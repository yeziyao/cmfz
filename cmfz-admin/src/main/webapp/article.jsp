<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {

        $('#dg_art').datagrid({
            pagination: true,
            pageList: [5, 10, 15],
            fitColumns: true,
            singleSelect: true,
            remoteSort: false,
            nowrap: false,
            pageSize: 5,
            striped: true,
            resizeHandle: 'both',
            url: '/article/queryAll',
            columns: [[
                {field: 'articleId', title: '文章编号', width: '15%'},
                {field: 'articleName', title: '文件标题', width: '15%'},
                {
                    field: 'status', title: '文章状态', width: '15%',
                    formatter: function (value, row, index) {
                        if (value == 'on') {
                            return '<span style="color: red;">上架</span>';
                        } else {
                            return '<span>未上架</span>';
                        }
                    }
                },
                {
                    field: 'publishTime', title: '文章创建时间', width: '25%',
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
                {field: 'masterName', title: '所属上师', width: '15%'},
                {
                    field: 'operation',
                    title: '操作',
                    width: '15%',
                    formatter: function (value, row, index) {
                        var str = '<a name="search"></a>&nbsp;<a name="update"></a>';
                        return str;
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $("a[name='search']").linkbutton({
                    text: '文章详情',
                    plain: false,
                    iconCls: 'icon-accept',
                });
                $("a[name='update']").linkbutton({
                    text: '修改内容',
                    plain: false,
                    iconCls: 'icon-edit',
                    onClick:function () {
                        var rowData = $("#dg").datagrid('getSelected');
                        $('#dd').dialog({
                            title: '修改图片信息',
                            width: 400,
                            height: 200,
                            href: '${pageContext.request.contextPath}/modifySlideshow.jsp',
                            onLoad: function () {
                                $("#ff").form('load', rowData);
                            },
                            buttons: [{
                                text: '修改',
                                handler: function () {
                                    $("#ff").form("submit", {
                                        url:'${pageContext.request.contextPath}/slideshow/update',
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
                    }
                });
            }
        });

    });
</script>


<table id="dg_art"></table>
<div id="dd_art"></div>
