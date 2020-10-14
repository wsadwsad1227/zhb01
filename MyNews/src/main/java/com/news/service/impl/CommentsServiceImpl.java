package com.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.mapper.CommentsMapper;
import com.news.pojo.Comments;
import com.news.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService{
	@Resource
	private CommentsMapper commentsMapper;
	@Override
	public int addComments(Comments comments) {
		// TODO Auto-generated method stub
		return commentsMapper.addComments(comments);
	}

	@Override
	public int updateComments(Comments comments) {
		// TODO Auto-generated method stub
		return commentsMapper.updateComments(comments);
	}

	@Override
	public int deleteComments(int cid) {
		// TODO Auto-generated method stub
		return commentsMapper.deleteComments(cid);
	}

	@Override
	public List<Comments> getCommentsList() {
		// TODO Auto-generated method stub
		return commentsMapper.getCommentsList();
	}

	@Override
	public int commentNumber(int cnid) {
		// TODO Auto-generated method stub
		return commentsMapper.commentNumber(cnid);
	}

	@Override
	public List<Comments> findComments(int currerntPage, int pageSize, int cnid) {
		int start = (currerntPage - 1) * pageSize;
		int end = currerntPage * pageSize;
		return commentsMapper.findComments(start, end, cnid);
	}

}
