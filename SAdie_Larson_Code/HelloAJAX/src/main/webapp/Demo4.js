/**
 * 
 */

/*
 * AJAX: Asynchronous JavaScript and XML
 * 
 * Asynchronous: we are able to make multiple requests at one time without
 * waiting for the other request to complete This allows the web page to be
 * responsive
 * 
 * XML: data format, universal - not human readable
 * 
 * JSON: JavaScript Object notation - machine and human readable
 * 
 * HTTP: Hyper Text Transfer Protocol
 * 
 * AJAX: a technique for accessing web servers from a web page asynchronously
 * consists of browser built-in XMLHttpReuest object (requests data from the web
 * server) JavaScript HTML DOM (to display or use the data)
 * 
 * How does AJAX work? 1. an event has to occur in a web page (button is
 * clicked, page is loaded, etc) 2. an XMLHttpRequest OBject is created by
 * JavaScript 3. The XMLHttpReuest object sends a request to a web server 4. the
 * serve processes the request 5. The server sends response back to the web page
 * 6. The response is read by JavaScript 7. A proper action (like page update or
 * info displayed) is performed by JavaScript
 * 
 * 
 */

window.onload = function() {
	document.getElementById('pokemonSubmit').addEventListener('click',
			getPokemon);
	// if user clicks the button
}

function getPokemon() {
	// get the id/field value
	let pokemonId = document.getElementById('pokemonId').value
	// create XMLHttpRequestobject to allow us to make requests and get data
	// back
	let xhttp = new XMLHttpRequest(); // step 2
	xhttp.onreadystatechange = function() {
		/*
		 * The ready state property holds the status of the XMLHttpRequest 0 -
		 * request not initialized 1 - server connection established 2- request
		 * received 3 - processing request 4 - request is finished and response
		 * is ready
		 */

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			// 200 HTTP status code means "OK" or success
			let pokemon = JSON.parse(xhttp.responseText);
			console.log(pokemon);
			// if steps 4 and 5 are successful, we get our
			// pokemon object and we parse it into JSON
			setValues(pokemon);
		}
		// create a connection (method, urcl, boolean asych or not
	}
	xhttp.open("GET", 'https://pokeapi.co/api/v2/pokemon/' + pokemonId,
			true);
	xhttp.send();

}

function setValues(pokemon) {
	// step 6 and 7: JS not only reads it but it also utilizes DOM manipulation
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	let pokemonImgElement = document.getElementById("pokemonImg");
	pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
	pokemonImgElement.setAttribute("alt", pokemon.name);
}
