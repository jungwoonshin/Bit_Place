package bitplace.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bitplace.dao.Bit_Rep;
import bitplace.vo.Bean;

@Controller
@RequestMapping("main/{sub}/{service}")
public class Frame_Controller{	
	
	//loggedPage the firstpage to enter when the user login
	boolean logged = false;
	Bean bean; 
		
	@Autowired
	Bit_Rep repository;
	
	@ModelAttribute("data")
	public Object data(@PathVariable("service")String service,
				       @PathVariable("sub")String sub,
					   HttpServletRequest request,
					   HttpSession session){
		
		//Repository for ModelAttribute
		Object res = null;		
		Integer no = 0;
		try{
		no = (Integer)session.getAttribute("memNo");
		System.out.println("Frame_Controller logged Member ID received from Session: "+session.getAttribute("memNo"));
		res = repository.firstLogin(no);
		
		bean = (Bean) res;
		System.out.println("Frame_Controller Group for Logged Member : "+bean.getGroupno());
		session.setAttribute("FirstGroup", bean.getGroupno());
				
		}catch(Exception e){}	
		
		//Userid group 
		Integer groupNo; 		
		System.out.println("Frame_Controller Service : "+service);
		System.out.println("Frme_Controller logged page : "+request.getParameter("logged"));
		System.out.println("Frame_Controller logged : "+logged);
		logged = Boolean.parseBoolean(request.getParameter("logged"));

		
		switch(service){
		case "title":
			try{
			if(logged == true){
			   groupNo = bean.getGroupno();
			}else{
			   groupNo=Integer.parseInt(request.getParameter("groupNo"));
			}
			res = repository.getTitles(groupNo);
			}catch(Exception e){}
			break;
			
		case "sub":
			 try{
			if(logged == true){
			  groupNo = bean.getGroupno();
			}else{
			  groupNo=Integer.parseInt(request.getParameter("groupNo"));
			}			 
			res = repository.getSubs(groupNo);
			 }catch(Exception e){}
			break;
		
		case "submenGroups" : 
			try{		
			res = repository.getGroups(no);
			}catch(Exception e){}
		break;	
		
		case "selectedGroup" :
			try{
			 if(logged == true){
			   groupNo = bean.getGroupno();
			 }else{
			   groupNo=Integer.parseInt(request.getParameter("groupNo"));
			 }			
			   res = repository.selectedGroup(groupNo);
			}catch(Exception e){}
		break;	
		}		
		return res;
	}
	
	@RequestMapping
	public String view(@PathVariable("sub") String sub, 
			           @PathVariable("service") String service){				
		return "/main/"+sub+"/"+service;
	}	
}
