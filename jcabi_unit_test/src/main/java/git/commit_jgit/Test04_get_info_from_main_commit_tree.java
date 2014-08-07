package git.commit_jgit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.JsonArray;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Git;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RepoCommit;
import com.jcabi.github.RepoCommits;
import com.jcabi.github.RtGithub;
import com.jcabi.immutable.ArrayMap;

public class Test04_get_info_from_main_commit_tree {
public static void main(String[] args) throws IOException {
	Github github = new RtGithub("maverickjin8","snorlax1");

	Repo repo = github.repos().get(
			new Coordinates.Simple("maverickjin8","testrepo1")
			);


	//		get all commit objects
	RepoCommits commits = repo.commits();

	final Iterator<RepoCommit> iterator =
			commits.iterate(
					new ArrayMap<String, String>()
//					.with("since", "2014-01-26T00:00:00Z")
//					.with("until", "2014-10-27T00:00:00Z")
					).iterator();

	//모든 커밋의 sha값을 저장하기 위한 보관소 
	ArrayList<String> shas_commits = new ArrayList<>();

	//모든 커밋이 가르키는 각각의 트리의 sha값을 저장하기 위한 보관소.
	ArrayList<String> shas_tree_commits = new ArrayList<>();


	//commit sha값을 github 서버에서 받아서 sha_commits 라는 보관소
	String sha_commmit_temp = null;
	while (iterator.hasNext()) {
		sha_commmit_temp = iterator.next().sha();
//		System.out.println("sha_commmit_temp: " + sha_commmit_temp);
		shas_commits.add(sha_commmit_temp);
	}
	
	
	String sha_tree_commits=null;
	for(String commit_sha: shas_commits){
		System.out.println(" ====================Starting a new commit ====================");
		sha_tree_commits = repo.git().commits().get(commit_sha).json().getJsonObject("tree").getString("sha");
		shas_tree_commits.add(sha_tree_commits);
	
		System.out.println("sha_tree_commits: " + sha_tree_commits);
		
		JsonArray value = repo.git().trees().get(sha_tree_commits).json().getJsonArray("tree");

		for(int i=0; i<value.size();i++){
			System.out.println("printing files path: " + value.getJsonObject(i).getString("path"));
			System.out.println("printing files sha: " + value.getJsonObject(i).getString("sha"));
		}
		System.out.println("================================================================");
	}
}
}
