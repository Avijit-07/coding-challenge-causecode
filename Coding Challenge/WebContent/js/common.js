
function onAdd(){
	document.getElementById("div2a").hidden = false;
	document.getElementById("div2b").hidden = false;
	document.getElementById("buttonADD").hidden = false;
	document.getElementById("buttonCHANGE").hidden = true;
	document.getElementById("buttonREMOVE").hidden = true;
 }
 function onChange() {
	document.getElementById("div2a").hidden = false;
	document.getElementById("div2b").hidden = false;
	document.getElementById("buttonADD").hidden = true;
	document.getElementById("buttonCHANGE").hidden = false;
	document.getElementById("buttonREMOVE").hidden = true;
}
 function onRemove() {
	document.getElementById("div2a").hidden = false;
	document.getElementById("div2b").hidden = true;
	document.getElementById("buttonADD").hidden = true;
	document.getElementById("buttonCHANGE").hidden = true;
	document.getElementById("buttonREMOVE").hidden = false;
}
 function onCreate(){
	 storeId = document.getElementById("storeId").value;
	 alert("Store with Id: "+storeId+" created!");
	}

 function onUpdate(){
	 storeId = document.getElementById("storeId").value;
	 alert("Store with ID: "+storeId+" updated!");
	}

 function onDelete(){
	 storeId = document.getElementById("storeId").value;
	 confirm("Are you sure you want to delete Store with ID: "+storeId+" ?");
	}
 
 function checkA(){
	 alert(document.getElementById("storeId").value);
 }
 
 function checkB(){
	 
 } 