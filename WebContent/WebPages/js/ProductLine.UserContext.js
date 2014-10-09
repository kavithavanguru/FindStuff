/**
 * Author : Kavitha
 */


var ProductLine = ProductLine || {};
//ProductLine.UserContext =  {};
ProductLine.UserContext = {};


ProductLine.UserContext =  {
	Customer : { CustomerId:0,
				 LastName: "",
				 FirstName:"" ,
				 Address1:"",
				 Address2:"",
				 State:"",
				 Zip:"",
				 Phone: "",
				 Email:"",
				 UserName:"",
				 Password:"",
				 paymentInfo:{
					 PaymentId :0,
					 CreditCardNum:"",
					 NameOnCard:"",
					 CVV:"",
					 ExpiryDate:"",
					 CardType:""
				 	}
				},
					 
	isLoggedIn : false
};