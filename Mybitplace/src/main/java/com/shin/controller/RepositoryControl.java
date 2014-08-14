package com.shin.controller;



import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shin.dao.RepositoryDao;
import com.shin.vo.Content;
import com.shin.vo.Member;

@Controller
@RequestMapping("/repo")
public class RepositoryControl {
	static Logger logger = Logger.getLogger(RepositoryControl.class);


	@Autowired
	RepositoryDao repositoryDao;

	@RequestMapping("/list") 
	public ModelAndView list(
			HttpSession session,
			ServletResponse response)
					throws Exception {
		Member member = (Member) session.getAttribute("member");

		ModelAndView mv = new ModelAndView();
		
		String user_email = member.getEmail();
		

		System.out.println("user_email: " + user_email);
		
		
		//session에서 받아온 유저의 이메일 주소를 토대로 데이터베이스에서 mno값을 읽어온다. 
		int mno = repositoryDao.selectMno(user_email);
		System.out.println("mno: " + mno);
		//로그인 한 유저의 기본 groupNo를 받아온다. 
		int groupNo = repositoryDao.selectGroupNo(mno);
		System.out.println("groupNo: "  + groupNo);
		//유저의 mno값을 이용하여 속한 클래스 정보를 받아온다. 
		
		List<String> classNames = repositoryDao.selectClass(mno);
		mv.addObject("classNames", classNames);
		

		//groupNo를 이용하여 그 그룹의 모든 컨텐트 정보를 가져온다. 
		List<Content> contentInClass = repositoryDao.selectContents(groupNo);
		mv.addObject("contentInClass", contentInClass);
		mv.setViewName("/repo/json/RepositoryList");
		return mv;
	}










}
