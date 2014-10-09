// ===========================================================================
// 
// Author: Kavitha Vanguru
// Description: Call RESTful Web Services from mobile HTML pages
//              using jQuery mobile, Jersey, Jackson, and EclipseLink
// 
// ===========================================================================
 
// Immediate function
(function () {
    var restfulWebServiceBaseUri,callService, 
    ajaxCallFailed,displaySubCatList,itemsBySubCategoryUri,displayItemsInSubCategory,itemJSON;
    
     
    // Base URI of RESTful web service
    restfulWebServiceBaseUri = "/FindStuff/jaxrs/shopping"; 
    itemsBySubCategoryUri = "/FindStuff/jaxrs/shopping/{id}"
    // Execute after the page one dom is fully loaded
    
    // Retrieve subcategories list   
    $(".one").ready(function () {        

        callService(restfulWebServiceBaseUri, displaySubCatList);
         
        // Attach onclick event to each row of subcategory list on page one
        $("#subCategoryList").on("click", "li", function(event){
			getItemsBySubCategory($(this).attr("id").split("sub_Cat_Id_").pop());
        });
    });
    
    
    // Call a service URI and return JSON to a function
    callService = function (Uri, successFunction) {
        $.ajax({
            //cache: true,
            url: Uri,
            type: "GET",
            contentType: "application/javascript",
            dataType: "json",
            error: ajaxCallFailed,
            failure: ajaxCallFailed,
            success: successFunction
        });          
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
     
    // Display subcategories list on page one
    displaySubCatList = function (subCategory) {
        var subCategoryList = "";
                 
        $.each(subCategory, function(index, subCategory) {
            subCategoryList = subCategoryList.concat(            		
                "<li id=sub_Cat_Id_" + subCategory.Sub_Cat_Id.toString() + " data-corners='false' data-shadow='false' data-iconshadow='true' data-wrapperels='div' data-icon='arrow-r'data-iconpos='right' data-theme='c' class='ui-btn ui-btn-icon-right ui-li-has-arrow ui-li ui-li-has-thumb ui-first-child ui-btn-up-c'><div class='ui-btn-inner ui-li'><div class='ui-btn-text'><a href='#' class='ui-link-inherit'>" + 
                "<img src=" + subCategory.Sub_Cat_Img.toString() +" alt="+ subCategory.Sub_Cat_Name.toString() + " class='ui-li-thumb'>" + 
                "<h2 class='ui-li-heading'>" +  subCategory.Sub_Cat_Name.toString() + "</h2></a>" +
                "</div><span class='ui-icon ui-icon-arrow-r ui-icon-shadow'>&nbsp;</span></div></li>" );
                
        });
         
        $('#subCategoryList').empty();
        $('#subCategoryList').append(subCategoryList).listview("refresh", true);
    };
    
 // Retrieve items under the sub category
    getItemsBySubCategory = function (sub_Cat_Id) {
        callService(itemsBySubCategoryUri.replace("{id}", sub_Cat_Id), displayItemsInSubCategory);
    };
    
    // Display items list on page two
    displayItemsInSubCategory = function (items) {
    	$.mobile.loading( 'show', {
			text: '',
			textVisible: false,
			theme: 'a',
			html: ""

		});
		window.location = "#two";
		var itemList = "";
		itemJSON = items;
		$.each(items, function(index, item) {
			itemList = itemList.concat(            		
					"<li id=empId_" + item.Item_Id.toString() + " data-corners='false' data-shadow='false' data-iconshadow='true' data-wrapperels='div' data-icon='arrow-r'data-iconpos='right' data-theme='c' class='ui-btn ui-btn-icon-right ui-li-has-arrow ui-li ui-li-has-thumb ui-first-child ui-btn-up-c'><div class='ui-btn-inner ui-li'><div class='ui-btn-text'><a href='#' class='ui-link-inherit'>" + 
					"<img src=" + item.Item_Img.toString() +" alt="+ item.Item_Name.toString() + " class='ui-li-thumb'>" + 
					"<h2 class='ui-li-heading'>" +  item.Item_Name.toString() + "</h2></a>" +
			"</div><span class='ui-icon ui-icon-arrow-r ui-icon-shadow'>&nbsp;</span></div></li>" );

		});
         
        $('#itemList').empty();
        $('#itemList').append(itemList).listview("refresh", true);
    };
    
    $("#two").ready(function () {        

        $("#itemList").on("click", "li", function(event){
        	item =  {"Sub_Cat_Id":1,"Item_Id":1,"Item_Name":"Golds Gym cm Fitness Ball","Item_Desc":"Add an exciting and fun exercise to your weekly workout regimen with this Golds Gym Weighted Fitness Hoop. It features a fun whole body workout geared at improving balance, coordination and endurance. This hula hoop features foam padding for comfort and a workout guide with a DVD aimed at strengthening and toning your core.","Item_Img":"images/Items/FitnessBall.jpg","Item_Price":15,"Item_Qty":10}
        	//itemJSON[1] ;
        	//displayItemDetail(item);
        });
    });
    

    
	 function displayItemDetail(item) {
		 
	        $.mobile.loading( 'show', {
	            text: '',
	            textVisible: false,
	            theme: 'a',
	            html: ""
	             
	        });
	        window.location = "#three";
	        var itemDetail = "";
	        itemDetail = itemDetail.concat("<img src=" + item.Item_Img +" alt="+ item.Item_Name + " class='ui-li-thumb'>")
	          itemDetail = itemDetail.concat(
	                    "<div class='detail'>" +
	                    "<div class='field'> Name</div>" +
	                    "<div class='value'>" + item.Item_Name + "</div>" +
	                    "</div>");  
	        itemDetail = itemDetail.concat(
                    "<div class='detail'>" +
                    "<div class='field'> Description </div>" +
                    "<div class='value'>" + item.Item_Desc + "</div>" +
                    "</div>");  
	        itemDetail = itemDetail.concat(
                    "<div class='detail'>" +
                    "<div class='field'> Price </div>" +
                    "<div class='value'>" + item.Item_Price + "</div>" +
                    "</div>");   
	        

	        $("#itemDetail").empty().append(itemDetail);
	    };
} ());