var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){
	
	$scope.refreshCart = function(cardId) {
		$http.get('/city/rest/cart/'+$scope.cartId).success(function(data) {
			$scope.cart = data;
		});
	};
	
	
	$scope.clearCart = function() {
		$http.delete('/city/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	

	$scope.testCart = function() {
		alert("Test cart desde angular galo...");
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId){
		$http.put('/city/rest/cart/add/'+productId).success(function(data){
			$scope.refreshCart($http.get('/city/rest/cart/cartId'));
			alert("Product added to cart");
		});
	};
	
	$scope.removeFromCart = function(productId){
		$http.put('/city/rest/cart/remove/'+productId).success(function(data){
			$scope.refreshCart($http.get('/city/rest/cart/cartId'));
			$scope.refreshCart();
		});	
	};
	
	$scope.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i=0; i<$scope.cart.cartItems.length; i++ ){
		   grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	};

});