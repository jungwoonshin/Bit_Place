<%@page import="javax.json.JsonArray"%>
<%@page import="com.shin.vo.Content"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
/* Content selectedContent = (Content)request.getAttribute("selectedContent"); */
JsonArray tree_jsonArray =(JsonArray) request.getAttribute("tree_jsonArray");
%>
<%-- <%="====================selectedContent=========================" %>
<%=new Gson().toJson(selectedContent)%> --%>
<%=new Gson().toJson(tree_jsonArray)%>