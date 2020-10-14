<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body onload="focusOnLogin()">

	<div id="header">
		<div id="top_login">
			<form action="login" method="post" onsubmit="return check()">
				<input type="hidden" name="opr" value="login" /> <label>
					登录名 </label> <input type="text" id="uname" name="uname" value="" class="login_input" />
				<label> 密&#160;&#160;码 </label> <input type="password" name="upwd" id="upwd"
					value="" class="login_input" /> <input type="submit"
					class="login_sub" value="登录" /> <label id="error"> </label> <img
					src="images/friend_logo.gif" alt="Google" id="friend_logo" />
			</form>
			<script type="text/javascript">
	
				function check() {
					var login_username = document.getElementById("uname");
					var login_password = document.getElementById("upwd");
					if (login_username.value == "") {
						alert("用户名不能为空！请重新填入！");
						login_username.focus();
						return false;
					} else if (login_password.value == "") {
						alert("密码不能为空！请重新填入！");
						login_password.focus();
						return false;
					}
					return true;
				}

				function focusOnLogin() {
					var login_username = document.getElementById("uname");
					login_username.focus();
				}
			</script>
		</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">


		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${requestScope.gnNews}" var="news" end="4">
						<li><a href='readNews?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>

					<c:forEach items="${requestScope.gjNews}" var="news" end="4">
						<li><a href='readNews?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>

				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>

					<c:forEach items="${requestScope.ylNews}" var="news" end="4">
						<li><a href='readNews?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>


				</ul>
			</div>
		</div>



		<div class="main">
			<div class="class_type">
				<img src="images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="class_date">

					<li id='class_month'><c:forEach items="${listTopic}"
							var="topic">
							<a href="index?tid=${topic.tid}"><b>${topic.tname}</b></a>
						</c:forEach></li>
				</ul>
				<ul class="classlist">


					<c:forEach items="${listNews}" var="news" varStatus="i">


						<li><a href='readNews?nid=${news.nid}'>${news.ntitle}</a>
							<span>${news.ncreateDate}</span></li>
						
						<c:if test="${(i.index+1)%5==0}">
							<li class='space'></li>	
						</c:if>
						
						
						
					</c:forEach>


	




					<p align="center">
						当前页数:[${sessionScope.indexPage}/${sessionScope.allPage}]&nbsp; 
						<a href="index?pageIndex=${1}">首页</a>
						<a href="index?pageIndex=${sessionScope.indexPage-1}">上一页</a>
						<a href="index?pageIndex=${sessionScope.indexPage+1}">下一页</a>
						<a href="index?pageIndex=${sessionScope.allPage}">末页</a>
					</p>
				</ul>
			</div>
			<div class="picnews">
				<ul>
					<li><a href="#"><img src="images/Picture1.jpg" width="249"
							alt="" /> </a><a href="#">å¹»æ³ä¸­ç©¿è¶æ¶ç©º</a></li>
					<li><a href="#"><img src="images/Picture2.jpg" width="249"
							alt="" /> </a><a href="#">å½åºå¤åçåå</a></li>
					<li><a href="#"><img src="images/Picture3.jpg" width="249"
							alt="" /> </a><a href="#">æ°ææ¯ç§äº®é½å¸</a></li>
					<li><a href="#"><img src="images/Picture4.jpg" width="249"
							alt="" /> </a><a href="#">ç¾¤æéªèçº¢å°æ¯¯</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="friend">
		<h1 class="friend_t">
			<img src="images/friend_ico.gif" alt="合作伙伴" />
		</h1>
		<div class="friend_list">
			<ul>
				<li><a href="#">百度</a></li>
				<li><a href="#">谷歌</a></li>
				<li><a href="#">新浪</a></li>
				<li><a href="#">网易</a></li>
				<li><a href="#">搜狐</a></li>
				<li><a href="#">人人</a></li>
				<li><a href="#">中国政府网</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p class="">
			24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a>
			&#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
			文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a>
		</p>
		<p class="copyright">
			Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
			新闻中国 版权所有
		</p>
	</div>
</body>

</html>


