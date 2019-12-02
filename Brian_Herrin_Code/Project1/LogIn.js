/**
 * 
 */

/*
 * AJAX - Asynchronous JavaScript and XML
 * 
 *  Asynchronous - we are able to make multiple requests
 *  at one time without waiting for the other request
 *  to complete.
 *  This allows the web page to be responsive.
 *  
 *  XML - data format, universal
 *  JSON - JavaScript Object Notation -> machine and human readable
 *  
 *  AJAX - a technique for accessing web servers from
 *  a web page asynchronously. 
 *  
 *  AJAX consists of:
 *  - browser built-in XMLHttpRequest object (requests data from the web
 *  server)
 *  - JavaScript
 *  - HTML DOM (to display or use the data)
 *  
 *  How does AJAX work?
 *  1) An event occurs in a web page (button is clicked, page is loaded,
 *  etc)
 *  2) An XMLHttpRequest object is created by JavaScript
 *  3) The XMLHttpRequest object sends a request to a web server
 *  4) The server process the request
 *  5) The server sends a response back to the web page
 *  6) The response is read by JavaScript
 *  7) A proper action (like page update or info displayed) is 
 *  performed by JavaScript
 *  
 */

/**
 * 
 */

//JavaScript
/*
 is cross-platform, object-oriented scripting language used to make
 webpages interactive and/or functional.
 - dynamic language
 - loosely typed
*/

//console.log("Hey, guyz");

/* DATA TYPES
 * STRING
 * NUMBER
 * BOOLEAN
 * NULL
 * UNDEFINED
 * ARRAY
 * OBJECT
 * FUNCTION
 * SYMBOL - ECMAScript 6, ES6, introduced Symbol as a data type.
 * It is a unique and immutable primitive value, it
 * may be used as the key for an Object
 */

var x = 5;
let y = 10;
const z = "hello";
//var, let, const are keywords for declarations
//let and const were introduced in ES6

//const - immutable, value cannot be changed, "final" in java

/*
 * SCOPES
 * GLOBAL - outside of any declarations
 * LOCAL - functions/objects
 * BLOCK - within conditionals (introduced in ES6)
 */

/*
 * var - global or local
 * let- all scopes including block
 * const - same as let but immutable
 */

let a;
let b = true;
let c = null;
a = 5; //number
a = "hello"; //string

//undefined variable
//those that are not initialized nor given a type but are declared
//when you try to reference an undefined variable
//you get "undefined"

//d;
//undeclared variables
//these are the ones that do not exist in the program and are not
//declared (properly)
//if you try to reference it,
//runtime error

let numFive = 5;
// == > checks for only value
// === > checks for both value AND type (aka strictly equals)

var obj = {}; //object

let superHero = {
		name : 'SuperMan',
		ability : 'flying',
		'Kailey': 'pickles'
}
//console.log(superHero.name);
//console.log(superHero.ability);
//console.log(superHero.Kailey);

superHero.secretIdentity = 'Clark Kent';
//console.log(superHero.secretIdentity);
//console.log(superHero);

delete superHero.Kailey;
//console.log(superHero);
// JavaScript is a DYNAMIC language because you can add/delete new
//fields into objects at runtime
//Loosely typed - we do not have to declare data types and
//we can switch data types at runtime

let num1 = 10;
let num2 = num1;
num1 = 25;
//console.log(num1);
//console.log(num2);
//variables are passed by value
//so num1 is 25 and num2 is 10

let obj1 = {
		value : 10
};
let num3 = obj1.value;
obj1.value = 50;
console.log(obj1);
console.log(num3);
//objects are still passed by value
//so 50 and 10

h = 5; //undeclared


let arrayOfCharacters = [
	['The Hulk', 'smashing things', 36],
	['BatWoman', 'being awesome with cat ears']
];
//console.log(arrayOfCharacters[1]);
//console.log(arrayOfCharacters[0][1]);
arrayOfCharacters[10] = 'Archer';
//console.log(arrayOfCharacters);


//Template Literals
//backticks ``
//introduced in ES6

let tempNum = 42;
//let longString = 'Printing longString' + tempNum + ' and now more stuff';
let longString =`Printing longString with variable: ${tempNum}

and now i want to write more stuff

and more stuff and same variable again ${tempNum}

and some more

${arrayOfCharacters}


and maybe a smiley face :)

yes`;

//console.log(longString);
printStuff();

let name = "Victor";
let anotherLongString = `Hello, ${name}`;
//console.log(anotherLongString);

function printStuff(){
	//let g; due to hoisting
	//console.log(typeof(g));
	//console.log("stuff");
	let g = 7;
}

//HOISTING
//all declarations get moved to the top of their scope
//variables, objects, functions, arrays

let g = 7;

//Falsy Values
/*
 * numbers are inherently true, 0 is false
 * strings are inherently true, empty string is false
 * false is false, true is true
 * null is false
 * undefined is false
 * NaN is false
 * 
 * you can use any value in a boolean context and it is 
 * assigned either a true or false
 */

function checkTruthy(input){
	console.log(`input=${input}, and is typeof: ${typeof(input)} and
	input is ${!!input}`)
};
let k;
//checkTruthy('');
//checkTruthy(74);
//checkTruthy(-10);
//checkTruthy(null);
//checkTruthy([]);
//checkTruthy({});
//checkTruthy(k);

//What is NaN?
/*
 * Not a keyword or a data type
 * it is a property of the global object
 * isNaN - function returns true if variable is not a type of number
 * 
 * 1) Division of zero by zero
 * 2) Division infinity by infinity
 * 3) Multiplication infinity by zero
 * 4) Convert a non-numeric string or undefined into a number
 */

//loops
let cakes = ['chocolate (lava) cake', 'birthday cake', 'carrot cake', 'vanilla cake', 'cheesecake', 'oreo cake'];
for(let i in cakes){
	//console.log(cakes[i]);
}

//ES5
var func = function(x,y){
	return x*y;
};

//ES6
//let func = (x,y) => x*y; //fat arrow notation

//Anonymous Functions
// a function without a name

let funcTwo = function(){
	console.log("in function")
};

funcTwo();

//Callback Functions
//simply put: we are able to pass in a function as a parameter to
//another function
//guarantees execution order

function doHomework(subject, callbackFunc){
	alert(`Starting my ${subject} homework.`);
	callbackFunc();
};
let alertFinished = function(){
	alert('Finished my homework');
};
//doHomework('JavaScript', alertFinished);

//Self Invoking Functions
//these functions call themselves
//they will execute automatically if the expression is followed by
// parenthesis
//IIFE - Immediately Invokable Function Expression

let funcFour = function(){
	console.log('inside IIFE');
}();


//Closure
//implementation of encapsulation in JavaScript
/*
 * A closure is an inner function that has access to its outer
 * function's variables
 * The closure function has 3 scope chains:
 * 1) it has access to its own scope
 * 2) it has access to the outer function's variables
 * 3) it has access to global variables
 */

let funcFive = (function(){
	let num = 0;
	return function() {
		return num += 1
	};
});
//console.log(funcFive());
//console.log(num); //num is not global, it is local
//you cannot directly call on it

//Inheritance
//Prototypical Inheritance
/*
 * In JavaScript, when it comes to Inheritance, it only has
 * one construct: objects.
 * Each object has a private property which holds a link to another
 * object called its prototype.
 * The prototype has a prototype of its own and so on until
 * an object is reached with null as its prototype.
 * 
 */

let f = function(){
	this.a = 1;
	this.b = 2;
}
let o = new f(); //making an object o of type f
f.prototype.b = 3;
f.prototype.c = 4;
let p = f.prototype;
console.log(p.b);
console.log(o.b);


window.onload = function(){
	document.getElementById("animalJokeSubmit").addEventListener('click', get_animal_joke_of_the_day);
	document.getElementById("knockJokeSubmit").addEventListener('click', get_knock_joke_of_the_day);
	document.getElementById("blondeJokeSubmit").addEventListener('click', get_blonde_joke_of_the_day);
}

function test_Alert(){
	alert("Hello!");
}

function get_animal_joke_of_the_day() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	     // Access the result here
		 let joke = JSON.parse(xhttp.responseText);
		 alert(joke);
		 //console.log(joke);
	     setAnimalValues(joke);
	 }
    };
    xhttp.open("GET", "https://api.jokes.one/jod/category=animal", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("X-JokesOne-Api-Secret", "YOUR API HERE");
    xhttp.send();
}

function get_knock_joke_of_the_day() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	     // Access the result here
		 let joke = JSON.parse(xhttp.responseText);
		 alert(joke);
		 //console.log(joke);
	     setKnockValues(joke);
	 }
    };
    xhttp.open("GET", "https://api.jokes.one/jod?category=knock-knock", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("X-JokesOne-Api-Secret", "YOUR API HERE");
    xhttp.send();
}

function get_blonde_joke_of_the_day() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	     // Access the result here
		 let joke = JSON.parse(xhttp.responseText);
		 alert(joke);
		 //console.log(joke);
	     setBlondeValues(joke);
	 }
    };
    xhttp.open("GET", "https://api.jokes.one/jod?category=blonde", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("X-JokesOne-Api-Secret", "YOUR API HERE");
    xhttp.send();
}

function setAnimalValues(joke){
	console.log(joke);
	alert(joke.contents.jokes.text.value);
	//document.getElementById("animalJokeName").innerHTML = joke.jokes.text;
}
function setKnockValues(joke){
	console.log(joke);
	alert(joke.contents.jokes.text.value);
	//document.getElementById("knockJokeName").innerHTML = joke.jokes.text;
}
function setBlondeValues(joke){
	console.log(joke);
	alert(joke.contents.jokes.text.value);
	//document.getElementById("blondeJokeName").innerHTML = joke.jokes.text;
}
