package com.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.News;

public interface NewsMapper {
	public List<News> getNewsList();
	List<News> getNewsInfo(@Param("start")int start, @Param("end")int end);

	public News getNewsById(@Param("nid")String newsid);
	public List<News> getNewsByTopicId(@Param("ntid")int ntid, @Param("start")int start,@Param("end")int end);
	public int getAllNewsNumber();
	public int getTopicNewsNumber(@Param("ntid")String tid);

}
