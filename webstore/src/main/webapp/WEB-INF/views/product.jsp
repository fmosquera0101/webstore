<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src='<c:url value="/resources/js/controller.js"></c:url>'></script>
	<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
			</div>
		</div>
	</section>

	<section class="container"  ng-app="cartApp">
	
		<div class="row">
		<div class="col-md-5">
		<img src='<c:url value="/resources/images/product.png"></c:url>' class="card-img-top" alt="...">
		</div>
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>
							<strong>Item code</strong>: <span class="label label-warning">${product.productId}</span>
						</p>
						<p>
							<strong>Manufacturer</strong>: ${product.manufacturer}
						</p>
						<p>
							<strong>Category</strong>: ${product.category}
						</p>
						<p>
							<strong>Available units in Stock</strong>: ${product.unitsInStock}
						</p>
						<h4>${product.unitPrice}USD</h4>
						<p ng-controller="cartCtrl">
							<a href=" <spring:url value="/products"/> " class="btn btn-secondary">
							<span class="glyphicon-hand-left glyphicon"></span>Back
							</a>
						
							<a href="#" class="btn btn-warning btn-large"  ng-click="addToCart('${product.productId}')">
							<span class="glyphicon-shopping-cart glyphicon"></span>Order Now
							</a>
						
							<a href="<spring:url value="/cart" />" class="btn btn-info">
							<span class="glyphicon-hand-right glyphicon"></span> View Cart
							</a>
						</p>
					</div>
				</div>
			</div>

		</div>
	</section>

</body>
</html>