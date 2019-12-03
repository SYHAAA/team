<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>考试成绩</title>
    <style>
        body{
            background: url(${pageContext.request.contextPath}/pages/images/bjt1.jpg);
            background-size: 100%;
        }
        *{
            margin:0;
            padding:0;
        }
        #big{
            width:500px;
            height:600px;
            /*outline: 1px solid #ccc;*/
            margin:0 auto;
        }
        .circle{
            background: '${pageContext.request.contextPath}/pages/images/bjt1.jpg';
            width:300px;
            height:300px;
            border-radius:50px;
        }
    </style>
</head>
<body>
<div id="big">
    <p style="margin-bottom:-10px;width:490px;margin-left:10px;height:40px;line-height: 40px;text-align: center;font-size:35px;color:orangered;">&nbsp;交卷成功！</p>
    <div class="circle">
        <font color="lime" size="7">${source}</font>
    </div>
</div>

</body>
</html>>
