let usernameQuery;
let passwordQuery;
window.onload = function(){
	document.getElementById("LoginSubmit").addEventListener('click', checkValidation);
}

function checkValidation() {
	linkEmployeeMainMenu();
	/*
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	     // Access the result here
		 usernameQuery = JSON.parse(xhttp.responseText);
		 alert(usernameQuery);
		 console.log(usernameQuery);
	     checkPassword();
	 }
    };
    xhttp.open("GET", "http://project1-demo-endpoint.execute-api.com/project1/usernames", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Project1-Api-Usernames", "Project1-Login-Query");
    xhttp.send();
	*/
}

function checkPassword(){
	console.log(usernameQuery);
	alert(usernameQuery);
	document.getElementById("loginQueryCheckMessage").innerHTML = usernameQuery.warning.value;
}