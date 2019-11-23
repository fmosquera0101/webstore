<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Add Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Add Products</h1>
				<p>Add your product in the following section</p>
			</div>
		</div>
	</section>

	<section class="container">
		<form:form modelAttribute="product" class="form-horizontal">
		<div class="form-group">
    			<label for="category">Product Category</label>
   				 	<form:select class="form-control" id="category" path="category">
      					<option>Smartphone</option>
     				 	<option>Tablet</option>
     				 	<option>Laptop</option>
     				 	<option>Smart Tv</option>
    			</form:select>
  			</div>
			<div class="form-group">
    			<label for="manufacturer">Manufacturer</label>
   				 	<form:select class="form-control" id="manufacturer" path="manufacturer">
      					<option>Apple</option>
     				 	<option>Samsung</option>
     				 	<option>Dell</option>
     				 	<option>Lenovo</option>
    			</form:select>
  			</div>
  			
			<div class="form-group">
				<label for="name">Product Name</label>
				<form:input id="name" path="name" type="text" class="form-text text-muted" />
				<small id="nameHelp" class="form-text text-muted">Name for your product</small>
			</div>
			
			<div class="form-group">
				<label for="unitPrice">Price (USD)</label>
				<form:input id="unitPrice" path="unitPrice" type="text" class="form-text text-muted" />
				<small id="unitPriceHelp" class="form-text text-muted">Enter the unit price for the product</small>
			</div>
			
			<div class="form-group">
				<label for="unitsInStock">Units in stock</label>
				<form:input id="unitsInStock" path="unitsInStock" type="text" class="form-text text-muted" />
				<small id="unitsInStockHelp" class="form-text text-muted">Enter the units in stock</small>
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea class="form-control" id="description" path="description" rows="3"></form:textarea>
			</div>
			
			<div class="form-group">
    			<label for="discontinued">Discontinued</label>
   				 	<form:select class="form-control" id="discontinued" path="discontinued">
      					<option>false</option>
     				 	<option>true</option>
    			</form:select>
  			</div>
			<input id="bntAdd" type="submit" class="btn btn-primary" value="Add"/>
		</form:form>
	</section>

</body>
</html>