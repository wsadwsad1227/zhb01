package com.news.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.News;

public interface NewsService {
	public List<News> getNewsList();
	List<News> getNewsInfo(int currerntPage, int pageSize);

	public News getNewsById(@Param("nid")String newsid);
	public List<News> getNewsByTopicId(int currerntPage, int pageSize,int topicid);
	public int getAllNewsNumber();
	public int getTopicNewsNumber(@Param("ntid")String tid);
}
