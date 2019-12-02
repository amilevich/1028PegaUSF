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
