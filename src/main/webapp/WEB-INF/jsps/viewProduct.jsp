<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
    
    <div class="container">
    	<div class="row">
    		<div class="page-hedaer">
    			<h1>Producto</h1>
    			<p class="lead">Detalle</p>
    		</div>
		</div>
    </div>
    
    <div class="container">
    	<div class="row">
    		<div class="col-md-5">
    			<img alt="photo" src="${pageContext.request.contextPath}/resources/img/${product.productId}.png" 
    			     class="img-responsive img-rounded">
    		</div>
    	
    	<div class="col-md-5">
    		<h2>Nombre: ${product.productName}</h2>
    		<p>Clave:${product.productId}</p>
    		<p><b>Descripcion: ${product.productDescription}</b></p>
    		<p>Precio: ${product.productPrice}</p>
    		<p>Unidades: ${product.productUnits}</p>
    	</div>
    	</div>
    </div>

<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
