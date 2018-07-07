<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="ff1" method="post" style="text-align: center" enctype="multipart/form-data">
    <div>
        上师编号:&nbsp;&nbsp;<input class="easyui-validatebox" type="text" name="masterId" readonly/>
    </div>
    <br/>
    <div>
        上师法名:&nbsp;&nbsp;<input class="easyui-validatebox" type="text" name="masterName"/>
    </div>
    <br/>
    <div>
        上师头像:&nbsp;&nbsp;<input class="easyui-validatebox" type="text" name="masterImg" readonly/>
    </div>
    <br/>
    <div>
        重置头像:&nbsp;&nbsp;&nbsp;<input class="easyui-filebox" name="file">
    </div>
    <br/>
    <div>
        简介:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-validatebox" type="text" name="intro"/>
    </div>
</form>
