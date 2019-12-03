<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--使用el表达式--%>
<%@ page isELIgnored="false" %>
<%--使用jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type='text/javascript' src='../pages/js/jquery-2.1.1.min.js'></script>
<link href="css/img_smooth_check.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/img_smooth_check.js"></script>



<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="textml; charset=utf-8" />
<meta name="keywords" content="" />
<title>学员登录</title>

<link rel="stylesheet" href="css/style.css">

<body>

<%--<%=session.getAttribute("fail") == null ?  " " :session.getAttribute("fail")%>--%>
<%--<%=request.getAttribute("fail") == null ?  " " :request.getAttribute("fail")%>--%>



<div class="login-container">
	<h1>二组考试系统管理</h1>

	<div class="connect">
		<p>欢迎回来</p>
		<div style="color:red">${fail}</div>
	</div>

	<form style="width:600px;margin-bottom:0;" action="/user/login.action" method="post" id="loginForm">
		<div>
			<input type="text" name="userName" class="username ins" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password ins" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>

		<!--图片验证-->
		<div style="margin-top:30px;" class="widgets__img_check_box" id="select" style="width:600px;margin:0 auto;top:2px;">
			<div class="widgets__img_display">
				<div class="widgets__img_cnt">
					<img src1="a.jpg" class="widgets__img_src" />
					<canvas class="widgets__img_fragment_hollow"></canvas>
					<div class="widgets__img_fragment_cnt">
						<canvas class="widgets__img_fragment widgets__img_fragment_shadow"></canvas>
						<canvas class="widgets__img_fragment widgets__img_fragment_content"></canvas>
					</div>
					<div class="widgets__icon_refresh"></div>
				</div>
			</div>
			<div class="widgets__smooth_cnt">
				<div class="widgets__smooth_bar"></div>
				<div class="widgets__smooth_circle"></div>
			</div>
		</div>

		<div class="refresh" style="margin-top:30px; text-align:center;">点击刷新</div>


		<button id="submit" type="submit">登 陆</button>
		<script type="text/javascript">
            var s = WIDGETS.imgSmoothCheck({
                selector: "#select",
                data: ["images/lbtu1.jpg"],
                imgHeight: 100,
                imgWidth: 200,
                allowableErrorValue: 3,
                success: function () {
                    alert("成功");
                },
                error: function (res) {
                    alert('重新再试');
                    $(".ins").val("");
                }
            });
            $(".refresh").on("click", function () {
                s.refresh();
            });
		</script>
	</form>

	<a href="register.jsp">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js"></script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">


</div>
</body>
</html>