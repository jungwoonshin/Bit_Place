package git.pull;

import java.io.IOException;
import java.util.Collection;

import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;

import org.apache.commons.codec.binary.Base64;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Issue;
import com.jcabi.github.Pull;
import com.jcabi.github.Pulls;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class Test01_pull {

	public static void main(String[] args) throws IOException {
		Github github = new RtGithub("jungwoonshin","**");
		Repo repo = github.repos().get(
				new Coordinates.Simple("jungwoonshin","pull_test")
				);

		byte[] encodedBytes = Base64.encodeBase64("creating file at desired destination".getBytes());
		byte[] encodedBytes_korean = Base64.encodeBase64("한글폴더".getBytes());
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);

		//		repo.contents().create(Json.createObjectBuilder()
		//				.add("path","/create_folder2")
		//				.add("message","successfully created folder")
		//				.add("content",new String(encodedBytes))
		//				.build());

		//		repo.contents().create(Json.createObjectBuilder()
		//				.add("path","/folder2/folder3")
		//				.add("message","successfully korean created folder")
		//				.add("content",new String(encodedBytes_korean))
		//				.build());

		//		repo.releases().create("realeases");
		//		System.out.println(3);

		Pulls pulls = repo.pulls();
		Pull pull = repo.pulls().create("hello", "", "");
		Issue.Smart issue = new Issue.Smart(repo.issues().get(pull.number()));
		
		
		JsonObject issue_json = issue.json();
		JsonString url = issue_json.getJsonString("url");
		System.out.println(url.toString());
//		JsonObject pull_json = pull.json();
		
		
		
//		System.out.println(pull_json.getString("master"));
		System.out.println(3);







	}
}
