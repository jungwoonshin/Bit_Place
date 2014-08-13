<%@page import="com.shin.vo.Content"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
List<Content> repositories = (List<Content>)request.getAttribute("contentInClass");
%>


<%=new Gson().toJson(repositories)%>
