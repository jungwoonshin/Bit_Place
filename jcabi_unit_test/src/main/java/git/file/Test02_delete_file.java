package git.file;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.apache.commons.lang3.RandomStringUtils;

import com.jcabi.github.Content;
import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class Test02_delete_file{
	//	static Logger logger;


	public static void main(String[] args) throws Exception {
		Github github = new RtGithub("jungwoonshin","******");
		Repo repo = github.repos().get(
				new Coordinates.Simple("jungwoonshin","bit2014")
				);

		//get file 할떄는 반드시 ref 즉 branch써야함.default=master
		JsonObject content = repo.contents().get("/Users/jungwoonshin/git/testfile5.txt","origin").json();
		Content readme_content = repo.contents().readme();
		JsonObjectBuilder builder = Json.createObjectBuilder();

		// 리파지토리 안에 있는 리드미 파일 전체 프린트.
		//		System.out.println("==============>"Arrays.toString(readme_content.json().entrySet().toArray()));

		// 리파지토리 안에 있는 리드미 파일의 sha값 가져오기
		String sha_of_readme = (String) readme_content.json().getJsonString("sha").toString();
		String sha_of_textfile5 = content.getString("sha");
		
		System.out.println("=======> printing readme's sha value: " +sha_of_readme);
		System.out.println("=======> printing textfile5.txt's(origin) sha value: "+sha_of_textfile5);

		
		System.out.println("=================================================================================");
		
		//파일 삭제하기 반드시 그 파일 자체의 sha값을 가져와서 삭제해야함.
		repo.contents().remove(builder.add("message", "message")
				.add("path", "/Users/jungwoonshin/git/testfile5.txt")
				.add("sha", "574ca05b4d37a2862e65f82b4a16e24746c33f8b").build());
	}


    /**
     * Generate a random fake SHA hex string.
     *
     * @return Fake SHA string.
     */
    private static String fakeSha() {
        // @checkstyle MagicNumberCheck (1 line)
        return RandomStringUtils.random(40, "0123456789abcdef");
    }
}