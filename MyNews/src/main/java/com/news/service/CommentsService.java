package com.news.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.Comments;

public interface CommentsService {
	public int addComments(Comments comments);
	public int updateComments(Comments comments);
	public int deleteComments(int cid);
	public List<Comments> getCommentsList();
	public List<Comments> findComments(int currerntPage, int pageSize,int cnid);
	public int commentNumber(int cnid);
}
