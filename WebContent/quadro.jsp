<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="apptarefa.model.TarefaBeans, java.util.List"%>

<%
List<TarefaBeans> lista = (List<TarefaBeans>) request.getAttribute("tarefas");
%>
<!DOCTYPE html>
<html lang="bt-br">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
<meta charset="ISO-8859-1">
<title>Tarefas</title>
</head>
<body>
	<h2>Tarefas</h2>
	<button class="btn">
		<a href="formNovaTarefa.html">+ Nova</a>
	</button>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Descricao</th>
				<th>Status</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getDescricao()%></td>
				<td><%=lista.get(i).getStatus()%></td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>


</body>
</html>