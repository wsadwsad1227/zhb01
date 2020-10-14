package com.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.mapper.NewsMapper;
import com.news.pojo.News;
import com.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
@Resource
private NewsMapper newsMapper;

@Override
public List<News> getNewsList() {
	// TODO Auto-generated method stub
	return newsMapper.getNewsList();
}

@Override
public News getNewsById(String newsid) {
	// TODO Auto-generated method stub
	return newsMapper.getNewsById(newsid);
}

@Override
public int getAllNewsNumber() {
	// TODO Auto-generated method stub
	return newsMapper.getAllNewsNumber();
}

@Override
public int getTopicNewsNumber(String tid) {
	// TODO Auto-generated method stub
	return newsMapper.getTopicNewsNumber(tid);
}

@Override
public List<News> getNewsByTopicId(int currerntPage, int pageSize, int topicid) {
	// TODO Auto-generated method stub
	int start = (currerntPage - 1) * pageSize;
	int end = currerntPage * pageSize;
	return newsMapper.getNewsByTopicId(topicid, start, end);
}

@Override
public List<News> getNewsInfo(int currerntPage, int pageSize) {
	// TODO Auto-generated method stub
	int start = (currerntPage - 1) * pageSize;
	int end = currerntPage * pageSize;
	return newsMapper.getNewsInfo(start, end);
}


}
