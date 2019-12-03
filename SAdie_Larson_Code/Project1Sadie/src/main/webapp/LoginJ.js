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
