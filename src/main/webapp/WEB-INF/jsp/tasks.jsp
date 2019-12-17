<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %> 
    <%@ page import="javax.servlet.*,java.text.*" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Manager | Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/loginHome" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">New Task</a></li>
					<li><a href="all-tasks">All Tasks</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Task Manager</h1>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Tasks</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Task</th>
								<th>Date</th>
								<th>Completed</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td>${task.task}</td>
								
									<td><fmt:formatDate value="${task.dt}" type="date" pattern="MM/dd/yyyy"/>									</td>
									<td>${task.finished}</td>
									<td><a href="update-task?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-task?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Task</h3><br>
				<form method="post" action="save-task">
							<input type="hidden" name="id" value="${taskObj.id}"/>
		<%-- 					<div class="form-group">
								<label class="control-label col-md-3">Name</label>
							  <div class="col-md-7">
		 							<input type="hidden" class="form-control" name="name" value="${sessionScope.username}"/>
		 						</div>				
							</div> --%>
							
							<div class="form-group">
								<label class="control-label col-md-3">Task</label>
								<div class="col-md-7">
									<input type="text" class="form-control" name="task" value="${taskObj.task}"/>
								</div>				
							</div>
							
								<div class="form-group">
								<label class="control-label col-md-34">Date</label>
								<div class="div-dt">
								   	<input type="text" class="form-control"  name="dt" value="${parsedTaskDate}" />
								</div>				
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-3">Completed</label>
								<div class="col-md-7">
									<input type="radio" class="col-sm-1" name="finished" value="true"/>
									<div class="col-sm-1">Yes</div>
								 	<input type="radio" class="col-sm-1" name="finished" value="false" checked/>
									<div class="col-sm-1">No</div>
								</div>				
							</div>		
							<div class="form-group">
								<input type="submit" class="btn btn-primary" value="Save"/>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				</form>
			</div>
		</c:when>		
		</c:choose>
		
</body>
</html>