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
