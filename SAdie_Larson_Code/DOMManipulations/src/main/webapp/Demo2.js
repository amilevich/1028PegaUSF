/**
 * 
 */

// GET ELEMENT BY ID
let paraTwo = document.getElementByID('para2');
paraTwo.innerText = 'hey look at me';

let paraThree = document.getElementByID('para3');
paraThree.innerHTML = '<b><i> Yay to a three day week</i>,</b>';

// GET ELEMENTS BY CLASS
let hders = document.getElementsBYClassName('headers');
hders[1].innerText = "Awesome";
hders[1].addEventListener('click', myFuncThree);

// get elmeents by tag name, by children, uery selector, etc

// Event listeners
let buttonOne = document.getElementById('button');
buttonOne.addEventListener('click', myFunc);
// pass in the event and the actio that will execute when the event is triggered

function myFunc(eve) {
	console.log(eve, altKey);
	alert('help');
}

buttonOne.addEventlIstener('mouseenter', myFuncTwo);

function myFuncTwo(event) {
	console.log(event.type);
}


function myFuncThree(eve) {
	alert('you are awesome');
}


/*
 * predeifned events: click mouseup
 */