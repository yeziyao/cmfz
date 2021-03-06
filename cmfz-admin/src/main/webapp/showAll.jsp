<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <base href="<%=basePath %>"/>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/wangEditor.min.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/china.js"></script>
    <script type="text/javascript" src="js/vintage.js"></script>
    <script type="text/javascript">

        $(function () {
            $.ajax({
                url: "menu/showMenu",
                dataType: "json",
                success: function (res) {
                    $.each(res, function (index, obj) {
                        console.log(obj);
                        var content = "";
                        $.each(obj.secondMenu, function (index1, obj1) {
                            content += "<p style=\"text-align: center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'" + obj1.menuIcon + "'\" onclick=\"addTab('" + obj1.menuName + "','" + obj1.menuUrl + "','" + obj1.menuIcon + "')\">" + obj1.menuName + "</a></p>"
                        });

                        $("#aa").accordion("add", {
                            title: obj.menuName,
                            iconCls: obj.menuIcon,
                            content: content,
                        });
                    });
                }
            });
        });

        function modify() {
            $('#dd3').dialog({
                title: '修改密码',
                width: 400,
                height: 200,
                close: true,
                href: '${pageContext.request.contextPath}/modifyPassword.jsp',
                buttons: [{
                    text: '修改',
                    handler: function () {
                        $("#ff3").form("submit", {
                            url: '${pageContext.request.contextPath}/admin/modify',
                            onSubmit: function () {
                                var pwd = $("#password").val();
                                var repwd = $("#repassword").val();
                                if (pwd != repwd) {
                                    $("#sp").html("两次密码不一致,请重新输入");
                                    $("#repassword").val("");
                                    return false;
                                } else {
                                    return true;
                                }
                            },
                            success: function (e) {
                                $('#dd3').dialog('close');
                                window.location.href = "/admin/tologin";
                            }
                        });
                    }
                }, {
                    text: '关闭',
                    handler: function () {
                        $('#dd3').dialog('close');
                    }
                }],
            });
        }

        function addTab(e, path, menuIcon) {
            var exists = $('#tt').tabs('exists', e);
            if (!exists) {
                $('#tt').tabs('add', {
                    title: e,
                    closable: true,
                    href: '/' + path
                })
            } else {
                $('#tt').tabs('select', e);
            }
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:<shiro:principal></shiro:principal>&nbsp;<a id="modifyPassword" class="easyui-linkbutton"
                                  data-options="iconCls:'icon-edit',onClick:modify">修改密码</a>&nbsp;
        <a href="http://localhost:8989/admin/login" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;瑶瑶博客 <a href="http://1012.kim/">dyy.blog</a>
    </div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">
    </div>
</div>

<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
<div id="dd3"></div>
</html>