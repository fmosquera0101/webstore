<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Products</title>
</head>
<body>
	<section class="jumbotron text-center">

			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
			</div>
	</section>
	
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<c:forEach items="${products}" var="product">
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
								<img src='<c:url value="/resources/images/product.png"></c:url>' class="card-img-top"   alt="Product image">
								
								<div class="card-body">
									<h5 class="card-title">${product.name}</h5>
									<p class="card-text">${product.description}</p>
									<p>${product.unitPrice}USD</p>
									<p>Available ${product.unitsInStock} units in stock</p>
									<a
										href=" <spring:url value="/products/product?id=${product.productId}"/> "
										class="btn btn-primary"> <span
										class="glyphicon-info-sign glyphicon"></span>Details
									</a>
								</div>
							</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>