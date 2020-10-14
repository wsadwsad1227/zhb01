<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if (cauthor.value == "") {
			alert("用户名不能为空！！");
			return false;
		} else if (content.value == "") {
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
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


		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>

					<c:forEach items="${requestScope.gnNews}" var="news" end="4">
						<li><a href='detail?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>

				</ul>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>

					<c:forEach items="${requestScope.gjNews}" var="news" end="4">
						<li><a href='detail?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>

				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${requestScope.ylNews}" var="news" end="4">
						<li><a href='detail?nid=${news.nid}'><b>${news.ntitle}</b></a></li>

					</c:forEach>

				</ul>
			</div>
		</div>


		<div class="main">
			<div class="class_type">
				<img src="images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center">
						<tr width="100%">
							<td colspan="2" align="center">${newsById.ntitle}</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">作者：${newsById.nauthor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td align="left">发布时间：${newsById.ncreateDate}</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2">${newsById.ncontent}</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
					</table>
				</ul>

				<ul class="classlist">
					<table width="80%" align="center">


						<c:forEach items="${requestScope.listComment}" var="comment">
							<tr>
								<td>留言人：</td>
								<td>${comment.cauthor}</td>
								<td>IP：</td>
								<td>${comment.cip}</td>
								<td>留言时间：</td>
								<td>${comment.cdate}</td>
							</tr>
							<tr>
								<td colspan="6">${comment.ccontent}</td>
							</tr>
							<tr>
								<td colspan="6"><hr /></td>
							</tr>
						</c:forEach>


					</table>
				</ul>
				<ul class="classlist">
					<form action="addNews" method="post">
						<input type="hidden" name="cnid" value="${param.nid}" />
						<table width="80%" align="center">
							<tr>
								<td>评 论</td>
								<p align="center">
									当前页数:[${sessionScope.commentPage}/${sessionScope.allCommentPage}]&nbsp;
									<a
										href="showNews?commentPage=${1}&nid=${param.nid}">首页</a>
									<a
										href="showNews?commentPage=${sessionScope.commentPage-1}&nid=${param.nid}">上一页</a>
									<a
										href="showNews?commentPage=${sessionScope.commentPage+1}&nid=${param.nid}">下一页</a>
									<a
										href="showNews?commentPage=${sessionScope.allCommentPage}&nid=${param.nid}">末页</a>
								</p>
							</tr>
							<tr>
								<td>用户名：</td>
								<td><input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" />


									IP： <input name="cip" id="cip" value="127.0.0.1"
									readonly="readonly" style="border: 0px;" /></td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="ccontent" id="ccontent"
										cols="70" rows="10"></textarea></td>
							</tr>
							<tr>
								<td><input name="submit" value="发  表" type="submit" /></td>
							</tr>
						</table>
					</form>
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
</body>
</html>
