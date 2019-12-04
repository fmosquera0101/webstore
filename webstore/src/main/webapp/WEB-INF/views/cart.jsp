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
	<title>Cart</title>
</head>
<body>
<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Cart</h1>
				<p>All the selected products in your cart</p>
			</div>
		</div>
	</section>
	
	<section class="container" ng-app="cartApp">
		<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
		
			
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit price</th>
					<th>Qauntity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr ng-repeat="(key, item) in cart.cartItems">
					<td>{{item.product.productId}}-{{item.product.name}}</td>
					<td>{{item.product.unitPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrice}}</td>
					<td><a href="#" class="label label-danger" ngclick="removeFromCart(item.product.productId)"> 
					<span class="glyphicon glyphicon-remove" /></span> Remove</a>
					</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr>
			</table>
			
			<div>
				<p>
					<a class="btn btn-danger pull-left" ng-click="clearCart()"> 
					<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a> 
					<a href="#" class="btn btn-success pull-right"> 
					<span class="glyphicon-shopping-cart glyphicon"></span> Check out</a>
				</p>
			</div>
			<a href="<spring:url value="/products" />" class="btn btn-secondary">
				<span class="glyphicon-hand-left glyphicon"></span>
				Continue shopping
			</a>
		</div>
	
	</section>
</body>
</html>