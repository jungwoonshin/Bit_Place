<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Git World</title>
</head>
<body>
	Classes that a user is in
	<c:forEach var="className" items="${classNames}">
		${className.groupname} <br>
	</c:forEach>
	<br>
	<br>

	Contents that selected class has
	<c:forEach var="contentInClass" items="${contentInClass}">
	${contentInClass.git_id}	<br>
	${contentInClass.git_repository} <br>	
	${contentInClass.content_title}	 <br>
	${contentInClass.content}	<br>
	</c:forEach>














</body>
</html>