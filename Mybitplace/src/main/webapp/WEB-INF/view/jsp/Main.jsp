
<%@page import="com.shin.github.MyGit"%>
<%@page import="com.jcabi.immutable.ArrayMap"%>
<%@page import="com.jcabi.github.RepoCommit"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.jcabi.github.RepoCommits"%>
<%@page import="com.jcabi.github.Coordinates"%>
<%@page import="com.jcabi.github.Repo"%>
<%@page import="com.jcabi.github.Github"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.json.JsonArray"%>
<%@page import="com.jcabi.github.RtGithub"%>
<%@page import="com.jcabi.http.response.JsonResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String username = "";
	String all_repositories = "";
	
	String repositoryUsername="";
	String repositoryName = "";
	
	String latest_sha_commit_tree = "";
	
	
 
	
	MyGit jcabiMethods = new MyGit();
	if (request.getParameter("username") != null) {
		username = request.getParameter("username");
		all_repositories = Arrays.toString(jcabiMethods.getUserRepositoryArray(username));
	} 
	
	if(request.getParameter("repositoryName")!=null && request.getParameter("repositoryUsername")!=null){
		latest_sha_commit_tree = jcabiMethods.getLatestShaTreeComit(request.getParameter("repositoryUsername"),request.getParameter("repositoryName"));
	}
	
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Git World</title>
</head>
<body>


	<h1>Get All Repositories</h1>


	<form action="Main.jsp" method="get">
		username:<br>
		<input type="text" name="username" size="10" value="<%=username%>"> <br>
		<input type="submit" value="Get all Repositories">  <br>
	</form>
	<br>
	all_repositories:<br>
	<%=all_repositories%>
	
	<h2>Get Sha value of (Tree<-Latest commit)</h2>
	
	<form action="Main.jsp" method="get">
		repository username:<input type="text" name="repositoryUsername" size="10" value="<%=repositoryUsername%>"> <br>
		repository name:<input type="text" name="repositoryName" size="10" value="<%=repositoryName%>"> <br>
		<input type="submit" value="Get the sha value of tree that is pointed by latest commit  ">  <br>
	</form>
	latest_sha_commit_tree:<br>
	<%=latest_sha_commit_tree%>
	
	 --%>
	 
	 












</body>
</html>