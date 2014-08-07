package git.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.commons.codec.binary.Base64;
import org.javatuples.Triplet;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.JsonReadable;
import com.jcabi.github.Repo;
import com.jcabi.github.RepoCommit;
import com.jcabi.github.RtGithub;
import com.jcabi.github.Tree;
import com.jcabi.immutable.ArrayMap;

public class Test05_get_contents {
	public static void main(String[] args) throws IOException {


		Github github = new RtGithub("maverickjin8","snorlax1");

		/*
		System.out.println("===========================starting testrepo1===========================");
		
		
		
		//init process
//		String sha_of_main_tree = "5d0359b8a78bb2c7f37e8d52f86db5486f22d62c";//최근 바로 전 커밋 
		String sha_of_main_tree = "67bfe3413d9d6fc1968da8d671431439bc6efdaf";//가장 최근 커밋
		Repo repo = github.repos().get(
				new Coordinates.Simple("maverickjin8","testrepo1")
				);
		Tree main_tree = repo.git().trees().get(sha_of_main_tree);
		 
		
		
		System.out.println(">>>>section 1: simply print all (sha,path,type) blobs");
		recursive_print_contents_tree(main_tree, repo);
		
		
//		
//		System.out.println("\n\n"
//				+ ">>>> Section 2: put all Triplet (sha,path,type) inside arrayList THEN print all values from ArrayList ");
//		ArrayList<Triplet<String, String, String>> testrepo_fila_path_arrayList = new ArrayList<>();
//		recursive_insertToArrayList_tree(main_tree,repo, testrepo_fila_path_arrayList);
//		Object[] array_testrepo_fila_path = testrepo_fila_path_arrayList.toArray();
//		for(int i=0;i<array_testrepo_fila_path.length;i++){
//			System.out.println(array_testrepo_fila_path[i]);
//		}
		
		
		System.out.println("======================================the end===========================");
		*/
		

		System.out.println("===========================starting bit place===========================");

		
		//init process
//		String sha_of_main_tree_1 = "b08db3bcfcdb15d88f8960f4ed9c3f2498148a44";
		Repo repo1 = github.repos().get(
				new Coordinates.Simple("maverickjin8","Bit_Place")
				);
		String sha_of_main_tree_1 = getLatestCommitSha(repo1);
		Tree main_tree_1 =  repo1.git().trees().get(sha_of_main_tree_1);

		System.out.println(">>>>>>section 1: simply print all (sha,path,type) blobs");
		recursive_print_contents_tree(main_tree_1, repo1);
		
		System.out.println("\n\n"
				+ ">>>> Section 2: put all Triplet (sha,path,type) inside arrayList THEN print all values from ArrayList ");
		
		ArrayList<Triplet<String, String, String>> Bit_Place_fila_path_arrayList = new ArrayList<>();
		recursive_insertToArrayList_tree(main_tree_1,repo1, Bit_Place_fila_path_arrayList);
		Object[] array_Bit_Place_fila_path = Bit_Place_fila_path_arrayList.toArray();
		for(int i=0;i<array_Bit_Place_fila_path.length;i++){
			System.out.println(array_Bit_Place_fila_path[i]);
		}
		 
		System.out.println("======================================the end===========================");



	}
	
	public static String getLatestCommitSha(Repo repo){
		Iterator<RepoCommit> iterator =
				repo.commits().iterate(
						new ArrayMap<String, String>()
//						.with("since", "2014-01-26T00:00:00Z")
//						.with("until", "2014-10-27T00:00:00Z")
						).iterator();

		//commit sha값을 github 서버에서 받아서 sha_commits 라는 보관소
		if (iterator.hasNext()) {
			return iterator.next().sha();
		}
		return null;
	}

	public static void recursive_print_contents_tree(JsonReadable jsonReadable, Repo repo) throws IOException{
		Tree next_tree=null;
		JsonArray value = jsonReadable.json().getJsonArray("tree");
		int value_length = value.size();
		
		for(int i=0; i<value_length;i++){
			if(value.getJsonObject(i).getString("type").equals("tree")){
				next_tree=repo.git().trees().get(value.getJsonObject(i).getString("sha"));
				System.out.print("+");
				recursive_print_contents_tree(next_tree, repo);
			} else {
				
				byte[] encoded_Bytes = repo.git().blobs().get(value.getJsonObject(i).getString("sha")).json().getString("content").getBytes();
				byte[] decoded_Bytes = Base64.decodeBase64(encoded_Bytes);
				String decodedBytes_in_String = new String(decoded_Bytes);
				System.out.println("\n파일명: " +value.getJsonObject(i).getString("path")+" \n파일내용: " + decodedBytes_in_String);
//				
//				String base64_content = "MTEK7KCV7Jq07J206rCAIOyImOygle2VnCDthY3siqTtirgg7YyM7J287J6F\n64uI64ukLgo=\n";
//				byte[] encodedBytes = base64_content.getBytes();
//				byte[] decodedBytes = Base64.decodeBase64(base64_content);
//				
//				String decodedBytes_toString = new String(decodedBytes);
//				System.out.println("decodedBytes_toString: \n" + decodedBytes_toString);
//				
//				System.out.println("file sha: "+ value.getJsonObject(i).getString("sha"));
//				System.out.println("file path: "+ value.getJsonObject(i).getString("path"));
//				System.out.println("file type: "+ value.getJsonObject(i).getString("type"));
//				System.out.println("------------------------------------------------------");
			}
		}
		return;
	}

	public static void recursive_insertToArrayList_tree(JsonReadable jsonReadable, Repo repo, ArrayList<Triplet<String,String,String>> arrayList) throws IOException{
		Tree next_tree=null;
		JsonArray value = jsonReadable.json().getJsonArray("tree");
		JsonObject temp = null;
		Triplet<String,String,String> triplet=null;

		int value_length = value.size();
		for(int i=0; i<value_length;i++){

			temp = value.getJsonObject(i);
			if(temp.getString("type").equals("tree")){
				next_tree=repo.git().trees().get(temp.getString("sha"));
				recursive_insertToArrayList_tree(next_tree, repo,arrayList);
			} else {
				triplet = new Triplet<String,String,String>(temp.getString("sha"),temp.getString("path"),temp.getString("type"));
				arrayList.add(triplet);

				//				arrayList.add(temp.getString("sha"));
				//				arrayList.add(temp.getString("path"));
				//				arrayList.add(temp.getString("type"));
				//				System.out.println("------------------------------------------------------");
			}
			
		}
		return;
	}
}
