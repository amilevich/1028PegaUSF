/**
 * 
 */

window.onload = function() {
    getRequests();
}

function getRequests() {
	// this object allows us to make requests and get data back
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
			
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let list = JSON.parse(xhttp.responseText);
			// JSON parse turns it into an object
            setValues(list);
        }
    }
	// create a connection (method, url, boolean asynch or not)
    xhttp.open("GET", "/Project1/html/LoadExpensesById.do", true);
    xhttp.send();
}
/*
 * Used to populate the table
 */
function setValues(list) {
    
    let table = document.getElementById("reimbtable");
    table.innerHTML = `<tr>
                       <th>Ticket Id</th>
                       <th>Expense Type</th>
                       <th>Amount</th>
                       <th>Date Submitted</th>
                       <th>Date Resolved</th>
                       <th>Reimbursement Status</th>
                       <th>Description</th>
                       </tr>`
    
    for (r in list) {
        let trNewRow = document.createElement("tr");
        let tdType = document.createElement("td");
        let tdAmount = document.createElement("td");
        let tdSubmitDate = document.createElement("td");
        let tdResolveDate = document.createElement("td");
        let tdStatus = document.createElement("td");
        let tdDescription = document.createElement("td");
        let tdTicketId = document.createElement("td");
        
        // Ticket Number
        tdTicketId.innerHTML = list[r].ticketId;
        // Type
        switch (list[r].type) {
        case "LODGING":
        	tdType.innerHTML = "Lodging";
            break;
        case "TRAVEL":
        	tdType.innerHTML = "Travel";
            break;
        case "FOOD":
        	tdType.innerHTML = "Food";
            break;
        case "OTHER":
        	tdType.innerHTML = "Other";
            break;
        }
        // Amount
        tdAmount.innerHTML = "$" + list[r].amount;
        // Submit Date
        tdSubmitDate.innerHTML = list[r].submitted;
        // Resolve Date
        tdResolveDate.innerHTML = list[r].resolved;
        // Status
        switch (list[r].status) {
        case "APPROVED":
        	tdStatus.innerHTML = "Approved";
            break;
        case "DENIED":
        	tdStatus.innerHTML = "<span style='color:#FF0000'> Denied </span>";
            break;
        case "PENDING":
        	tdStatus.innerHTML = "Pending";
            break;
        }
        // Description
        tdDescription.innerHTML = list[r].description;
 
        //add to the row
        trNewRow.appendChild(tdTicketId);
        trNewRow.appendChild(tdType);
        trNewRow.appendChild(tdAmount);
        trNewRow.appendChild(tdSubmitDate);
        trNewRow.appendChild(tdResolveDate);
        trNewRow.appendChild(tdStatus);
        trNewRow.appendChild(tdDescription);

        //add row to the table
        table.appendChild(trNewRow);
    }
}