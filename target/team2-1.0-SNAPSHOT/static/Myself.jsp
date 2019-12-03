<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="core.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>个人中心</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css/style2.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>

		<!-- Header -->
		<header id="header">
			<div class="container">

				<div class="navbar-header">
					<!-- Logo -->
					<div class="navbar-brand">

						<c:if test="${not empty userdata.facePath}">
							<%--后台以下载的方式的读取二进制字节流图片，部署在img中就可以显示在页面中--%>
							<img style="border:0;border-radius:25px;" width="50" height="100%" onerror="this.src='${ctx}/static/images/default.jpg'"
								 src="${ctx}/user/image.action?fileName=${userdata.facePath}"/>
						</c:if>
						<c:if test="${empty userdata.facePath}">
							<img style="border:0;" style="border:1px solid #ccc;border-radius:25px;" width="50" height="100%" onerror="this.src='${ctx}/static/images/default.jpg'" src="${ctx}/${user.facePath}"/>
						</c:if>
					</div>
					<!-- /Logo -->

					<!-- Mobile toggle -->
					<button class="navbar-toggle">
						<span></span>
					</button>
					<!-- /Mobile toggle -->
				</div>

				<!-- Navigation -->
				<nav id="nav">
					<ul class="main-menu nav navbar-nav navbar-right">
						<li><a href="index.jsp">首页</a></li>
						<li><a href="#">考试系统</a></li>
						<li><a href="#">论坛模块</a></li>
						<li><a href="#">交友平台</a></li>
						<li><a href="#">学习模块</a></li>
					</ul>
				</nav>
				<!-- /Navigation -->

			</div>
		</header>
		<!-- /Header -->

		<!-- Hero-area -->
		<div class="hero-area section">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./images/page-background.jpg)"></div>
			<!-- /Backgound Image -->

			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1 text-center">
						<h1 class="white-text">请完善个人资料</h1>

					</div>
				</div>
			</div>

		</div>
		<!-- /Hero-area -->

		<!-- Contact -->
		<div id="contact" class="section">

			<!-- container -->
			<div class="container" style="height:400px;">

				<!-- row -->
				<div class="row">

					<!-- contact form -->
					<div class="col-md-6">
						<div class="contact-form">
							<h4>请完善你的资料</h4>
							<form method="post" action="${ctx}/user/myself.action" enctype="multipart/form-data">
								<input type="hidden" value=${userdata.userId} name="userId">
								<%--<script>alert(${user.userName})</script>--%>
								<c:if test="${not empty user.userName}">
									<input r style="width:280px;" class="input" type="text" name="userName" placeholder="Name" value=${user.userName}>
								</c:if>
								<c:if test="${empty user.userName}">
									<input readonly style="width:280px;" class="input" type="text" name="userName" placeholder="Name" value=${userdata.userName}>
								</c:if>

								男：<input class="input" type="radio" name="gender" placeholder="Name" value="1">
								女：<input class="input" type="radio" name="gender" placeholder="Name" value="0"><br>
								请更换您的专属头像:<input type="hidden" name="facePath">
								<input style="margin-top:10px;" class="input" name="file" type="file" placeholder="设置头像">
								修改密码：<input style="width:350px;" class="input" type="password" name="password" placeholder="Password"><br><br>
								<!--<textarea class="input" name="message" placeholder="Enter your Message"></textarea>-->
								<button style="float:left;margin-top:30px;" class="main-button icon-button pull-right">确认提交</button>
							</form>
						</div>
					</div>
					<!-- /contact form -->

					<!-- contact information -->
					<div class="col-md-5 col-md-offset-1">
						<h4>联系我们</h4>
						<ul class="contact-details">
							<li><i class="fa fa-envelope"></i>二组e@email.com</li>
							<li><i class="fa fa-phone"></i>122-547-223-45</li>
							<li><i class="fa fa-map-marker"></i>4476 Clement Street</li>
						</ul>

						<!-- contact map -->
						<div id="contact-map"></div>
						<!-- /contact map -->

					</div>
					<!-- contact information -->

				</div>
				<!-- /row -->

			</div>
			<!-- /container -->

		</div>
		<!-- /Contact -->

		<!-- Footer -->
		<footer id="footer" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">




					<!-- /footer nav -->

				</div>
				<!-- /row -->

				<!-- row -->
				<div id="bottom-footer" class="row">

					<!-- social -->
					<div class="col-md-4 col-md-push-8">
						<ul class="footer-social">
							<li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="instagram"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#" class="youtube"><i class="fa fa-youtube"></i></a></li>
							<li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
						</ul>
					</div>
					<!-- /social -->

					<!-- copyright -->
					<div class="col-md-8 col-md-pull-4">
						<div class="footer-copyright">
							<span>&copy; Copyright 2019. Team2 Complete <a href="http://www.cssmoban.com/" target="_blank">二组之家</a> - Collect from <a href="http://www.cssmoban.com/" target="_blank">Coll</a></span>
						</div>
					</div>
					<!-- /copyright -->

				</div>
				<!-- row -->

			</div>
			<!-- /container -->

		</footer>
		<!-- /Footer -->

		<!-- preloader -->
		<div id='preloader'><div class='preloader'></div></div>
		<!-- /preloader -->


		<!-- jQuery Plugins -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<!--<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>-->
		<script type="text/javascript" src="js/google-map.js"></script>
		<script type="text/javascript" src="js/main.js"></script>

	</body>
</html>
