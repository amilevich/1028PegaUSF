/**
 * 
 */

 var globalUser;
 var today = new Date();
var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
var dateTime = date+' '+time;

window.onload = function(){
	getUserInfo();
}

function getUserInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let user = JSON.parse(xhttp.responseText);
			setValues(user);	
		}
	}
	xhttp.open("GET", 'http://localhost:8090/ProjectOne/Home.do', true);
	xhttp.send();
}

function setValues(user){
	document.getElementById("userNameHere").innerHTML = "Welcome " + user.firstName;
}
/*
let ticketBody = document.getElementById('employeeTicketsBody');

document.getElementById("employeeHome").addEventListener("click", function(e){
	e.preventDefault();
	ticketBody.style.display="none";

	
})
document.getElementById("addTickets").addEventListener("click", function(e){
	e.preventDefault();
	ticketBody.style.display="block";
	createForm();
})
document.getElementById("pastTickets").addEventListener("click", function(e){
	e.preventDefault();
	ticketBody.style.display="block";
})
document.getElementById("logout").addEventListener("click", function(e){
	e.preventDefault();
	ticketBody.style.display="block";
})
*/

/*
function createForm(){
	let form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "AddTickets.do")
	form.setAttribute("class", "login")

	let nameInput = document.createElement("input");
	nameInput.setAttribute("type", "hidden");
	nameInput.setAttribute("name", "userid");
	nameInput.setAttribute("value", 123);

	let ticketTypeInput = document.createElement("select");
	let option1 = document.createElement("option");
	option1.setAttribute("value", "Food");
	option1.innerText="Food";
	ticketTypeInput.appendChild(option1);

	
	let option2 = document.createElement("option");
	option2.setAttribute("value", "Gas");
	option2.innerText="Gas";
	ticketTypeInput.appendChild(option2);

	let option3 = document.createElement("option");
	option3.setAttribute("value", "Cell");
	option3.innerText="Cell";
	ticketTypeInput.appendChild(option3);

	let option4 = document.createElement("option");
	option4.setAttribute("value", "Extra");
	option4.innerText="Extra";
	ticketTypeInput.appendChild(option4);


	let amount = document.createElement("input");
	amount.setAttribute("type", "text");
	amount.setAttribute("name", "amount");
	amount.setAttribute("placeholder", "Please Specify the amount");

	let currentDate =  document.createElement("input");
	currentDate.setAttribute("type", "hidden");
	currentDate.setAttribute("name", "currentDate");
	currentDate.setAttribute("value", dateTime);

	let desc = document.createElement("textarea");
	desc.setAttribute("placeholder", "Please provide a short description");
	desc.setAttribute("name", "description");
	let lineBreak = document.createElement("br");
	let submitButton = document.createElement("input");
	submitButton.setAttribute("type", "submit");
	form.appendChild(nameInput);
	form.appendChild(lineBreak);
	form.appendChild(lineBreak);

	form.appendChild(ticketTypeInput);
	form.appendChild(lineBreak);form.appendChild(lineBreak);
	
	form.append(amount);
	form.appendChild(lineBreak);form.appendChild(lineBreak);

	form.append(currentDate);
	form.appendChild(lineBreak);form.appendChild(lineBreak);

	form.append(desc);
	form.appendChild(lineBreak);form.appendChild(lineBreak);
	
	form.append(submitButton);
	form.appendChild(lineBreak);form.appendChild(lineBreak);

	document.getElementById('employeeTicketsBody').append(form);


}
*/