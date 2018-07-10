<%--
  Created by IntelliJ IDEA.
  User: dyy
  Date: 2018/7/9
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#dg_log').datagrid({
            pagination: true,
            pageList: [5, 10, 15],
            fitColumns: true,
            singleSelect: true,
            remoteSort: false,
            nowrap: false,
            pageSize: 5,
            striped: true,
            resizeHandle: 'both',
            url: '/log/queryAll',
            columns: [[
                {field: 'id', title: 'id', width: '14%'},
                {field: 'adminName', title: 'adminName', width: '14%'},
                {
                    field: 'currTime', title: 'currTime', width: '16%',
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
                {field: 'resource', title: 'resource', width: '14%'},
                {field: 'action', title: 'action', width: '14%'},
                {field: 'message', title: 'message', width: '14%'},
                {field: 'result', title: 'result', width: '14%'}
            ]]
        });
    });
</script>
<table id="dg_log"></table>
<div id="dd_log"></div>

