package com.news.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.NewsUsers;

public interface NewsUsersService {
	public int regist(String uname,String upwd);
	public NewsUsers login(String uname, String upwd);
	public int update(NewsUsers newsUsers);
	public List<NewsUsers> allUser();
	public int deleteUser(int uid);
}
