<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Login</title>

</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Login Page</h1>
				<p>Please enter a valid usarname and password</p>
			</div>
		</div>
	</section>

	<div class="container">
		<div class="row">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
					<br />
				</div>
			</c:if>
			
			
			<form action="<c:url value="/j_spring_security_check"></c:url>" method="post" role="form">
				<div class="form-group">
					<label for="j_username">Email address</label> <input
						class="form-control" id="j_username" name="j_username"
						aria-describedby="emailHelp" placeholder="Enter email"> <small
						id="emailHelp" class="form-text text-muted"> We'll never
						share your email with anyone else. </small>
				</div>
				<div class="form-group">
					<label for="j_password">Password</label> <input type="password"
						class="form-control" id="j_password" name="j_password"
						placeholder="Password">
				</div>

				<input type="submit" class="btn btn-primary" value="Login" />
			</form>
		</div>
	</div>
</body>
</html>