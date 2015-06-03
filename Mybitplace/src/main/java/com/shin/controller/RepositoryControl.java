package com.shin.controller;



import java.util.List;

import javax.json.JsonArray;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shin.dao.RepositoryDao;
import com.shin.github.MyGit;
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
		String user_email = member.getEmail();
		System.out.println("user_email: " + user_email);

		ModelAndView mv = new ModelAndView();


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

	@RequestMapping(value="/selectcontent", method=RequestMethod.GET)
	public String selectContent(
			@RequestParam() int content_no, 
			Model model
			){
		List<Content> selectedContent=null;
		try {
			selectedContent = repositoryDao.selectOneContent(content_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		model.addAttribute("selectedContent", selectedContent);
		
		JsonArray tree_jsonArray = MyGit.getMainTree(selectedContent.get(0).getGit_id(), selectedContent.get(0).getGit_repository());
		model.addAttribute("tree_jsonArray", tree_jsonArray);		
		return "/repo/json/selectcontent";
	}

	@RequestMapping(value="/selecttree", method=RequestMethod.GET)
	public String selectTree(
			@RequestParam() String tree_sha,
			@RequestParam() String repo_id,
			@RequestParam() String repo_name,
			Model model
			){
		JsonArray tree_sha_jsonArray = MyGit.getTreeBySha(repo_id, repo_name, tree_sha);
		model.addAttribute("tree_sha_jsonArray", tree_sha_jsonArray);		
		return "/repo/json/selecttree";
	}
	
	
	
	
	

	

}
