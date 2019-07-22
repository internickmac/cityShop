<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container-wrapper">
		<div class="container">
			
			<section >
				<div class="jumbotron">
					<div class="container">
						<h1>Cart</h1>
						<p>Tus productos</p>
					</div>
				</div>
			</section>
			
			<section class="container" ng-app="cartApp">
			  <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				<div>
					<a class="btn btn-danger pull-left" ng-click="clearCart()">Clear Cart</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                             remove button</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
						<th></th>
					</tr>
				</table>
				
				<a href="<spring:url value="/productList" />" class="btn btn-default">Continue shopping</a>
			</div>
		</section>
			
		</div>
</div>

<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %> 
