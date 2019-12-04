/**
 * 
 */

window.onload = function(){
	getUserInfo();
}

function getUserInfo(){

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function(){

		if(xhttp.readyState == 4 && xhttp.status == 200){

			let pet = JSON.parse(xhttp.responseText);

			setValues(user);

		}

	}

	xhttp.open("GET", 'http://localhost:8080/Project1/html/Home.do', true);

	xhttp.send();

}



function setValues(user){

	document.getElementById("Username").innerHTML = "User's name is " + user.Username;

	document.getElementById("password").innerHTML = "User's password is " + user.password;
}