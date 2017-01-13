<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Date,org.tutorial.Panne,org.tutorial.Machine,org.tutorial.PanneServiceImpl,org.tutorial.PanneService"%>
<%
PanneService panneService = new PanneServiceImpl();
String type_req=request.getParameter("type_t");
List<Panne> listePannes = panneService.getPannesByTime(type_req);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h2>Détails 
<%if(type_req.equals("minute")){%>
de la dernière minute
<%} else if(type_req.equals("heure")){%>
de la dernière heure
<%} else if(type_req.equals("jour")){%>
du dernier jour
<%} else if(type_req.equals("mois")){%>
du dernier mois
<%} %>
</h2>
<%if(listePannes.isEmpty() || listePannes == null) {%>
<h3>Aucune panne trouvée</h3>
<%} else {%>

<p>Trier par:</p>
<div>
Type machine:
	<select name = "type" id="select_type">
		<option value="none" selected>Aucun tri</option>
		<option value="Serveur">Serveur</option>
		<option value="Routeur">Routeur</option>
		<option value="Pare-feu">Pare-feu</option>
	</select>
</div>
<table border="1">
		<tr>
			<th>Date</th>
			<th>Heure</th>
			<th>Type</th>
			<th>Machine concernée</th>
			<th>Type Machine</th>
			<th>Réparée?</th>
		</tr>
		<%for(Panne p:listePannes) {
			Date d = p.getDate();
			String[] t_d = d.toString().split(" ");
			String date = t_d[0];
			String heure = t_d[1].substring(0,5);
			String type = p.getType();
			String m = p.getMachine().getNom();
			String t_m = p.getMachine().getType();
			boolean rep = p.isReparee();
			%>
			<tr>
				<td><%=date%></td>
				<td align="center"><%=heure%></td>
				<td><%=type%></td>
				<td><%=m%></td>
				<td><%=t_m%></td>
				
				
				<td>
					<form action="MajRepareeServlet" method="post" >
						<%if(!rep){%>
						<INPUT type="checkbox" name="reparee" disabled>
						<%} else {%>
						<INPUT type="checkbox" name="reparee" checked disabled>
						<%} %>
						<input type="hidden" value="<%=m%>" name="machine">
						<input type="hidden" value="<%=type%>" name="type">
						<input type="submit" value="Réparer">
					</form>
				</td>
			</tr>
		<%}%>
	</table>
	
<%} %>

</body>