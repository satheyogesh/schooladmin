<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
  <style>
  .error {
	color: red;
}
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
        padding: 15px;
      }
      .row.content {height:auto;} 
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
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/loginHome">Home</a></li>
        <li><a href="/batch">New Batch</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

	<c:choose>
	
	<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome </h1>
				</div>
			</div>
		</c:when>
		
			<c:when test="${mode == 'MODE_DETAILS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>Batch List</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Batch Name</th>
								<th>Batch Details</th>								
								<th>Start Date</th>
								<th>End Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="batchList" items="${batchList}">
								<tr>
									<td>${batchList.batchid}</td>
									<td>${batchList.batchName}</td>
									<td>${batchList.batchDesc}</td>
									<td>${batchList.startDate}</td>
									<td>${batchList.endDate}</td>
								    <td><a href="updatebatch?batchid=${batchList.batchid}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deletebatch?batchid=${batchList.batchid}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
	<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">


		<div class="container">
		  <h2>Batch Details</h2> <br>
		  <form action="/batch" method="post">
		   <spring:hasBindErrors name="batchForm">
		   			<c:forEach var="error" items="${errors.allErrors}">
					   	<font color="red">
					   		<b><spring:message message="${error}" /></b>
							<br/>
						</font>
					</c:forEach>
    	</spring:hasBindErrors>
    	
    	<c:if test="${empty batchobj.batchid}">
		  	<input type="hidden" name="batchid" value="1"/>
		</c:if>
		
		<c:if test="${not empty batchobj.batchid}">
			<input type="hidden" name="batchid" value="${batchobj.batchid}"/>
		</c:if>
	  	
 				<div class="form-group"> 
						</div>				 
<!-- 					</div> -->
		  
		     <div class="form-group">
		      <label >Batch Name:</label>
		      <input  type="text" class="form-control"  placeholder="Enter  Batch Name" name="batchName" value="${batchobj.batchName}"/>
		      

		    </div>
		    <div class="form-group">
		      <label >Batch Description:</label>
		      <input type="text" class="form-control"  placeholder="Enter Batch Description" name="batchDesc" value="${batchobj.batchDesc}">
		    </div>
		      <div class="form-group">
		      <label >Start Date:</label>
		      <input type="text" class="form-control"  placeholder="Enter Start Date" name="startDate" value="${batchobj.startDate}">
		    </div>
		    <div class="form-group">
		      <label >End Date:</label>
		      <input type="text" class="form-control"  placeholder="Enter End Date" name="endDate" value="${batchobj.endDate}">
		    </div>
		     <div class="form-group">
		      <label >Start Time:</label>
		      <input type="text" class="form-control"  placeholder="Enter Start Time" name="startTime" value="${batchobj.startTime}">
		    </div>
		     <div class="form-group">
		      <label >End Time: </label>
		      <input type="text" class="form-control"  placeholder="Enter End Time" name="endTime" value="${batchobj.endTime}">
		    </div>
		     <div class="form-group">
		      <label >Minimum Age :</label>
		      <input type="text" class="form-control"  placeholder="Enter Minimum Age" name="minAge" value="${batchobj.minAge}">
		    </div>
		    <div class="form-group">
		      <label >Maximum Age :</label>
		      <input type="text" class="form-control"  placeholder="Enter Maximum Age" name="maxAge" value="${batchobj.maxAge}">
		    </div>
				   
<!-- 		     <button type="submit" class="btn btn-default">Submit</button> -->
<!-- 		     <button type="button" class="btn btn-default">Cancel</button> -->

<input type="submit" class="button" name="save" value="save"/>
<input type="submit" class="button" name="cancel" value="cancel"/>
		     		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		  </form>
		  <br>
		  <br>
		</div>

	</c:when>
	</c:choose>


<footer class="container-fluid text-center">
  <p></p>
</footer>

</body>
</html>
