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
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
			</div>
		</div>
	</section>

	<section class="container">

		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px ">
					<div class="thumbnail">
						<div class="caption">

							<div class="card" style="width: 18rem;">
								<img src="..." class="card-img-top" alt="...">
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
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

</body>
</html>