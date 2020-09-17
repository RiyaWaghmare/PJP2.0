function isValidProductName(){
	var productName = document.getElementById("productname").value;
	var regex="^[a-zA-Z0-9-\s]+$";
	if(productName.match(regex)){		
		return true;
	}
	document.getElementById("productname").focus();
	return false;	
	
}

function isValidPrice(){
	var price = document.getElementById("price").value;
	
	if(price>0.0){		
		return true;
	}
	document.getElementById("price").focus();
	return false;
	
}

function validate(){
	if(isValidProductName() && isValidPrice()){
		console.log("Form submitted");
		return true;		
	}else{		
		console.log("Invalid Data. Form not submitted");
		return false;
	}
}




