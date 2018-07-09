<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = 'article/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create();
    $(function () {
        $('#cc').combobox({
            url: '/master/queryAllName',
            valueField: 'masterId',
            textField: 'masterName'
        });
        $('#status').switchbutton({
            checked: false,
            value:'off',
            onChange: function (checked) {
                if (checked == true) {
                    $(this).val('on');
                }
                if (checked == false) {
                    $(this).val('off');
                }
            }
        });
    });

    function add() {
        $.post(
            "/article/addArt", {
                articleName: $('#name').val(),
                masterId: $('#cc').combobox('getValue'),
                status: $('#status').val(),
                articleContent: editor.txt.html()
            }, function (data) {
                $('#addArt').form('reset');
            }, "json"
        );
    }

    function reset() {
        $('#addArt').form('reset');
    }


</script>
<form id="addArt" method="post" enctype="multipart/form-data" style="background-color: #f2c56d;height: 100%">
    <div>
        文章标题:&nbsp;&nbsp;<input id="name" class="easyui-validatebox" type="text" name="articleName"
                                style="width:200px"/>
    </div>
    <br/>
    <div>
        文章作者:&nbsp;&nbsp;<input id="cc" name="masterId" value="请选择上师">
    </div>
    <br/>
    <div>
        文章状态:&nbsp;&nbsp; <input id="status" name="status" class="easyui-switchbutton"
                                 data-options="onText:'上架',offText:'未上架'">
    </div>
    <br/>
    <div>
        文章内容:&nbsp;&nbsp;<br/><br/>
        <div id="editor">
        </div>
    </div>
    <br/>
    <a class="easyui-linkbutton" data-options="onClick:add">创建文章</a>
    <a class="easyui-linkbutton" data-options="onClick:reset">重置文章</a>
</form>
