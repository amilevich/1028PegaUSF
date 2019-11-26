/**
 * 
 */

//GET ELEMENT BY ID
let paraTwo = document.getElementById('para2');
paraTwo.innerText = 'hey, look at me';

let paraThree = document.getElementById('para3');
paraThree.innerHTML = '<b><i>Yay to a three day week</i></b>';

//GET ELEMENTS BY CLASS
let hders = document.getElementsByClassName('headers');
hders[1].innerText = "Awesome";
hders[1].addEventListener('click', myFuncThree)

function myFuncThree(){
	alert('you are awesome');
}

//get elements by tag name, by children, query selector, etc

//Event listeners
let buttonOne = document.getElementById('button');
buttonOne.addEventListener('click', myFunc);
//pass in the event and the action that will execute when this
//event is triggered

function myFunc(eve){
	//console.log(eve.altKey);
	alert('help');
}

buttonOne.addEventListener('mouseenter', myFuncTwo);
function myFuncTwo(event){
	console.log(event.type);
}



/*
 * Predefined events:
 * click
 * mouseup
 * mousehover
 * mouseover
 * change
 * onclick
 * mouseenter
 * mouseleave
 * ...
 */


