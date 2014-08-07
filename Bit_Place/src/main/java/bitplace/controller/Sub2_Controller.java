package bitplace.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bitplace.dao.Bit_Rep;

@Controller
@RequestMapping("ajax/sub2/{service}")
public class Sub2_Controller{	
	  
	static Logger logger = Logger.getLogger(Sub2_Controller.class);
	
	@Autowired
	Bit_Rep repository;
	
	@ModelAttribute("ajax_data")
	public Object data(@PathVariable("service")String service){
		
		Object res = null;
		switch(service){
		case "sub1" : 
			try{
			    res = repository.getGroups(1);
				}catch(Exception e){}			
				break;
				
		case "sub2" : 
		break;
		
		case "sub3" : 
		break;
		}	
		return res;
	}
	
	@RequestMapping()
	public String view(@PathVariable("service") String service){		
			return "/main/sub2/"+service;
	}	
}
