<%@ page import="com.seecen.Messagess.JuheDemo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--使用el表达式--%>
<%@ page isELIgnored="false" %>
<%--使用jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<%--<script src="js/jquery.js"></script>--%>
<script src="js/jquery.min.js"></script>
<script type='text/javascript' src='../pages/js/jquery-2.1.1.min.js'></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="textml; charset=utf-8" />

<meta name="keywords" content="" />
<title>二组</title>
<link rel="stylesheet" href="css/style.css">
<%--<c:set var="ctx" value="${pageContext.request.contextPath}" scope="page"/>--%>
<script type="text/javascript">
    $(function  () {
        //获取短信验证码
        var validCode=true;
        $(".msgs").click (function  () {
            var time=30;
            var code=$(this);
            if (validCode) {
                validCode=false;
                code.addClass("msgs1");
                var t=setInterval(function  () {
                    time--;
                    code.html(time+"秒");
                    if (time == 0) {
                        clearInterval(t);
                        code.html("重新获取");
                        validCode=true;
                        code.removeClass("msgs1");
                    }
                },1000)
            }
        })
    })
</script>

<style type="text/css">
	.msgs{display:inline-block;width:104px;color:#fff;font-size:12px;border:1px solid #0697DA;text-align:center;height:30px;line-height:30px;background:#0697DA;cursor:pointer;}
</style>
<body>
<%--<%=request.getAttribute("fail") == null ?  " " :request.getAttribute("fail")%>--%>
<%--<% JuheDemo.getRequest2();--%>

<%--%>--%>
<div style="color:red">${fail}</div>
<div class="register-container">
	<h1>二组考试系统管理</h1>

	<div class="connect">
		<p>欢迎加入我们</p>
	</div>

	<form action="/user/register.action" method="post" id="registerForm">
		<div>
			<input type="text" name="userName" class="username" placeholder="您的用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<select class="" name="classId">
				<option value="" class="email">--请选择班级--</option>
				<option value="1" class="email">1905</option>
				<option value="2" class="email">1906</option>
				<option value="3" class="email">1907</option>
			</select>

		</div>
		<div>

			<input type="text" name="telephone"  placeholder="输入手机号码" autocomplete="off" id="number"/>

		</div>


		<input style="width:150px;float:left;" type="text" class="c_code_msg" name="msgs" placeholder="输入验证码">
		<a id="yzmtj" href="#" ><span style="display: block;margin-top:30px;float:right;" class="msgs" >获取短信验证码</span></a>
		<script>
                /*var tel;

			     tel = $("#number").val();
                alert(tel);*/

                $(document).ready(function(){
                    function initDataCallBack(telephone){
                        if(ajaxObj.readyState ==4 && ajaxObj.status ==200){
                            alert("成功");
                        }
                    }

                    var ajaxObj;
                    function initDada(telephone){
                        //1.创建ajax请求对象
                        ajaxObj = new XMLHttpRequest();
                        //2.执行open设置url和请求方式
                        ajaxObj.open("get","${ctx}/user/yzm.action?telephone="+telephone,true);
                        //3.设置回调
                        ajaxObj.onreadystatechange = initDataCallBack;
                        //4.发送
                        ajaxObj.send();
                    }

                    $("#yzmtj").click(function(){
                        var telephone=$("#number").val();
                        alert(telephone);
                        // $("#yzmtj").attr("href","/user/yzm.action?telephone="+telephone);
                        initDada(telephone);
                    });
                });

		</script>

		<button id="submit" type="submit">注 册</button>
		<%--<input type="submit"  id="submit"  value="注册">--%>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>

</body>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js"></script>
</html>