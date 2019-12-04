// HTML Control
window.onload = function(){
	document.getElementById("submitReimbursement").addEventListener('click', getTicket);
	//console.log("");
}

function getTicket(){
	Ticket.setId(0);
	if(document.getElementById("lodgingType").checked == true){
		Ticket.setType("Lodging");
	} else if(document.getElementById("travelType").checked == true){
		Ticket.setType("Travel");
	} else if(document.getElementById("foodType").checked == true){
		Ticket.setType("Food");
	} else if(document.getElementById("otherType").checked == true){
		Ticket.setType("Other");
	}
	let path = document.getElementById("fileupload");
	if(path.value != null && path.value != undefined){
		alert("Recieved, Id:" + Ticket.getId() + " Type: " + Ticket.getType() + " Receipt: " + path.value);
	} else {
		alert("Recieved, Id:" + Ticket.getId() + " Type: " + Ticket.getType());
	}
	return Ticket;
}

// Ticket encapsulation
var Ticket = (function(){
	var id_pk = 0;
	var type = "";
	var employee_fk = 0;
	
	return {
		getId : function (){
			return id;
		},
		setId : function (newId){
			id = newId;
		},

		getType : function (){
			return type;
		},
		setType : function (newType){
			type = newType;
		},

		getForeignKey : function (){
			return employee_fk;
		},
		setForeignKey : function (newKey){
			employee_fk = newKey;
		}
	};
}());
