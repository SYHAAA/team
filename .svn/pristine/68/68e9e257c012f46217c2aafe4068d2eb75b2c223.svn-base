<%--
  Created by IntelliJ IDEA.
  User: Zully-s
  Date: 2019/10/29
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="page"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑笔记</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/pages/lib/layui/css/layui.css">
    <script src="/pages/js/jquery.min.js"></script>
    <script src="/pages/lib/layui/layui.js"></script>
</head>
<script>
    layui.use(['layer', 'form', 'laypage', 'table','laydate','layedit'], function() {
        var layer = layui.layer
            , form = layui.form
            , laypage = layui.laypage
            , table = layui.table
            , laydate = layui.laydate
            , layedit = layui.layedit;
        var router=layui.router();
        var id=router.search.id;
        var result=router.search.result;

        if(result==1)
            parent.layui.table.reload('noteTable');
        // var index=layer.load(2,{shade:0.5});

        layedit.set({
            uploadImage: {
                url: '/file/uploadImage.action' //接口url
                , type: 'post'
            }
        });

        //建立编辑器
        var index = layedit.build('myText1', {
            height: 500
            , width: 600
        });

        //提交时把值同步到文本域中
        form.verify({
            //content富文本域中的lay-verify值
            content: function(value) {
                return layedit.sync(index);
            }
        });

        //创建日期
        laydate.render({
            elem: '#dateStart'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#dateEnd'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#date'
            , type: 'datetime'
        });

        $.get("/note/note/init/"+ id + ".action",null,function(res){
            form.val("fm-filter",{
                "noteId":id
                ,"notebookId":res.notebookId
                ,"userId":res.userId
                ,"nValid":res.nValid
                ,"title":res.title
                ,"content":res.content
                ,"createDate":res.createDate
                ,"updateDate":res.updateDate
                ,"notePath":res.notePath
            });

            form.render("select");
            // layer.close(index);
        },"json");


    })

</script>
<body>
<form  lay-filter="fm-filter" class="layui-form" method="post" action="/note/note/update.action">
    <form id="fm" class="layui-form">
        <input type="hidden" name="noteId" value="1"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="notebookId" value="1"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="userId" value="1"
               autocomplete="off" class="layui-input">

        <input type="hidden" name="nValid" value="1"
               autocomplete="off" class="layui-input">

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="text" name="title"
                       autocomplete="off" class="layui-input" value="${note.title}">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" >
                 <textarea id="myText1" lay-verify="content" name="content">
                     ${note.content}
                 </textarea>
            </div>
        </div>
        <input type="hidden" id="createDate" placeholder="yyyy-MM-dd HH:mm:ss"/>
        <input type="hidden" id="updateDate" placeholder="yyyy-MM-dd HH:mm:ss"/>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
            </div>
        </div>
    </form>
</form>

</body>
</html>