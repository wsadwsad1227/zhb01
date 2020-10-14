package com.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.Topic;

public interface TopicMapper {
	public int addTopic(@Param("tname")String tname);
	public int updateTopic(@Param("tname")String tname, @Param("tid")String tid);
	public int deleteTopic(@Param("tid")int tid);
	public List<Topic> getTopList();
	public Topic findTopic(@Param("tid")int tid);
}
