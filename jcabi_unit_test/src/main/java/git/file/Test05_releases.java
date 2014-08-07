package git.file;

import java.io.IOException;

import javax.json.Json;

import org.apache.commons.codec.binary.Base64;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class Test05_releases {


	public static void main(String[] args) throws IOException {
		Github github = new RtGithub("jungwoonshin","wjddns1025");
		Repo repo = github.repos().get(
				new Coordinates.Simple("jungwoonshin","bit2014")
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
		
		repo.releases().create("realeases1");
		System.out.println(3);
	}
}
