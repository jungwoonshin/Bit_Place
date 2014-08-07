package git.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.commons.codec.binary.Base64;

import sun.awt.image.ByteArrayImageSource;

public class Test04_create_base64 {


	public static void main(String[] args) throws IOException {
//		Github github = new RtGithub("jungwoonshin","*****");
//		Repo repo = github.repos().get(
//				new Coordinates.Simple("jungwoonshin","bit2014")
//				);
////
//		byte[] encodedBytes = Base64.encodeBase64("creating file at desired destination".getBytes());
//		byte[] encodedBytes_korean = Base64.encodeBase64("한글폴더".getBytes());
//		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
//		byte[] decodedBytes_korean = Base64.encodeBase64(encodedBytes_korean);
//		
//		
//		System.out.println("decodedBytes_korean: " + Arrays.toString(decodedBytes_korean));
//		System.out.println("decodedBytes: " + Arrays.toString(decodedBytes));

//		
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
		
		String base64_content = "MTEK7KCV7Jq07J206rCAIOyImOygle2VnCDthY3siqTtirgg7YyM7J287J6F\n64uI64ukLgo=\n";
		byte[] encodedBytes = base64_content.getBytes();
		byte[] decodedBytes = Base64.decodeBase64(base64_content);
		
		String decodedBytes_toString = new String(decodedBytes);
		System.out.println("decodedBytes_toString: \n" + decodedBytes_toString);
		
//		String decodedBytes_string = Arrays.toString(decodedBytes);
//		System.out.println(decodedBytes_string);
	}
}
