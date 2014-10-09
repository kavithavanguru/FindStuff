/**
 * 
 */

/// <reference path="http://code.jquery.com/jquery-1.10.2.min.js" />
var ProductLine = ProductLine || {};
ProductLine.Provider =  {};

ProductLine.Provider.SubCategories = {};
ProductLine.Provider.Items = {};
ProductLine.Provider.ItemDetails ={};

ProductLine.Provider.Customer ={
		CustomerId:0,
		LastName: "",
		FirstName:"" ,
		Address1:"",
		Address2:"",
		State:"",
		Zip:"",
		Phone: "",
		Email:"",
		UserName:"",
		Password:""
};
ProductLine.Provider.defaultOptions = {
		
		ShoppingRootUri : "http://localhost:8081/FindStuff/jaxrs/shopping" ,
		ProfileRootUri : "http://localhost:8081/FindStuff/jaxrs/profile" ,
		ShoppingCartRootUri : "http://localhost:8081/FindStuff/jaxrs/shoppingCart" ,
		itemsBySubCategoryEndPoint : "/{id}" ,
		itemDetailsEndPoint : "/getItemDetails/{Sub_Cat_Id}/{Item_Id}" ,
		InsertCustomerEndPoint : "/InsertProfile" ,
		retrieveCustomerEndPoint : "/GetProfile",
		updateCustomerEndPoint : "/UpdateProfile",
		addToCartEndPoint : "/AddToCart",
		getCartItemsEndPoint : "/GetCartItems",
		
		InsertCustomerUri: function(){
			return this.ProfileRootUri + this.InsertCustomerEndPoint;
		},
		retrieveCustomerUri: function(){
			return this.ProfileRootUri + this.retrieveCustomerEndPoint;
		},
		updateCustomerUri: function(){
			return this.ProfileRootUri + this.updateCustomerEndPoint;
		},
		GetSubCategoriesUri : function(){
			return this.ShoppingRootUri;
		},
		GetItemsBySubCategoryUri : function(sub_Cat_Id){
			return (this.ShoppingRootUri + this.itemsBySubCategoryEndPoint).replace("{id}", sub_Cat_Id);
		},
		GetItemDetailsUri : function(sub_Cat_Id,item_Id){
			//this.itemDetailsEndPoint.replace("{Sub_Cat_Id}", sub_Cat_Id).replace("{Item_Id}", item_Id);
			return (this.ShoppingRootUri + this.itemDetailsEndPoint).replace("{Sub_Cat_Id}", sub_Cat_Id).replace("{Item_Id}", item_Id);
		},
		AddToCartUri: function(){
			return this.ShoppingCartRootUri + this.addToCartEndPoint;
		},
		GetCartItemsUri: function(){
			return this.ShoppingCartRootUri + this.getCartItemsEndPoint;
		},

};

ProductLine.Provider.parsePathParam = function() {
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
};

ProductLine.Provider.GetCallService = function (type , Uri, data, callback){
	$.ajax({
        //cache: true,
        url: Uri,
        type: type,
        contentType: 'application/json',
        dataType: "json",
        error: ajaxCallFailed,
        data: data,
        failure: ajaxCallFailed,
        success: callback
    }); 
};

ProductLine.Provider.ShowPageLoading = function (){
	 $.mobile.loading( 'show', {
			text: 'FindStuff@wiu.edu',
			textVisible: true,
			theme: 'a',
		});
};

ProductLine.Provider.HidePageLoading = function (){
	$.mobile.loading( 'hide');
};


// Called if ajax call fails
ajaxCallFailed = function (jqXHR, textStatus) { 
   console.log("Error: " + textStatus);
   console.log(jqXHR);
   $("form").css("visibility", "hidden");
   $("#errorMessage").empty().
   append("Sorry, there was an error.").
   css("color", "red");
};

/*(function($) {
$.QueryString = (function(a) {
    if (a == "") return {};
    var b = {};
    for (var i = 0; i < a.length; ++i)
    {
        var p=a[i].split('=');
        if (p.length != 2) continue;
        b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
    }
    return b;
})(window.location.search.substr(1).split('&'))
})(jQuery);*/
