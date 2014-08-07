package git.file;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.egit.github.core.Download;

import com.jcabi.github.Content;
import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class Test03_update_file {


	public static void main(String[] args) throws IOException {
		Github github = new RtGithub("jungwoonshin","*****");
		Repo repo = github.repos().get(
				new Coordinates.Simple("jungwoonshin","bit2014")
				);

		//get file 할떄는 반드시 ref 즉 branch써야함.default=master
		JsonObject content = repo.contents().get("/Users/jungwoonshin/git/testfile5.txt","origin").json();
		Content readme_content = repo.contents().readme();
		JsonObjectBuilder builder = Json.createObjectBuilder();

		// 리파지토리 안에 있는 리드미 파일 전체 프린트.
		//		System.out.println("==============>"Arrays.toString(readme_content.json().entrySet().toArray()));

//		// 리파지토리 안에 있는 리드미 파일의 sha값 가져오기
//		String sha_of_readme = (String) readme_content.json().getJsonString("sha").toString();
//		String sha_of_textfile5 = content.getString("sha");

//		System.out.println("=======> printing bit2014/readme's(origin):  sha value: " +sha_of_readme);
//		System.out.println("=======> printing bit2014/Users/jungwoonshin/git/testfile5.txt's(origin) sha value: "+sha_of_textfile5);

		//파일 업데이트하기:  반드시 그 파일 자체의 sha값을 가져와서 삭제해야함.
		//required parameter: path,message,sha, content
//		repo.contents().update("/adding_new_folder",
//				builder
//				.add("message", "update test message")
//				.add("sha", sha_of_textfile5)
//				.add("content", "bXkgdXBkYXRlZCBmaWxlIGNvbnRlbnRz").build());

		JsonObject getFileContent = repo.contents().get("/Users/jungwoonshin/git/testfile5.txt","origin").json();
		String base64_content = getFileContent.getString("content");
		

//		byte[] encodedBytes = Base64.encodeBase64("creating file at desired destination".getBytes());
//		byte[] encodedBytes_korean = Base64.encodeBase64("한글폴더".getBytes());
		byte[] decodedBytes = Base64.decodeBase64(base64_content);
		System.out.println(decodedBytes.toString());
		
		
		
		
		

	}
}
