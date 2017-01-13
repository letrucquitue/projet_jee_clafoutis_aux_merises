<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Date,org.tutorial.Panne,org.tutorial.Machine"%>
<%List<Machine> listeMachine = (List<Machine>)request.getAttribute("listeMachine");
String m_id;
String type_m;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création Pannes</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
  function majTabType()
  {
  	//essai de modification de la liste de type
  	//selon le type de la machine sélectionnée
  	/*console.log("majTabType");
  	$('#select_type')
    .empty()
    .append('<option selected="selected" value="Reseau">Reseau</option>');*/
;
  }
</script>

</head>
<body>
	<a href="MainServlet">Console de monitoring</a>
	
	<h1>Création de panne</h1>
	
	<form action="NewPanneServlet" method = post>
		<select name="machine" onchange="majTabType();" id="select_machine">
			<%
			for (Machine m:listeMachine)
			{
				m_id = m.getNom();
				type_m = m.getType();
				%>
				<option><%=m_id %></option>
			<%
			}
			%>
				
		</select>
		
		<select name = "type" id="select_type">
			<option>Reseau</option>
			<option>Crash disque</option>
			<option>Probleme memoire</option>
		</select>
		
		<br>
<!-- 		<input type="date" name="date"> Date de la panne (aaaa-mm-jj)</input><br> -->
<!-- 		<input type= "time" name = "heure"> Heure de la panne ()</input><br> -->
		<br>
		<button type = "submit">Valider</button>
	</form>
	
	<br>
	<form action="NewPanneAleatoireServlet" method = post>
		<button type = "submit">Aléatoire</button>
	</form>

</body>
</html>