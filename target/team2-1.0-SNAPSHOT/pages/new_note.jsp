<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="page"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新建笔记</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/pages/lib/layui/css/layui.css">
    <script src="/pages/js/jquery.min.js"></script>
    <script src="/pages/lib/layui/layui.js"></script>
    <script>
        $(document).ready(function () {
            var time = new Date();
            var day = ("0" + time.getDate()).slice(-2);
            var month = ("0" + (time.getMonth() + 1)).slice(-2);
            var today = time.getFullYear() + "-" + (month) + "-" + (day);
            $('#createDate').val(today);
        })
        $(document).ready(function () {
            var time = new Date();
            var day = ("0" + time.getDate()).slice(-2);
            var month = ("0" + (time.getMonth() + 1)).slice(-2);
            var today = time.getFullYear() + "-" + (month) + "-" + (day);
            $('#updateDate').val(today);
        })
        layui.use(['layer', 'form', 'laypage', 'table','laydate'], function() {
            var layer = layui.layer
                , form = layui.form
                , laypage = layui.laypage
                , table = layui.table
                , laydate = layui.laydate;

            //var id=router.search.id;
            layui.use(['layedit'], function () {
                var layedit = layui.layedit;
                // 富文本
                var router = layui.router();
                var result = router.search.result;
                if (result == 1) parent.layui.table.reload('noteTable');
                layedit.set({
                    uploadImage: {
                        url: '/file/uploadImage.action' //接口url
                        , type: 'post'
                    }
                });
                var index = layedit.build('myText1', {
                    height: 500
                    , width: 600
                });
                //建立编辑器
            });
        });
    </script>
<body>
<form  lay-filter="fm-filter" class="layui-form" method="post" action="/note/note/add.action" style="margin-left:-100px;">
    <form id="fm" class="layui-form">
        <input type="hidden" name="noteId" value="${note.noteId}"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="notebookId" value="${note.notebookId}"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="userId" value="${note.userId}"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="nValid" value="1"
               autocomplete="off" class="layui-input">

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="text" name="title"
                       placeholder="请输入笔记标题"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" >
                 <textarea id="myText1" name="content"  placeholder="请输入笔记内容">
                 </textarea>
            </div>
        </div>
        <input type="hidden" id="createDate" placeholder="yyyy-MM-dd HH:mm:ss"/>
        <input type="hidden" id="updateDate" placeholder="yyyy-MM-dd HH:mm:ss"/>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
            </div>
        </div>
    </form>
</form>
</body>
</html>