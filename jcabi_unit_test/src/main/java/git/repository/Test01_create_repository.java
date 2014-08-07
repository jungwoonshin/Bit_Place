//package git.repository;
//
//import org.eclipse.egit.github.core.service.RepositoryService;
//
//import com.jcabi.github.Github;
//import com.jcabi.github.RtGithub;
//
//public class Test01_create_repository{
//	//	static Logger logger;
//	static String user = "jungwoonshin";
//	static String password = "****";
//
//
//	public static void main(String[] args) throws Exception {
//		Github github = new RtGithub(user,password);
//		//		Repo repo = github.repos().create(Json.createObjectBuilder()
//		//		.add("name", "shinjungwoon3")
//		//		.add("auto_init",true)
//		//		.build());
//
//		
//		//get all info about repositories
//		RepositoryService service = new RepositoryService();
//		for(org.eclipse.egit.github.core.Repository repo : service.getRepositories(user)){
//			System.out.println("test : "+repo.getName()+" "+repo.getUrl());
//		}   
//
////		Repo repo = github.repos().get(
////				new Coordinates.Simple("jungwoonshin","bit2014")
////				);
////		repo.contents().create(Json.createObjectBuilder()
////				.add("path","/Users/jungwoonshin/git/testfile5.txt")
////				.add("message","sss")
////				.add("content","213213123123")
////				.build());
//		//		Issue issue = repo.issues().create("How are you2?", "Please tell me...");
//		//	    issue.comments().post("My first comment!");
//
//
//
//
//	}
//
//
//
//}