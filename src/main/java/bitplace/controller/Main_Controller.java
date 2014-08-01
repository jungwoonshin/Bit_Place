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
public class Main_Controller{	
	  
	static Logger logger = Logger.getLogger(Main_Controller.class);
	
	@Autowired
	Bit_Rep repository;
	
	@ModelAttribute("data")
	public Object data(@PathVariable("service")String service,
				       @PathVariable("sub")String sub,
					   HttpServletRequest request,
					   HttpSession session){
		
		Object res = null;
		Integer no = 1;
			
		switch(service){
		case "top" : 
			try{
		    res = repository.getGroups(no);
			}catch(Exception e){}			
			break;
			
		case "title":
			Integer groupNo = 1;
			try{
			res = repository.getTitles(groupNo);
			}catch(Exception e){}
			break;
			
		case "sub":
			 groupNo = 1; 
			 try{
			 res = repository.getSubs(groupNo);
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
