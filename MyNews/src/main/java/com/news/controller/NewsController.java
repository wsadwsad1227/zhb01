package com.news.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.pojo.Comments;
import com.news.pojo.News;
import com.news.pojo.Topic;
import com.news.service.CommentsService;
import com.news.service.NewsService;
import com.news.service.TopicService;

@Controller
public class NewsController {
@Resource
NewsService newsServiceImpl;
@Resource
TopicService topicServiceImpl;
@Resource
CommentsService commentsServiceImpl;
@RequestMapping("index")
public String index(Model model,HttpServletRequest request,String tid){
	HttpSession session = request.getSession();
	List<News> gnNews=newsServiceImpl.getNewsByTopicId(1, 30, 1);
	List<News> gjNews=newsServiceImpl.getNewsByTopicId(1, 30, 2);
	List<News> ylNews=newsServiceImpl.getNewsByTopicId(1, 30, 3);
	List<Topic> listTopic = topicServiceImpl.getTopList();
	List<News> listNews =null;
	if(tid==null) {
		session.setAttribute("indexPage", 1);
		int newsNumber=newsServiceImpl.getAllNewsNumber();
		int page=0;
		if(newsNumber%30==0) {
			page=newsNumber/30;
			session.setAttribute("allPage", newsNumber/30);
		}else {
			page=(newsNumber/30)+1;
			session.setAttribute("allPage", (newsNumber/30)+1);
		}
		String indexPage=request.getParameter("pageIndex");
		if(indexPage!=null) {
			int Topage=Integer.parseInt(indexPage);
			session.setAttribute("indexPage", Topage);
			if(Topage>page) {
				session.setAttribute("indexPage", page);
			}
			if(Topage<1) {
				session.setAttribute("indexPage", 1);
			}
		}
		listNews=newsServiceImpl.getNewsInfo(Integer.parseInt(session.getAttribute("indexPage").toString()), 30);
	}else {

		session.setAttribute("indexPage", 1);
		request.setAttribute("tid", tid);
		int newsNumber=newsServiceImpl.getTopicNewsNumber(tid);
		int page=0;
		if(newsNumber%30==0) {
			page=newsNumber/30;
			session.setAttribute("allPage", newsNumber/30);
		}else {
			page=(newsNumber/30)+1;
			session.setAttribute("allPage", (newsNumber/30)+1);
		}
		String indexPage=request.getParameter("pageIndex");
		if(indexPage!=null) {
			int Topage=Integer.parseInt(indexPage);
			session.setAttribute("indexPage", Topage);
			if(Topage>page) {
				session.setAttribute("indexPage", page);
			}
			if(Topage<1) {
				session.setAttribute("indexPage", 1);
			}
		}
		listNews=newsServiceImpl.getNewsByTopicId(Integer.parseInt(session.getAttribute("indexPage").toString()), 30, Integer.parseInt(tid));
	
	}
	model.addAttribute("gnNews", gnNews);
	model.addAttribute("gjNews", gjNews);
	model.addAttribute("ylNews", ylNews);
	model.addAttribute("listTopic", listTopic);
	model.addAttribute("listNews", listNews);
	return "index.jsp";
}
@RequestMapping("readNews")
private String readNews(Model model,HttpServletRequest request,String nid) {
	List<News> gnNews = newsServiceImpl.getNewsByTopicId(1,30,1);

	// 国际新闻
	List<News> gjNews = newsServiceImpl.getNewsByTopicId(1,30,2);
	
	// 娱乐新闻
	List<News> ylNews = newsServiceImpl.getNewsByTopicId(1,30,5);
	News newsById = newsServiceImpl.getNewsById(nid);
	int nid2 = newsById.getNid();
	List<Comments> findComments = commentsServiceImpl.findComments(1,5,nid2);
	System.out.println(newsById.getNid());
	for (Comments comments : findComments) {
		System.out.println(comments.getCcontent());
	}
	model.addAttribute("newsById", newsById);
	model.addAttribute("listComment", findComments);
	model.addAttribute("gnNews", gnNews);
	model.addAttribute("gjNews", gjNews);
	model.addAttribute("ylNews", ylNews);
	return "readNews.jsp";
}
}
