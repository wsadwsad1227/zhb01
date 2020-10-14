package com.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.NewsUsers;

public interface NewsUsersMapper {
	public int regist(@Param("uname")String uname,@Param("upwd")String upwd);
	public NewsUsers login(@Param("uname")String uname, @Param("upwd")String upwd);
	public int update(NewsUsers newsUsers);
	public List<NewsUsers> allUser();
	public int deleteUser(@Param("uid")int uid);
}
