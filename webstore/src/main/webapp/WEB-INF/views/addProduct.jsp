<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger">logout</a>
			</div>
		</div>
	</section>

	<section class="container">
		<form:form modelAttribute="product" class="form-horizontal"  enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
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
				<form:errors path="name" cssClass="text-danger"></form:errors>
				<small id="nameHelp" class="form-text text-muted">Name for your product</small>
			</div>
			
			<div class="form-group">
				<label for="unitPrice">Price (USD)</label>
				<form:input id="unitPrice" path="unitPrice" type="text" class="form-text text-muted" />
				<form:errors path="unitPrice" cssClass="text-danger"></form:errors>
				<small id="unitPriceHelp" class="form-text text-muted">Enter the unit price for the product</small>
			</div>
			
			<div class="form-group">
				<label for="unitsInStock">Units in stock</label>
				<form:input id="unitsInStock" path="unitsInStock" type="text" class="form-text text-muted" />
				<small id="unitsInStockHelp" class="form-text text-muted">Enter the units in stock</small>
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea class="form-control" id="description" path="description" rows="3" maxlength="100"></form:textarea>
			</div>
			<div class="form-group">
				<label for="description">Add image</label>
				<form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
			</div>
			
			<input id="bntAdd" type="submit" class="btn btn-primary" value="Add"/>
		</form:form>
	</section>

</body>
</html>