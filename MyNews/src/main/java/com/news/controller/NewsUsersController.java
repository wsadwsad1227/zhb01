package com.news.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.pojo.NewsUsers;
import com.news.service.NewsUsersService;

@Controller
public class NewsUsersController {
@Resource
NewsUsersService newsUsersServiceImpl;
@RequestMapping("login")
public String login(Model model,HttpServletRequest request){

	HttpSession session = request.getSession();
	String uname=request.getParameter("uname");
	String upwd=request.getParameter("upwd");
	NewsUsers user = newsUsersServiceImpl.login(uname, upwd);
	List<NewsUsers> allUser = newsUsersServiceImpl.allUser();
	if(user!=null) {
		session.setAttribute("user", user);
		session.setAttribute("allUser", allUser);
		return "user.jsp";
	}else {
		return "Error.jsp";
	}
	
}
@RequestMapping("addUser")
public String addUser(Model model){
	return "userAdd.jsp";
}
@RequestMapping("doAddUser")
public String doAddUser(Model model,HttpServletRequest request){
	HttpSession session = request.getSession();
	String newname=request.getParameter("newname");
	String newupwd=request.getParameter("newupwd");
	newsUsersServiceImpl.regist(newname, newupwd);
	List<NewsUsers> allUser = newsUsersServiceImpl.allUser();
	session.setAttribute("allUser", allUser);
	return "userAdd.jsp";
}
@RequestMapping("updateUser")
public String updateUser(Model model){
	return "updateUser.jsp";
}
@RequestMapping("doUpdateUser")
public String doUpdateUser(Model model,HttpServletRequest request){
	HttpSession session = request.getSession();
	String updateuid=request.getParameter("updateuid");
	session.setAttribute("updateuid", updateuid);
	return "doUpdateUser.jsp";
}
@RequestMapping("newUpdateUser")
public String newUpdateUser(Model model,HttpServletRequest request){

	HttpSession session = request.getSession();
	NewsUsers nu=new NewsUsers();
	nu.setUid(Integer.parseInt(session.getAttribute("updateuid").toString()));
	String updatename=request.getParameter("updatename");
	String updatepwd=request.getParameter("updatepwd");
	nu.setUname(updatename);
	nu.setUpwd(updatepwd);
	newsUsersServiceImpl.update(nu);
	List<NewsUsers> allUser = newsUsersServiceImpl.allUser();
	session.setAttribute("allUser", allUser);
	return "updateUser.jsp";
}
@RequestMapping("deleteUser")
public String deleteUser(Model model){
	return "deleteUser.jsp";
}
@RequestMapping("dodeleteUser")
public String dodeleteUser(Model model,HttpServletRequest request){
	HttpSession session = request.getSession();
	String deleteuid=request.getParameter("deleteuid");
	session.setAttribute("deleteuid", deleteuid);
	newsUsersServiceImpl.deleteUser(Integer.parseInt(deleteuid));
	List<NewsUsers> allUser = newsUsersServiceImpl.allUser();
	session.setAttribute("allUser", allUser);

	return "deleteUser.jsp";
}
}
