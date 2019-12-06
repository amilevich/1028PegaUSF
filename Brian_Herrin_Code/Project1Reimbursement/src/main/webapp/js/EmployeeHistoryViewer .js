window.onload = function(){
	let table = document.getElementById("EmpHistoryViewerTable");
	getEmployeeReimbursements();
}

function getEmployeeReimbursements() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	     // Access the result here
		 let data = JSON.parse(xhttp.responseText);
		 alert(data);
		 //console.log(data);
	     setKnockValues(data);
	 }
    };
    xhttp.open("GET", "http://localhost:8080/Project1Reimbursement/html/EmpHistViewer.do", true);
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
window.onload = function(){
	getPetInfo();
}

function getPetInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let pet = JSON.parse(xhttp.responseText);
			setValues(pet);
		}
	}
	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/Home.do', true);
	xhttp.send();
}

function setValues(pet){
	document.getElementById("name").innerHTML = "Pet's name is " + pet.name;
	document.getElementById("type").innerHTML = "Pet's type is " + pet.type;
	
}
*/
/*
function addRowEmployeeHistoryTable(currentRow){
	// Find a <table> element with id="myTable":
	var table = document.getElementById("EmpHistoryViewerTable");
	// Create an empty <tr> element and add it to the 1st position of the table:
	var row = table.insertRow(currentRow);
	// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
	var cell0 = row.insertCell(0);
	var cell1 = row.insertCell(1);
	var cell2 = row.insertCell(2);
	var cell3 = row.insertCell(3);
	var cell4 = row.insertCell(4);
	var cell5 = row.insertCell(5);
	var cell6 = row.insertCell(6);
	// Add some text to the new cells:
	cell0.innerHTML = "$ Amount";
	cell1.innerHTML = "Status";
	cell2.innerHTML = "Type";
	cell3.innerHTML = "Description"; 
	cell4.innerHTML = "Addendum";
	cell5.innerHTML = "Time Submitted"; 
	cell6.innerHTML = "Time Resolved";
}
*/
/*
function makeEmployeeHistoryTable(employeeReimbursementSet){
var table = document.getElementById("EmpHistoryViewerTable");
HtmlTableRow row;
HtmlTableCell cell;

foreach(var item in employeeReimbursementSet) {
    row = new HtmlTableRow();
	foreach(var familyName in item.familyName) {
        cell = new HtmlTableCell();
        cell.InnerText = item.familyName.ToString();
        row.Cells.Add(cell);
    }
    foreach (var givenName in item.givenName) {
        cell = new HtmlTableCell();
        cell.InnerText = item.givenName.ToString();
        row.Cells.Add(cell);
    }

    table.Rows.Add(row);
}
this.Controls.Add(table);
}
 */