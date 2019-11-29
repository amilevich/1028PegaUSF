/**
 * 
 */

let buttonOne = document.getElementById('para1');
buttonOne.addEventListener('mouseenter', myFunc);

function myFunc() {
	alert('Go out and explore!!!!!');
}

let buttonTwo = document.getElementById('wander');
buttonTwo.addEventListener('mouseenter', myFunc3);

function myFunc3() {
	document.getElementById("wander").src = "https://www.globosurfer.com/wp-content/uploads/2018/06/How_to_Reef_a_Sailboat.jpg";
}


function myFuncTwo() {
	document.getElementById("wander").src = "https://www.metoffice.gov.uk/binaries/content/gallery/metofficegovuk/hero-images/weather/cloud/cumulonimbus-2.jpg";
}

