<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<div class="alert alert-danger" role="alert">
					${message}
				</div>
			</div>
		</div>
	</section>

	<section class="container">
	
		<div class="row">

			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
	
						<p>${url}</p>
						<p>${exception}</p>

							<a href=" <spring:url value="/products"/> " class="btn btn-secondary">
									<span class="glyphicon-hand-left glyphicon"></span>Back
								</a>
						
					</div>
				</div>
			</div>

		</div>
	</section>

</body>
</html>