<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
    
    <div class="container">
    	<div class="row">
    		<div class="page-hedaer">
    			<h1>Product Inventory</h1>
    			<p class="lead">Productos en nuestro inventario</p>
    		</div>

			<table class="table table-striped table-hover">
				<tr>
					<th>Clave</th>
					<th>Articulo</th>
					<th>Description</th>
					<th>Precio</th>
					<th>Unidades</th>
					<th></th>
				</tr>
                
                <c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productDescription}</td>
					<td>${product.productPrice}</td>
					<td>${product.productUnits}</td>
					<td><a href= "<spring:url value="/product/viewProduct/${product.productId}" />" >
					    <span class="glyphicon glyphicon-asterisk"></span></a>
					    <a href= "<spring:url value="/admin/product/deleteProduct/${product.productId}" />" >
					    <span class="glyphicon glyphicon-remove"></span></a>
					    <a href= "<spring:url value="/admin/product/editProduct/${product.productId}" />" >
					    <span class="glyphicon glyphicon-pencil"></span></a>
					    </td>    
				</tr>
				</c:forEach>
			</table>
			
			<a href="<spring:url value="/admin/product/addProduct"/>"  class="btn btn-primary">Add Product</a>
			
		</div>
    </div>

<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
