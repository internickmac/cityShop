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
				    <th>Picture</th>
					<th>Clave</th>
					<th>Articulo</th>
					<th>Description</th>
					<th>Precio</th>
					<th>Unidades</th>
					<th></th>
				</tr>
                
                <c:forEach items="${products}" var="product">
				<tr>
					<td><img alt="Picture" src="resources/img/${ product.productId}.png" style="width:100px; height:100px;"></td>
					<td style="vertical-align:middle;">${product.productId}</td>
					<td style="vertical-align:middle;">${product.productName}</td>
					<td style="vertical-align:middle;">${product.productDescription}</td>
					<td style="vertical-align:middle;">${product.productPrice}</td>
					<td style="vertical-align:middle;">${product.productUnits}</td>
					<td style="vertical-align:middle;"><a href= "<spring:url value="/productList/viewProduct/${product.productId}" />" >
					    <span class="glyphicon glyphicon-asterisk"></span></a></td>
				</tr>
				</c:forEach>
			</table>
			
		</div>
    </div>

<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
