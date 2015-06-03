<%@page import="javax.json.JsonArray"%>
<%@page import="com.shin.vo.Content"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
JsonArray tree_sha_jsonArray =(JsonArray) request.getAttribute("tree_sha_jsonArray");
%>
<%=new Gson().toJson(tree_sha_jsonArray)%>