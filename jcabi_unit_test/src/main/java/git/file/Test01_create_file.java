package git.file;

import javax.json.Json;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class Test01_create_file{
//	static Logger logger;


	public static void main(String[] args) throws Exception {
		Github github = new RtGithub("jungwoonshin","*****");
//		Repo repo = github.repos().create(Json.createObjectBuilder()
//		.add("name", "shinjungwoon3")
//		.add("auto_init",true)
//		.build());
		
		
		Repo repo = github.repos().get(
		        new Coordinates.Simple("jungwoonshin","bit2014")
		    );
		repo.contents().create(Json.createObjectBuilder()
				.add("path","/Users/jungwoonshin/git/testfile8.txt")
				.add("message","sss")
				.add("content","bXkgdXBkYXRlZCBmaWxlIGNvbnRlbnRz") //this is a encoded string using base64
				.build());
//		Issue issue = repo.issues().create("How are you2?", "Please tell me...");
//	    issue.comments().post("My first comment!");

		
		

	}



}