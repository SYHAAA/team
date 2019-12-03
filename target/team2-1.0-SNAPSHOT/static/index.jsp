<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="core.jsp"%>
<%--<%@include file="core.jsp"%>--%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>二组考试系统</title>

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
        <style>
            .ul1{
                width:90px;
                height:103px;
                display: none;
                position: absolute;
                text-align: center;
            }
            li{
                display: block;
            }
            .L1{
                line-height: 50px;
                font-size:15px;
            }
            .L1:hover .ul1{
                display: block;
            }
        </style>

    </head>
	<body>

		<!-- Header -->
		<header id="header" class="transparent-nav">
			<div class="container">


				<div class="navbar-header">
					<!-- Logo -->
					<div class="navbar-brand">
						<a class="logo" href="index.jsp">
							<img src="./images/logo-alt.png" alt="logo">
						</a>
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
						<li class="L1" style="position:relative;"><a href="#">考试系统</a>
                        <ul class="ul1">
                            <li style="display: block;float: none;width:90px;height:50px;"><a href="javascript:;" onclick="window.open('/pages/exam-start.html')">选择考试</a></li>
                            <li style="display: block;float: none;width:90px;height:50px;"><a href="javascript:;" onclick="window.open('/pages/exam-history.html')">考试历史</a></li>
                        </ul>
                        </li>
						<li><a href="/pages/test.html">论坛模块</a></li>
						<li><a href="/page/QQ.html">交友平台</a></li>
						<li><a href="/pages/cloud_note.html">学习模块</a></li>
						<c:if test="${userdata.isadmin == 1}">
						<li class="admins"><a href="../pages/backState-index.html">进入后台</a></li>
						</c:if>
						<c:if test="${userdata.isadmin == 0}">
							<li style="display: none;" class="admins"><a href="../pages/backState-index.html">进入后台</a></li>
						</c:if>
						<li class="admins"><a href="Myself.jsp">个人中心</a></li>
						<li class="admins"><a href="${ctx}/user/goout.action">退出登录</a></li>
					</ul>
				</nav>
				
				<!-- /Navigation -->

			</div>
		</header>
		<!-- /Header -->

		<!-- Home -->
		<div id="home" class="hero-area">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./images/home-background.jpg)"></div>
			<!-- /Backgound Image -->

			<div class="home-wrapper">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<h1 class="white-text">WE ARE TEAM TWO</h1>
							<p class="lead white-text">这些是我们的模块！</p>
							<a class="main-button icon-button" href="#">Get Started!</a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /Home -->

		<!-- About -->
		<div id="about" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">

					<div class="col-md-6">
						<div class="section-header">
							<h2>Welcome to TEAM2</h2>
							<p class="lead">模块展示</p>
						</div>

						<!-- feature -->
						<div class="feature">
							<i class="feature-icon fa fa-flask"></i>
							<div class="feature-content">
								<h4>学习模块 </h4>
								<p>Ceteros fuisset mei no, soleat epicurei adipiscing ne vis. Et his suas veniam nominati.</p>
							</div>
						</div>
						<!-- /feature -->

						<!-- feature -->
						<div class="feature">
							<i class="feature-icon fa fa-users"></i>
							<div class="feature-content">
								<h4>论坛模块</h4>
								<p>Ceteros fuisset mei no, soleat epicurei adipiscing ne vis. Et his suas veniam nominati.</p>
							</div>
						</div>
						<!-- /feature -->

						<!-- feature -->
						<div class="feature">
							<i class="feature-icon fa fa-comments"></i>
							<div class="feature-content">
								<h4>交友平台</h4>
								<p>Ceteros fuisset mei no, soleat epicurei adipiscing ne vis. Et his suas veniam nominati.</p>
							</div>
						</div>
						
						<div class="feature">
							<i class="feature-icon fa fa-envelope"></i>
							<div class="feature-content">
								<h4>考试系统</h4>
								<p>Ceteros fuisset mei no, soleat epicurei adipiscing ne vis. Et his suas veniam nominati.</p>
							</div>
						</div>
						<!-- /feature -->

					</div>

					<div class="col-md-6">
						<div class="about-img">
							<img src="./images/about.png" alt="">
						</div>
					</div>

				</div>
				<!-- row -->

			</div>
			<!-- container -->
		</div>
		<!-- /About -->

		<!-- Courses -->
		<div id="courses" class="section"></div>

			


		<!-- jQuery Plugins -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/main.js"></script>

	</body>
</html>
