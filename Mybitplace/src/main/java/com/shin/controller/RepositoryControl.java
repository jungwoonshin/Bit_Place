package com.shin.controller;



import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shin.dao.RepositoryDao;
import com.shin.vo.Content;

@Controller
@RequestMapping("/group")
public class RepositoryControl {
	static Logger logger = Logger.getLogger(RepositoryControl.class);


	@Autowired
	RepositoryDao repositoryDao;

	@RequestMapping("/{groupNo}") 
	public ModelAndView list(
			@PathVariable("groupNo") int groupNo, 
			HttpSession session,
			ServletResponse response)
					throws Exception {

		ModelAndView mv = new ModelAndView();

		String user_email = "test1@test.com";
		
		//로그인을 가정하기 위해 임시적으로 컨트롤러에서 세션 객체에 user email값을 입력한다. 
		session.setAttribute("user_email", user_email);
		
		//session에서 받아온 유저의 이메일 주소를 토대로 데이터베이스에서 mno값을 읽어온다. 
		int mno = repositoryDao.selectMno(user_email);
		
		//유저의 mno값을 이용하여 속한 클래스 정보를 받아온다. 
		List<String> classNames = repositoryDao.selectClass(mno);

		//groupNo를 이용하여 그 그룹의 모든 컨텐트 정보를 가져온다. 
		List<Content> contentInClass = repositoryDao.selectContents(groupNo);
//		System.out.println(contentInClass.toString());
		
		
		
		
		
		mv.setViewName("/jsp/Main");

		return mv;
	}

















}
