<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Date,org.tutorial.Panne,org.tutorial.Machine"%>
<%int[] tabPanne = (int[])request.getAttribute("tabPanne");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monitoring console</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
  function majTabDetail(type_t)
  {
  	$("#tabDetails").load("details.jsp?type_t="+type_t);
  	console.log("maj_detail type_t: "+type_t);
  }
</script>

</head>
<body>
	<a href="PanneServlet">Création de pannes</a>
	<h1 align="center">Liste des pannes du data center</h1>
	
	<h2>Nombre de pannes apparues dans la ...</h2>
	<table border="1">
	<tr>
		<th>Dernière minute</th>
		<th>Dernière heure</th>
		<th>Dernier jour</th>
		<th>Dernier mois</th>
	</tr>
	<tr>
		<td><%=tabPanne[0]%></td>
		<td><%=tabPanne[1]%></td>
		<td><%=tabPanne[2]%></td>
		<td><%=tabPanne[3]%></td>
	</tr>
	<tr>
		<td><a href='javascript:void(0)' onClick=majTabDetail(this.id) id="minute">Détails...</a></td>
		<td><a href='javascript:void(0)' onClick=majTabDetail(this.id) id="heure">Détails...</a></td>
		<td><a href='javascript:void(0)' onClick=majTabDetail(this.id) id="jour">Détails...</a></td>
		<td><a href='javascript:void(0)' onClick=majTabDetail(this.id) id="mois">Détails...</a></td>
	</tr>
	</table>
	
	<br>
	<input type="button" value="Recharger les données" onClick="javascript:window.location.reload()">
	
	<p id="tabDetails"></p>
	
</body>
</html>