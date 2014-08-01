package bitplace.controller.json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{sub}/{service}")
public class Frame_Controller{	
	  	
	@RequestMapping()
	public String view(){	
		return "/main/frame";
	}	
}
