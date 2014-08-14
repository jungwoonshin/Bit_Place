package com.shin.github;

import java.io.IOException;
import java.util.Iterator;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RepoCommit;
import com.jcabi.github.RepoCommits;
import com.jcabi.github.RtGithub;
import com.jcabi.github.Tree;
import com.jcabi.http.response.JsonResponse;
import com.jcabi.immutable.ArrayMap;

public class MyGit {

	private String user="";
	private String repo_name ="";


	public MyGit(){

	}

	public MyGit(String user, String repo_name) {
		super();
		this.user = user;
		this.repo_name = repo_name;
	}

	@Override
	public String toString() {
		return "MyGit [user=" + user + ", repo_name=" + repo_name + "]";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRepo_name() {
		return repo_name;
	}

	public void setRepo_name(String repo_name) {
		this.repo_name = repo_name;
	}

	public String[] getUserRepositoryArray(String user) throws IOException{
		String[] repositoryNames=null;
		final JsonResponse resp = new RtGithub().entry()
				.uri().path("/users/"+user+"/repos")
				.back()
				.fetch()
				.as(JsonResponse.class);
		JsonArray value= resp.json().readArray();
		/*.getValuesAs(JsonArray.class);*/

		int length = value.size();
		repositoryNames = new String[length];
		for(int i=0;i<length;i++){
			repositoryNames[i] =  value.getJsonObject(i).getString("name");
		}
		return repositoryNames;
	}

	public String getLatestShaTreeCommitFast(String user, String repo_name) throws Exception{
		String treeSha = new RtGithub().entry()
				.uri().path("/repos/"+user+"/" + repo_name +"/commits")
				.back()
				.fetch()
				.as(JsonResponse.class).json().readArray().getJsonObject(0).getJsonObject("commit").getJsonObject("tree").getString("sha");
		if(treeSha!=null)
			return treeSha;
		return null;
	}
	
	
	
	
	
	public String getLatestShaTreeComit(String user, String repo_name) throws Exception{
		
		Repo repo = new RtGithub().repos().get(
				new Coordinates.Simple(user,repo_name)
				);

		RepoCommits commits = repo.commits();
		final Iterator<RepoCommit> iterator =
				commits.iterate(
						new ArrayMap<String, String>()
						).iterator();
		String commit_sha=null;
		if (iterator.hasNext()) {
			commit_sha = iterator.next().sha();
		} else {
			return null;
		}

		return repo.git().commits().get(commit_sha).json().getJsonObject("tree").getString("sha");
	}

	public void recursive_print_tree(String sha_of_main_tree, String username, String password, String repo_name) throws IOException{
		Github github = new RtGithub(username,password);
		Repo repo = github.repos().get(
				new Coordinates.Simple(username,repo_name)
				);
		Tree next_tree=repo.git().trees().get(sha_of_main_tree);
		JsonArray value = next_tree.json().getJsonArray("tree");
		int value_length = value.size();
		for(int i=0; i<value_length;i++){
			if(value.getJsonObject(i).getString("type").equals("tree")){
//				next_tree=repo.git().trees().get(value.getJsonObject(i).getString("sha"));
				System.out.print("+");
				recursive_print_tree(value.getJsonObject(i).getString("sha"), username, password, repo_name);
			} else {
				System.out.println("file sha: "+ value.getJsonObject(i).getString("sha"));
				System.out.println("file path: "+ value.getJsonObject(i).getString("path"));
				System.out.println("file type: "+ value.getJsonObject(i).getString("type"));
				System.out.println("------------------------------------------------------");
			}
		}
		return;
	}
	
	public String getFileInfoStringFromTree(String content, String sha_of_main_tree, String username, String password, String repo_name) throws IOException{
		Github github = new RtGithub(username,password);
		Repo repo = github.repos().get(
				new Coordinates.Simple(username,repo_name)
				);
		Tree next_tree=repo.git().trees().get(sha_of_main_tree);
		JsonArray value = next_tree.json().getJsonArray("tree");
		int value_length = value.size();
		for(int i=0; i<value_length;i++){
			if(value.getJsonObject(i).getString("type").equals("tree")){
//				next_tree=repo.git().trees().get(value.getJsonObject(i).getString("sha"));
//				System.out.print("+");
				return getFileInfoStringFromTree(content, value.getJsonObject(i).getString("sha"), username, password, repo_name);

			} else {
				
				content+="\nfile sha: " + value.getJsonObject(i).getString("sha");
				content+="\nfile sha: " + value.getJsonObject(i).getString("path");
				content+="\nfile sha: " + value.getJsonObject(i).getString("type");
				content+="\n=====================================================";
			}
		}
		return content;
	}
	
	public static JsonArray getMainTree(String username, String reponame){
		Github github = new RtGithub();
		Repo repo = github.repos().get(
				new Coordinates.Simple(username,reponame)
		);
		RepoCommits commits = repo.commits();
		final Iterator<RepoCommit> iterator =
				commits.iterate(
						new ArrayMap<String, String>()
						).iterator();
		String commit_sha=null;
		if (iterator.hasNext()) {
			commit_sha=iterator.next().sha();
		}
		String sha_tree=null;
		JsonArray jsonArrayTree =null;
		try {
			sha_tree= repo.git().commits().get(commit_sha).json().getJsonObject("tree").getString("sha");
			jsonArrayTree= repo.git().trees().get(sha_tree).json().getJsonArray("tree");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArrayTree;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		
		MyGit m = new MyGit();
		
		String tree_Sha = "b150e841ab9c78c5340c1fd379f5a96cbadc29b7";
		String username = "jungwoonshin";
		String password = "wjddns1025";
		String repo_name = "testrepo1";

		
		long startTime = System.currentTimeMillis();
//		System.out.println(m.getLatestShaTreeComit(username, repo_name));
		System.out.println(m.getLatestShaTreeCommitFast(username, repo_name));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
//		m.recursive_print_tree(tree_Sha, username,password,repo_name);
		String content = "";
//		content = m.getFileInfoStringFromTree(content,"c075237fab3d4d2a59502a046ec90e16877401a6", "maverickjin8","snorlax1","testrepo1");
		System.out.println(content);
		
	}

}
