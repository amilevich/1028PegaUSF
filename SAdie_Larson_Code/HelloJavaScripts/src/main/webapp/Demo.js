/**
 * 
 */

// JavaScript
/*
 * is a cross platform, object oriented scripting language used to make webpages
 * interactive and /or functional. - dynamic language - loosely typed
 */

console.log("Hey, guyz");
/*
 * DATA TYPES: 9 STRING BOOLEAN NUMBER NULL - explicitly saying equal to null
 * UNDEFINED - if no value to variable declaration ARRAY OBJECT FUNCTION - no
 * methods in javaScript SYMBOL - ECMASCript 6, ES6 introduced symbol as a data
 * type. It is a unique and immutable primitive value, it may be sued as the key
 * for an obejct
 */

var x = 5;
let y = 10;
const z = "hello";
// var, let, const are keywords for declarations
// let and cosnt were introduced in ES6

// const - immutable, value cannot be changed, "final" in Java

/*
 * SCOPES GLOBAL - outside of any declarations LOCAL - functions/objects BLOCK -
 * within conditionals (introduced in ES6)
 */

/*
 * var - global or local let - all scopes including block const - same as 'let'
 * but immutable
 */
let a; // undefined
let b = true; // boolean
let c = null; // typeof thought it was an object

// undefined variable:
// those that are not initialized nor given a type but are declared
// when you try to reference an undefined variable you get undefined

// undeclared variables:
// d; // will give an uncaught reference error
// do not exist in the program and are not declared
// if you try to reference it,
// runtime error


let numFive = 5;
// double eqals checks for only value
// triple equal checks for both value and type (AKA strictly equals)

var obj = {};

let superHero = {
	name : 'Superman',
	ability : 'flying',
	'Kailey' : 'pickles'
}

// console.log(superHero.name);
// console.log(superHero.ability);
// console.log(superHero.Kailey);

// superHero.secretIdenitity = 'Clark Kent';
// console.log(superHero.secretIdenitity);
// console.log(superHero);
//
// delete superHero.Kailey;
// console.log(superHero);
// JavaScript is a DYNAMIC language because you can add/delete
// new fields into objects at runtime
// loosely typed - we do not have to declare data types and we can switch
// datatypes at runtime

let num1 = 10;
let num2 = num1;
num1 = 25;
// console.log(num1);
// console.log(num2);
// variables are passed by value
// so num1 is 25 and num2 is 10

let obj1 = {
	value : 10
};
let num3 = obj1.value;
obj1.value = 50;
console.log(obj1);
console.log(num3);
// objects are still passed by value
// will have 50 and 10

let arrayOfCharacters = [
	['The Hulk', 36, "being cool"],
	['catwoman','being awesome with cat ears']
];
// console.log(arrayOfCharacters[1]); //catwoman being awesome
// console.log(arrayOfCharacters[0][1]);
// console.log(arrayOfCharacters[0]);
arrayOfCharacters[10] = 'Archer';
// console.log(arrayOfCharacters);

// Template Literals (backticks)
// introduced in ES6

let tempNum = 42;
// let longString = 'Printing longString' + tempum + ' and nw more stuff';
let longString = `Printing longString with variable: ${tempNum}
	
	an now i want to do more stuff
	and more
	${arrayOfCharacters}
	wow even more ;)`;
// console.log(longString);

function printStuff(){
	console.log("stuff");
}

// printStuff(); //can be called anywhere in code (even before the function was
// created)
// HOISTING - all declarations get moved to the top of their scope: variables,
// objects, functions, arrays

let g = 7; // let g is hoisted but the value is still here at this line

// Falsy and Truthy Values
/*
 * - inherently all numbers are true, 0 is false - strings are inherently true,
 * empty string is false - false is false, true is true - null is false -
 * undefined is false - NaN is false
 * 
 * you can use any value in a boolean context and it is assigned either a true
 * or false
 */

function checkTruthy(input){
	console.log(`input =${input} and is type of: ${typeof(input)} and 
	input is ${!!input}`) // !! checks whether inherently true or false
};

let k;
checkTruthy('');
checkTruthy(74);
checkTruthy(-10);
checkTruthy(null);
checkTruthy([]);
checkTruthy({});
checkTruthy(k);
checkTruthy(0);

// NaN
/*
 * NOT a keyword or a data type a property of the global object is Nan -
 * function returns true if variable is not a type of number
 * 
 * 1. division of zero by zero 2. division by infinity by infinity 3.
 * multiplication of infinity by 0 4. convert a non-numeric string or undefined
 * into a number
 */

// loops
let cakes = ['chocolate (lava) cake',, 'birthday cake', 'carrot cake', 'vanilla cake', 'cheesecake', 'oreo cheesecake cake']
for(let i in cakes){
// console.log(cakes[i]);
}

// ES5
// var func = function(x,y){
// return x*y;
// };

// ES6
let func = (x,y) => x*y;

console.log(func(5,4));

// Anonymous Functions
// a function without a name
let funcTwo = function(){
console.log("in function");
};

// callback functions:
// we are able to pass in a function as a parameter to another function
// guarantees execution order
function doHw(subject, callBackFunc){
	alert(`starting my ${subject} homework.`);
	callBackFunc();
};

let alertFinished = function(){
	alert(`finished my hw`);
};

// doHw('javascript', alertFinished);

// Self invoking functions
// these functions clal themselves
// they will execute automatically if the expression is followed by parenthesis
// - IIFE
// IIFE - Immediately Invokable Functions Expression

let funcFours = function(){
	console.log('inside IIFE');
}();

// Encapsulation:
/*
 * Closures: implementation of encapsulation in javascript A closure is an inner
 * function that has access to its outer function's variables The closure
 * function has three scope chains: 1. it has access to its own scope 2. it has
 * access to the outer function's variables 3. it has access to global variables
 */

let funcFive = (function(){
	let num = 0;
	return function(){
	return num +=1;
	};
});

//console.log(funcFive());
//console.log(num); //num is not global it is local - you CANNOT directly call on it

//Inheritance:
/*
In javascript, when it comes to inheritance, it only has one construct: objects.
Each object as a private property which holds a link to another object called its prototype
The prototype has a prototype of is own and so on until an object is reached with null as its prototype
*/

let f = function(){
	this.a = 1;
	this.b = 2;
};

let o = new f(); //making an object o of type f
f.prototype.b = 3;
f.prototype.c = 4;

let p = f.prototype;
console.log(p.b);