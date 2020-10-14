package com.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.mapper.TopicMapper;
import com.news.pojo.Topic;
import com.news.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
@Resource
private TopicMapper topicMapper;

@Override
public int addTopic(String tname) {
	// TODO Auto-generated method stub
	return topicMapper.addTopic(tname);
}

@Override
public int updateTopic(String tname, String tid) {
	// TODO Auto-generated method stub
	return topicMapper.updateTopic(tname, tid);
}

@Override
public int deleteTopic(int tid) {
	// TODO Auto-generated method stub
	return topicMapper.deleteTopic(tid);
}

@Override
public List<Topic> getTopList() {
	// TODO Auto-generated method stub
	return topicMapper.getTopList();
}

@Override
public Topic findTopic(int tid) {
	// TODO Auto-generated method stub
	return topicMapper.findTopic(tid);
}

}
