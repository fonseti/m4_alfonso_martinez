<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "container">
	
		<h1>User Directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/UserController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "name" placeholder = "Enter Name" value = "${user.name}"/>
					</div>
					
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "surname" placeholder = "Enter Surname" value = "${user.surname}"/>
					</div>
				
				
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "age" placeholder = "Enter Age" value = "${user.age}"/>
					</div>
					
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "email" placeholder = "Enter Email" value = "${user.email}"/>
					</div>
					
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "password" placeholder = "Enter Password" value = "${user.password}"/>
					</div>
				
					<input type = "hidden" name = "id" value = "${user.id}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/UserController?action=LIST">Back to List</a>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>