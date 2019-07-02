<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
    
    <div class="container">
    	<div class="row">
    		<div class="page-hedaer">
    			<h1>Nuestros Products</h1>
    			<p class="lead">Listado de productos</p>
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
					<td><a href= "<spring:url value="/productList/viewProduct/${product.productId}" />" >
					    <span class="glyphicon glyphicon-asterisk"></span></a></td>
				</tr>
				</c:forEach>
			</table>
			
		</div>
    </div>

<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
