// HTML Control
window.onload = function(){
	document.getElementById("submitAccount").addEventListener('click', getEmployee);
	console.log("set the listener");
	//step one if the user clicks the button
}

function getEmployee(){
	Employee.setId(0);
	Employee.setUsername(document.getElementById("txtUsernameApply").value);
	Employee.setPassword(document.getElementById("txtPasswordApply").value);
	Employee.setFirstName(document.getElementById("txtFirstNameApply").value);
	Employee.setLastName(document.getElementById("txtLastNameApply").value);
	Employee.setEmail(document.getElementById("txtEMailApply").value);
	alert("Hello " + Employee.getFirstName() + " \"" + Employee.getUsername() + "\" " + Employee.getLastName() + " at " + Employee.getEmail() + ", " + Employee.getId());
	
	return Employee;
}

// Employee encapsulation
var Employee = (function(){
	var id_pk = 0;
	var username = "";
	var pswd = "";
	var firstName = "Test";
	var lastName = "Debug";
	var email = "";
	var reimbursement_fk = 0;
	
	return {
		getId : function (){
			return id;
		},
		setId : function (newId){
			id = newId;
		},

		getUsername : function (){
			return username;
		},
		setUsername : function (newUsername){
			username = newUsername;
		},

		getPassword : function (){
			return pswd;
		},
		setPassword : function (newPassword){
			pswd = newPassword;
		},

		getFirstName : function (){
			return firstName;
		},
		setFirstName : function (newFirstName){
			var re = new RegExp("^([a-z0-9]{5,})$");
			if(re.test(newFirstName)){
				alert("Invalid first name");
			} else {
				firstName = newFirstName;
			}
		},
		
		getLastName : function (){
			return lastName;
		},
		setLastName : function (newLastName){
			var re = new RegExp("^([a-z0-9]{5,})$");
			if(re.test(newLastName)){
				alert("Invalid first name");
			} else {
				lastName = newLastName;
			}
		},

		getEmail : function (){
			return email;
		},
		setEmail : function (newEmail){
			email = newEmail;
		},

		getForeignKey : function (){
			return reimbursement_fk;
		},
		setForeignKey : function (newKey){
			reimbursement_fk = newKey;
		}
	};
}());

/*
window.onload = function(){
	getEmployeeInfo();
}

function getEmployeeInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let employee = JSON.parse(xhttp.responseText);
			setValues(employee);
		}
	}
	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/Home.do', true);
	xhttp.send();
}

function setValues(employee){
	document.getElementById("txtFirstNameEdit").value = employee.getFirstName;
	document.getElementById("txtLastNameEdit").value = employee.setLastName;
} 
*/
