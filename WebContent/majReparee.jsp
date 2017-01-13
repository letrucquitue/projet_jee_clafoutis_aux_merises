<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Date,org.tutorial.Panne,org.tutorial.Machine"%>
<%String m_id = (String)request.getAttribute("m_id");%>
<%String type = (String)request.getAttribute("type");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="refresh" content="2; url=MainServlet" />
	<title>Panne réparée</title>
</head>
<body>
	<h1>Panne réparée</h1>
	<p>Machine: <%=m_id %></p>
	<p>Type: <%=type %></p>
</body>
</html>