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
  
		function myFunction(p1, p2) {
		    return p1 * p2;              // The function returns the product of p1 and p2
		} 
		
		  function selectItemByValue(){
		  
		  var selectedobj = null;
		  selectedobj  = ${orderobj.status}; 
		  if( selectedobj == null) return;
		  alert(${orderobj.status});
		  

			var elmnt = document.getElementById("statusdropdown")
		  for(var i=0; i < elmnt.options.length; i++)
		  {
		    if(elmnt.options[i].value === ${orderobj.status}) {
		      elmnt.selectedValue = ${orderobj.status};
		      break;
		    }
		  }
		}

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
       <ul class="nav navbar-nav">
        <li class="active"><a href="/loginHome">Home</a></li>
        
      </ul>
      
      
      
    </div>
    
    
  </div>
</nav>

	<c:choose>
			<c:when test="${mode == 'MODE_DETAILS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>Order List</h3>
				<hr>
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
		</c:when>
	<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">


		<div class="container">
		  <h2>Order Details</h2> <br>
		  <form action="/saveorder" method="post" onreadystatechange="selectItemByValue()">
		  	<input type="hidden" name="id" value="${orderobj.id}"/>
 				<div class="form-group"> 
<%-- 						<input type="hidden" class="form-control" name="name" value="${sessionScope.username}"/> 
 --%>						</div>				 
<!-- 					</div> -->
		    <div class="form-group">
		      <b><label >Order Id: ${orderobj.id}</label></b>
 		      <input type="hidden" class="form-control"  placeholder="Order Id" name="orderId" value="${orderobj.id}">
 		    </div>
		      <div class="form-group">
		      <b><label >Age : ${orderobj.age}</label></b>
 		      <input type="hidden" type="text" class="form-control"  placeholder="Age" name="age" value="${orderobj.age}">
 		    </div>
		     <div class="form-group">
		      <label >Date : ${orderobj.date}</label>
 		      <input type="hidden" type="text" class="form-control"  placeholder="Date" name="date" value="${orderobj.date}">
 		    </div>
		     <div class="form-group">
		      <label >Details :</label><br>
		      <textarea rows="4" cols="50" readonly>
		      ${orderobj.details}
			  </textarea>
<!-- 		      <input type="text" class="form-control"  placeholder="Details" name="details" value=""> -->
		    </div>
		    <div class="form-group">
		      <b><label >User name : ${orderobj.orderUserName}</label></b>
		      <input type="hidden" type="text" class="form-control"  placeholder="orderUserName" name="orderUserName" value="${orderobj.orderUserName}">
		    </div>
		     <div class="form-group">
		      <label >Status : </label>
<%-- 		      <input type="text" class="form-control"  placeholder="Status" name="status" value="${orderobj.status}">
 --%>
 
 <select name="status">
    <c:forEach items="${status}" var="item">
        <option value="${item}" ${item == selectedStatus ? 'selected' : ' '} >${item}</option>  <!--  -->
    </c:forEach>
</select>		      
 
<%--  <select name="status" id="statusdropdown" >
 
				  <option value="1" ${role == selectedRole ? 'selected' : ''} >Pending</option>
				  <option value="2">Inprogress</option>
				  <option value="3">Done</option>
				  <option value="4">NeedInfo</option>
			</select> --%>
			</div>
		    
		     <button type="submit" class="btn btn-default">Submit</button>
		     <button type="button" class="btn btn-default">Cancel</button>
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
