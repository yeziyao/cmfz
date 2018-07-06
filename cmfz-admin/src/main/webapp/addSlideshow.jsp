<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="ff" method="post" style="text-align: center" enctype="multipart/form-data">
    <div>
        轮播图描述:&nbsp;&nbsp;<input class="easyui-validatebox" type="text" name="slideshowDec" style="width:200px"/>
    </div>
    <br/>
    <div>
        轮播状态:&nbsp;&nbsp;&nbsp;
        <select id="cc" class="easyui-combobox" name="status" style="width:205px;">
            <option value="未展示">未展示</option>
            <option value="展示中">展示中</option>
        </select>
    </div>
    <br/>
    <div>
        上传轮播图:&nbsp;&nbsp;<input class="easyui-filebox" name="file" style="width:200px">
    </div>
</form>