/**
 * 
 */

/**
 * 
 */

window.onload = function() {
	document.getElementById('countrySubmit').addEventListener('click',
			getCountry);

	console.log("hello2");
}
console.log("hello");

function getCountry() {
	let country = document.getElementById('countryId').value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		console.log("hello6");
		console.log(xhttp.readyState);
		console.log(xhttp.status);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let country2 = JSON.parse(xhttp.responseText);
			console.log("hello5");
			
			console.log(country2);
			setValues(country2);
		}
	}
	xhttp.open("GET", 'https://restcountries.eu/rest/v2/alpha/' + country,true);
	xhttp.send();

 }

function setValues(country2) {
	document.getElementById("countryName").innerHTML = country2.name;
	document.getElementById("countryCurrency").innerHTML = country2.currencies[0].name;
	document.getElementById("countryLanguage").innerHTML = country2.languages[0].name;
	document.getElementById("countryCapitol").innerHTML = country2.capital;
	document.getElementById("countryRegion").innerHTML = country2.region;
	document.getElementById("countryCallCode").innerHTML = country2.callingCodes;

	console.log("hello4");
}
