package com.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.Comments;

public interface CommentsMapper {
	public int addComments(Comments comments);
	public int updateComments(Comments comments);
	public int deleteComments(@Param("cid")int cid);
	public List<Comments> getCommentsList();
	public List<Comments> findComments(@Param("start")int start,@Param("end")int end,@Param("cnid")int cnid);
	public int commentNumber(int cnid);
}
