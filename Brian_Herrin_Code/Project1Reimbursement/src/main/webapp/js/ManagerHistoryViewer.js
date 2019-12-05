window.onload = function(){
	document.getElementById("knockJokeSubmit").addEventListener('click', get_knock_joke_of_the_day);
}

function test_Alert(){
	alert("Hello!");
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

function setKnockValues(joke){
	console.log(joke);
	alert(joke.contents.jokes.text.value);
	//document.getElementById("knockJokeName").innerHTML = joke.jokes.text;
}

/*
// Find a <table> element with id="myTable":
var table = document.getElementById("myTable");

// Create an empty <tr> element and add it to the 1st position of the table:
var row = table.insertRow(0);

// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
var cell1 = row.insertCell(0);
var cell2 = row.insertCell(1);

// Add some text to the new cells:
cell1.innerHTML = "NEW CELL1";
cell2.innerHTML = "NEW CELL2"; 
*/
