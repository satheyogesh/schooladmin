<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>  
  </script>
  


</head>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .footer {
  position: relative;
  /*bottom: 0; */
  /*width: 100%; */
  /* Set the fixed height of the footer here */
  height: 250px;
  margin-top:-200px;
  background-color:#D4DCDF;
  clear: both;
}

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 5px;
      }
      .row.content {height:auto;} 
    }
  </style>
  <style>
th, td {
    padding: 15px;
    text-align: left;    
}



</style>
</head>
<body>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
       <ul class="nav navbar-nav">
        <li class="active"><a href="/loginHome">Home</a></li>
        
      </ul>
      
      
      
    </div>
    
    
  </div>
</nav>
		<div class="container text-center">
		  <h2>Drug Details</h2>
		<hr size="3">		
		<form action="/savedrug" method="post" onreadystatechange="selectItemByValue()">

			<table >
				<tr>
					<div class="col-xs-3">
					<td><b><label>Drug Id: </label></b></td>
					<td><b>${drugobj.drugid}</b></td>
					<td><b><label>Dosage : </label></b></td>
					<td><input  value="${drugobj.dosage}"></input></td>
					</div>
				</tr>
				<tr>
					<div class="col-xs-3">
					<td><b><label>Drug Name: </label></b></td>
					<td><b><input  value="${drugobj.drugName}"></input></b></td>
					<td><b><label>Package :</label></b></td>
					<td><input  value=""></input></td>
					</div>
				</tr>
				
				<tr>
					<div class="col-xs-3">
					<td><b><label>Generic Name:</label></b></td>
					<td><input   value="${drugobj.genericName}"></input></td>
					<td><b><label>Drug Type:</label></b></td>
					<td><input  value="${drugobj.type}"></input></td>
					</div>
				</tr>

				<tr>
					<div class="col-xs-3">
					<td><b><label>Drug Group</b></label></td>
					<td><input  value="${drugobj.drugGroup}"></input></td>
					<td><b><label>MRP : </label></b></td>
					<td><input  value="${drugobj.mrp}"></input></td>
					</div>
					</tr>
					<tr>
						<div class="col-xs-3">
						<td><b><label> Manufaturer Name</b></label></td>
						<td ><input  value="${drugobj.manufaturerName}"></input></td>
						<td><b><label>Formulation : </label></b></td>
						<td><input  value="${drugobj.formulation}"></input></td>
						</div>
					</tr>

			</table>

			<div class="form-group"> 
<%-- 						<input type="hidden" class="form-control" name="name" value="${sessionScope.username}"/> 
 --%>						</div>				 
 		    

	
		    <div class="btn-group">
		      <button type="submit" class="btn btn-default">Submit</button>
		     <button type="button" class="btn btn-default">Cancel</button>
		     </div>
		     		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		  </form>
		  <br>
		  <br>
		</div>

			<div class="container text-center" id="tasksDiv">
				<h3>Order List</h3>
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Order Id</th>
								<th>Date</th>
								<th>user Name</th>
								<th>Age</th>
								<th>Details</th>
								<th>Status</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="orderList" items="${orderList}">
								<tr>
									<td>${orderList.id}</td>
									<td>${orderList.date}</td>
									<td>${orderList.orderUserName}</td>
									<td>${orderList.age}</td>
									<td>${orderList.details}</td>
 									<td>${orderList.status}</td>
									<td><a href="orders/${orderList.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
<%-- 									<td><a href="updateorder?id=${orderList.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
 --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

<footer class="container-fluid text-center">
  <p></p>
</footer>

</body>
</html>
