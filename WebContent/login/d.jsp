<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Object name = session.getAttribute("user");
		System.out.println(name);
		if(name == null){
			response.sendRedirect("login.jsp");
			
			
		}
	
	%>

	<h4>DDD page</h4>
	<a href="list.jsp">Return</a>
</body>
</html>