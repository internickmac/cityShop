<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/jsps/templates/header.jsp" %>
    
    <div class="container">
    	<div class="row">
    		<div class="page-hedaer">
    			<h1>Edit Product</h1>
    			<p class="lead">Desde aqui puedes editar productos</p>

    		</div>
		</div>
    </div>
    
    <div class="container">
    	<div class="row">
    		<form action="${pageContext.request.contextPath}/admin/product/editProduct"
    		      method="post" enctype="multipart/form-data">
    		
    			<input type="hidden" name="productId" value="${product.productId}">
    			
		    	<div class="form-group">
		    		<label for="name">Name of Product</label>
		    		<input type="text" id="name" name="productName" class="form-control" value="${product.productName}">
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="category">Category</label>
		    		<label class="checkbox-inline"><input type="radio" name="productCategory" id="category" value="Instrument">Instrument</label>
		    		<label class="checkbox-inline"><input type="radio" name="productCategory" id="category" value="Audio">Audio</label>
		    		<label class="checkbox-inline"><input type="radio" name="productCategory" id="category" value="Video">Video</label>
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="description">Description</label>
		    		<textarea rows="5" cols="60" class="form-control" name="productDescription" id="description" value="${product.productDescription}"></textarea>
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="price">Product Price</label>
		    		<input type="text" id="price" name="productPrice"class="form-control" value="${product.productPrice}">
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="condition">Condition</label>
		    		<label class="checkbox-inline"><input type="radio" name="productCondition" id="condition" value="Nuevo">Nuevo</label>
		    		<label class="checkbox-inline"><input type="radio" name="productCondition" id="condition" value="Usado">Usado</label>
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="status">Status</label>
		    		<label class="checkbox-inline"><input type="radio" name="productStatus" id="status" value="Activo">Activo</label>
		    		<label class="checkbox-inline"><input type="radio" name="productStatus" id="status" value="No-Activo">No-Activo</label>
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="unitsInStock">Units</label>
		    		<input type="text" name="productUnits" id="unitsInStock" class="form-control" value="${product.productUnits}">
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="manufacturer">Manufacturer</label>
		    		<input type="text" name="productManufacturer" id="manufacturer" class="form-control" value="${product.productManufacturer}">
		    	</div>
		    	
		    	<div class="form-group">
		    		<label for="productImage" class="control-label">Choose Image</label>
		    		<input type="file" name="productImage" id="productImage" class="form-control">
		    	</div>
		    	
		    	<div class="form-group">
		    		<input type="submit" value="Guardar" class="btn btn-primary">
		    	    <a href="<c:url value="/admin/productInventory"/>" class="btn btn-danger">Cancel</a>
		    	</div>
		    	
           </form>
		</div>
    </div>
    
    
    
    
<%@ include file="/WEB-INF/jsps/templates/footer.jsp" %>
   
