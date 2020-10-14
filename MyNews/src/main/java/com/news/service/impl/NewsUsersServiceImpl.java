package com.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.mapper.NewsUsersMapper;
import com.news.pojo.NewsUsers;
import com.news.service.NewsUsersService;

@Service
public class NewsUsersServiceImpl implements NewsUsersService{
@Resource
private NewsUsersMapper newsUsersMapper;

@Override
public int regist(String uname, String uwpd) {
	// TODO Auto-generated method stub
	return newsUsersMapper.regist(uname, uwpd);
}

@Override
public NewsUsers login(String uname, String uwpd) {
	// TODO Auto-generated method stub
	return newsUsersMapper.login(uname, uwpd);
}

@Override
public int update(NewsUsers newsUsers) {
	// TODO Auto-generated method stub
	return newsUsersMapper.update(newsUsers);
}

@Override
public List<NewsUsers> allUser() {
	// TODO Auto-generated method stub
	return newsUsersMapper.allUser();
}

@Override
public int deleteUser(int uid) {
	// TODO Auto-generated method stub
	return newsUsersMapper.deleteUser(uid);
}

}
