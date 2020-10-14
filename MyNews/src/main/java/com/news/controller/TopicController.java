package com.news.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.service.TopicService;

@Controller
public class TopicController {
@Resource
private TopicService topicServiceImpl;
}
