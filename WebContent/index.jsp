<%@ page import="br.edu.ifpr.entities.Task" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1"/>
		
		<title>Lista de Tarefas</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
		
		<style>
			* {
				margin: 0;
				padding: 0;
				outline: 0;
				box-sizing: border-box;
			}
			
			html, body {
				background: #eee;
			}
			
			.form-tasks {
				display: flex;
				align-items: center;
				justify-content: space-between;
			}
		
			.container .form-tasks .input-title {
				width: 35%;
			}
			
			.container .form-tasks .input-description {
				width: 50%;
			}
			
			.table, .table td {
				border: 1px solid #aaa;
			}
			
			.table .table-status {
				color: #c0392b;
			}
		</style>
	</head>
	
	<body>
		<%
			List<Task> listTasks = new ArrayList<Task>();
		
			if(request.getAttribute("taskList") != null) {
			  listTasks = (List<Task>) request.getAttribute("taskList");
			}
		
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		%>
		
		<div class="container mt-3">
			<h2>Lista de Tarefas</h2>
			
			<form action="/app/tasks/new" method="post" class="form-inline mt-4 mb-4 form-tasks">
				<input 
					class="form-control mb-2 mr-sm-2 input-title" 
					type="text" 
					name="taskTitle"
					placeholder="Título"
					autoFocus
					required
				/>
				
				<input 
					class="form-control mb-2 mr-sm-2 input-description" 
					type="text" 
					name="taskDescription"
					placeholder="Descrição"
				/>
				
				<button type="submit" class="btn btn-primary mb-2">
					+ Nova Tarefa
				</button>
			</form>
			
			<table class="table table-bordered table-hover">
				<thead class="thead-dark">
					<tr>
						<th>#</th>
						<th>Título</th>
						<th>Descrição</th>
						<th>Data de Inclusão</th>
						<th>Status</th>
					</tr>
				</thead>
				
				<tbody>
				<% for(Task task : listTasks) { %>				
					<tr>
						<td>
							<%= task.getId() %>
						</td>
						
						<td>
							<%= task.getTitle() %>
						</td>
						
						<td>
							<%= task.getDescription() %>
						</td>
						
						<td>
							<%= formatter.format(task.getCreatedAt()) %>
						</td>
						
						<td>
							<i>
								<strong class="table-status"><%= task.getStatus().getStatusName() %></strong>
							</i>
						</td>																								
					</tr>
				<% } %>					
				</tbody>
			</table>
		</div>
	</body>
</html>