package com.news.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.pojo.Comments;
import com.news.pojo.News;
import com.news.service.CommentsService;
import com.news.service.NewsService;

@Controller
public class CommentsController {
	@Resource
	CommentsService commentsServiceImpl;
	@Resource
	NewsService newsServiceImpl;
	@Resource
	Comments c;
	@RequestMapping("addNews")
	public String addNews(Model model, HttpServletRequest request,String ccontent,String cip,String cauthor,String cnid){
		c.setCip(cip);
		c.setCcontent(ccontent);
		c.setCauthor(cauthor);
		c.setCdate(new Date());
		if(cnid!=null) {
			c.setCnid(Integer.parseInt(cnid));
		}
		commentsServiceImpl.addComments(c);
		News newsById = newsServiceImpl.getNewsById(cnid+"");
		
		HttpSession session = request.getSession();
		session.setAttribute("commentPage", 1);
		String nid=request.getParameter("nid");
		request.setAttribute("nid", nid);
		int commentNumber=commentsServiceImpl.commentNumber(Integer.parseInt(cnid));
		int page=0;
		if(commentNumber%5==0) {
			page=commentNumber/5;
			session.setAttribute("allCommentPage", commentNumber/5);
		}else {
			page=(commentNumber/5)+1;
			session.setAttribute("allCommentPage", (commentNumber/5)+1);
		}
		String commentPage=request.getParameter("commentPage");
		System.out.println(commentPage);
		System.out.println(page);
		if(commentPage!=null) {
			int Topage=Integer.parseInt(commentPage);
			session.setAttribute("commentPage", Topage);
			if(Topage>page) {
				session.setAttribute("commentPage", page);
			}
			if(Topage<1) {
				session.setAttribute("commentPage", 1);
			}
		}
		
		List<Comments> findComments = commentsServiceImpl.findComments(1,5,newsById.getNid());
		request.setAttribute("newsById", newsById);
		request.setAttribute("listComment", findComments);
		return "redirect:showNews?commentPage=1&nid="+cnid;
	}
	@RequestMapping("showNews")
	public String addNews(Model model, HttpServletRequest request,String nid,String commentPage) {

		HttpSession session = request.getSession();
		session.setAttribute("commentPage", 1);
		request.setAttribute("nid", nid);
		int commentNumber=commentsServiceImpl.commentNumber(Integer.parseInt(nid));
		int page=0;
		if(commentNumber%5==0) {
			page=commentNumber/5;
			session.setAttribute("allCommentPage", commentNumber/5);
		}else {
			page=(commentNumber/5)+1;
			session.setAttribute("allCommentPage", (commentNumber/5)+1);
		}
		System.out.println(commentPage);
		System.out.println(page);
		if(commentPage!=null) {
			int Topage=Integer.parseInt(commentPage);
			session.setAttribute("commentPage", Topage);
			if(Topage>page) {
				session.setAttribute("commentPage", page);
			}
			if(Topage<1) {
				session.setAttribute("commentPage", 1);
			}
			List<Comments> findComments = commentsServiceImpl.findComments(Integer.parseInt(session.getAttribute("commentPage").toString()), 5, Integer.parseInt(nid));
			request.setAttribute("listComment", findComments);
			News newsById = newsServiceImpl.getNewsById(nid);
			request.setAttribute("newsById", newsById);
			return "readNews.jsp";
		}
		return "readNews.jsp";
	}
}
