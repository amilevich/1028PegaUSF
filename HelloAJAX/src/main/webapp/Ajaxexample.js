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
	document.getElementById("pokemonSubmit").addEventListener('click', getPokemon);
	console.log("set the listener")
	//step one if the user clicks the button
}

function getPokemon(){
	//getting the id/field value
	let pokemonId = document.getElementById('pokemonId').value;
	//create an XMLHttpRequest object to allow us to make
	//requests and get data back
	let xhttp = new XMLHttpRequest(); //step two
	xhttp.onreadystatechange = function(){
		/*
		 * The readystate property holds the status of the 
		 * XMLHttpRequest
		 * 0 - request not initialized
		 * 1 - server connection established
		 * 2 - request received
		 * 3 - processing request
		 * 4 - request is finished and response is ready
		 */
		if(xhttp.readyState == 4 && xhttp.status == 200){
		//200 HTTP status code means "OK" or success
			let pokemon = JSON.parse(xhttp.responseText);
			//if steps 4 and 5 are successful, we get our
			//pokemon object and we parse it into JSON
			console.log(pokemon);
			setValues(pokemon);
			//function defined below
		}
	}
	//create a connection (method, url, boolean asych or not)
	xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon/' + pokemonId, true);
	xhttp.send(); //step three
}

function setValues(pokemon){
	//step six, seven: JS not only reads it but also utilizes
	//DOM manipulation
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	let pokemonImgElement = document.getElementById("pokemonImg");
	pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
	pokemonImgElement.setAttribute("alt", pokemon.name);
}

