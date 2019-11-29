/**
 * 
 */

/*
 * Login page
 */
let buttonOne = document.getElementById('log');
buttonOne.addEventListener('click', logFunc);
let buttonTwo = document.getElementById('create');
buttonTwo.addEventListener('click', createFunc);
function logFunc() {
	console.log("hi");
}
function createFunc() {
	window.location.href = "http://localhost:9001/Project1Sadie/create.html";
}

let buttonThree = document.getElementById('createA');
buttonThree.addEventListener('click', successFunc);

function successFunc() {
	console.log("hi");
	// make an image populate and take over whole page to say success waiting for
	// email
}
/*
 * Employee Dashboard
 */

let buttonFour = document.getElementById('submitRequests');
buttonFour.addEventListener('click', submitFunc);
function submitFunc() {
	window.location.href = "";
}

/*
 * pending employee accoutn page
 */
window.onload = function() {
	document.getElementById('refresh').addEventListener('click', getPending);

}

function getPending() {
	let employeeId = document.getElementById('employeeId').value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let ticket = JSON.parse(xhttp.responseText);
			console.log(ticket);
			setValues(ticket);
		}
	}
	xhttp.open("GET", 'our database URL for restful' + employeeId, true);
	xhttp.send();

}

function setValues(ticket) {

	document.getElementById("submissionDate").innerHTML = ticket.submissionDate
	document.getElementById("ticketNumber").innerHTML = ticket.ticketNumber
	document.getElementById("subjectOfTicket").innerHTML = ticket.subject
	document.getElementById("ticketDescription").innerHTML = ticket.ticketDescription

}