package bitplace.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bitplace.dao.Bit_Rep;
import bitplace.vo.Bean;

import com.jcabi.github.Commits;
import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RepoCommit;
import com.jcabi.github.RepoCommits;
import com.jcabi.github.RtGithub;
import com.jcabi.immutable.ArrayMap;

@Controller
@RequestMapping("ajax/groups/{service}")
public class Group_Controller{	
	  	
	@Autowired
	Bit_Rep repository;
	
	Github github;
	Repo repo;
	Bean bean;

	
	@ModelAttribute("ajax_data")
	public Object data(HttpServletRequest request, @PathVariable("service")String service){
		Object res = null;
		bean = new Bean();
			//sends group number to the body 			
			res = request.getParameter("groupNo");		
			
			switch(service){
			case "insertGroup" : 
				System.out.println("InsertGroup Activated");
				System.out.println(request.getParameter("groupname"));
				System.out.println(request.getParameter("code"));
				break;
			
			case "displayContent" :			
				bean.setGit_repository(request.getParameter("git_rep"));
				bean.setGit_id(request.getParameter("git_id"));
				bean.setGit_pwd(request.getParameter("git_pwd"));
				bean.setContentno(Integer.parseInt(request.getParameter("contentno")));
				
				github = new RtGithub(bean.getGit_id(),bean.getGit_pwd());				
				
				repo = github.repos().get(
						new Coordinates.Simple(bean.getGit_id(),bean.getGit_repository())
						);
				res = repository.getContent(bean.getContentno());
			break;
			
			case "content_commitinfo":
				RepoCommits commits = repo.commits();
				Iterator<RepoCommit> iterator = commits.iterate(new ArrayMap<String, String>()
						/*.with("since","2014-01-26T00:00:00Z")
						.with("until","2014-10-27T00:00:00Z")*/).iterator();
				ArrayList<String> shas_commits = new ArrayList<String>();
				
				while(iterator.hasNext()){
					shas_commits.add(iterator.next().sha());
				}
				JsonObject tree_of_commit=null;
				String sha_of_tree = null;
				
				ArrayList<String> shas_trees = new ArrayList<String>();
				Commits commits1 = repo.git().commits();
				for(String commit_string : shas_commits){
						try {
							tree_of_commit = commits1.get(commit_string).json().getJsonObject("tree");
							sha_of_tree  = tree_of_commit.getString("sha");
							shas_trees.add(sha_of_tree);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}	
				res = shas_trees;
			break;
			
			case "content_commitinfo_search1" :	
				ArrayList<Bean> list = new ArrayList<Bean>();
				Bean bean2;
			    try {
					JsonArray value = repo.git().trees().get(request.getParameter("sha")).json().getJsonArray("tree");
					JsonObject value_jsonObject = null;
					for(int i=0; i<value.size(); i++){
						bean2 = new Bean();
						value_jsonObject = value.getJsonObject(i);
						bean2.setPath(value_jsonObject.getString("path"));
						bean2.setSha(value_jsonObject.getString("sha"));
						bean2.setType(value_jsonObject.getString("type"));
						list.add(bean2);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res = list;
			break;
					
			case "content_commitinfo_contents" :
				String decoded_Bytes_inString = null;				
				try {
					byte[] encoded_Bytes = repo.git().blobs().get(request.getParameter("filesha")).json().getString("content").getBytes();
					byte[] decoded_Bytes = Base64.decodeBase64(encoded_Bytes);
					decoded_Bytes_inString = new String(decoded_Bytes);
				
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("content_commitinfo_contents : "+decoded_Bytes_inString);
				res = decoded_Bytes_inString;				
			break;
			
			case "content_commitinfo_folder" :
				String sha = request.getParameter("foldersha");
				JsonArray value=null;
				try {
					 value = repo.git().trees().get(sha).json().getJsonArray("tree");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ArrayList<Bean> array2 = new ArrayList<Bean>();
				Bean bean3;
				int length=value.size();
				for(int i=0;i<length;i++){
					bean3 = new Bean();
					bean3.setPath(value.getJsonObject(i).getString("path"));
					bean3.setSha(value.getJsonObject(i).getString("sha"));
					array2.add(bean3);
					
					System.out.println("content_commitinfo_folder : "+bean3.getPath());
				}
				res = array2;
			break;	
			
			case "displayContentByTitle" : 				
				res = repository.getContentfromOneTitle(Integer.parseInt(request.getParameter("titleno")));
			break;
			}
					
		return res;
	}
	
	@RequestMapping
	public String view(@PathVariable("service") String service){		
		
			return "/main/groups/"+service;
	}	
}
