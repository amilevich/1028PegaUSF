window.onload = function(){
	getReimbursementInfo();
}

function getReimbursementInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let reimbursements = JSON.parse(xhttp.responseText);
			setValues(reimbursements);
		}
	}
	xhttp.open("GET", 'http://localhost:8080/Project1Reimbursement/html/EmpHistTable.do', true);
	xhttp.send();
}
function setValues(reimbursement){
	document.getElementById("EmpHistoryViewerTable").innerHTML = makeEmployeeHistoryTable(document.getElementById("EmpHistoryViewerTable"), reimbursements);
}
function makeEmployeeHistoryTable(table, reimbursements){
	for(i=0; i < reimbursements.results.length; i++){
		row = getRowEmployeeHistoryTable(table, reimbursements[i]);
		table.Rows.Add(row);
	}
	return table.innerHTML;
}
function getRowEmployeeHistoryTable(table, reimbursement){
	var row = new HtmlTableRow();
	var cell0 = new HtmlTableCell(); cell0 = row.insertCell(0);
	var cell1 = new HtmlTableCell(); cell1 = row.insertCell(1);
	var cell2 = new HtmlTableCell(); cell2 = row.insertCell(2);
	var cell3 = new HtmlTableCell(); cell3 = row.insertCell(3);
	var cell4 = new HtmlTableCell(); cell4 = row.insertCell(4);
	var cell5 = new HtmlTableCell(); cell5 = row.insertCell(5);
	var cell6 = new HtmlTableCell(); cell6 = row.insertCell(6);
	cell0.innerHTML = reimbursement.amount; // $ Amount
	cell1.innerHTML = reimbursement.statusId; // Status
	cell2.innerHTML = reimbursement.typeId; // Type
	cell3.innerHTML = reimbursement.description; // Description
	cell4.innerHTML = reimbursement.receipt; // Addendum"
	cell5.innerHTML = reimbursement.dateSubmitted; // Time Submitted
	cell6.innerHTML = reimbursement.dateResolved; // Time Resolved
	row.Cells.Add(cell0);
	row.Cells.Add(cell1);
	row.Cells.Add(cell2);
	row.Cells.Add(cell3);
	row.Cells.Add(cell4);
	row.Cells.Add(cell5);
	row.Cells.Add(cell6);
	
	return row;
}
/*
function makeEmployeeHistoryTable(table, employeeReimbursementSet){
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