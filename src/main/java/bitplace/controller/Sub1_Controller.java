package bitplace.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bitplace.dao.Bit_Rep;

@Controller
@RequestMapping("ajax/{sub}/{service}")
public class Sub1_Controller{	
	  
	static Logger logger = Logger.getLogger(Sub1_Controller.class);
	
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
	public String view(@PathVariable("sub") String sub, @PathVariable("service") String service){	
		return "/main/"+sub+"/"+service;
	}	
}
