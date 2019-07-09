<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
    
    <div class="container">
    	<div class="row">
    		<div class="page-hedaer">
    			<h1>Admin page</h1>
    			<p class="lead">Page of administration</p>
    			<h3><a href= "<c:url value="/admin/productInventory"/>">Product Inventory</a></h3>
    			<p>Desde aqui puedes ver , editar y eliminar productos</p>
    		</div>
		</div>
    </div>
    
<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
