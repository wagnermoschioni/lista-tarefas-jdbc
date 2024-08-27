<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="apptarefa.model.TarefaBeans, java.util.List"%>

<%
TarefaBeans tarefa = (TarefaBeans) request.getAttribute("tarefa");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Tarefa</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>Alteração</h2>

	<form class="formulario" action="alterar" name="frmContato">
		<input type="hidden" name="id" id="data" value="<%=tarefa.getId()%>"  />
		Descrição: <input type="text" name="descricao" id="desc" value="<%=tarefa.getDescricao() %>"/>
		 <input type="hidden" name="data" id="data"  />
		 <h3 hidden>Status:</h3> 
		 <!-- 
		 <input
			type="text" name="status" id="status" />
			 -->			 
			<select name="status">
			<option value="" selected disabled><%=tarefa.getStatus()%></option>
			<option value="A iniciar">A iniciar</option>
			<option value="Em andamento">Em andamento</option>
			<option value="ConcluÃ­do">Concluído</option>
		    </select>			
			 <input type="hidden" name="status_hidden" id="status_hidden" value="A iniciar">
			 <input class="btn"
			type="submit" value="Confirmar" /> 
			
						
			
		<script type="text/javascript" src="js/validador.js"></script>
	</form>
</body>
</html>