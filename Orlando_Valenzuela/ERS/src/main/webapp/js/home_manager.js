/**
 * 
 */

window.onload = function(){
	getTickets();
}

function getTickets(){
	let xhttp = new XMLHttpRequest();
		
	xhttp.open("GET", 'http://localhost:8080/ERS/html/manager.do', true);
	xhttp.send();	
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let tickets = JSON.parse(xhttp.responseText);
			
			setValues(tickets);
		}
	}

}

function setValues(tickets){

	var tBody = document.querySelector("#myTable tbody");
	
	addDataToTbody(tBody, tickets);
}

function addDataToTbody(nl, tickets) { 
	
	tickets.forEach((d,i)=>{ 
  
		  var tr = nl.insertRow(i);
		 
	      var Id = tr.insertCell(0);
	      Id.hidden = true;
	      Id.innerHTML = d["id"];
	      
	      var Name = tr.insertCell(1);
	      Name.innerHTML = d["user"].name;
	      
	      var Amount = tr.insertCell(2);
	      Amount.innerHTML = d["amount"];
	      
	      var Submit = tr.insertCell(3);
	      var date = new Date(d["submit"]);
	      Submit.innerHTML = date.toDateString();
	      
	      var Description = tr.insertCell(4);
	      Description.innerHTML = d["description"];
	      
//	      var Receipt = tr.insertCell(5);
//	      Receipt.hidden = true;
//	      Receipt.innerHTML = d["receipt"];
	      
	      var Type = tr.insertCell(5);
	      Type.innerHTML = d["type"].type;
	      
	      var Status = tr.insertCell(6);
	      Status.innerHTML = d["status"].status;
	      
	      var Approve = tr.insertCell(7);
	      var buttonApprove = document.createElement('input');
	      buttonApprove.setAttribute('type', 'button');
	      buttonApprove.setAttribute('value', 'Approve');
	      buttonApprove.setAttribute('onclick', 'approveTicket(this)');
	      Approve.appendChild(buttonApprove);
	      
	      var Deny = tr.insertCell(8);
	      var buttonDeny = document.createElement('input');
	      buttonDeny.setAttribute('type', 'button');
	      buttonDeny.setAttribute('value', 'Deny');
          buttonDeny.setAttribute('onclick', 'denyTicket(this)');
	      Deny.appendChild(buttonDeny);
	       
	       if (d["status"].status != "PENDING"){   
	    	   buttonDeny.disabled = true;
	    	   buttonApprove.disabled = true;   
	       }
	 
	      nl.appendChild(tr);
   
	});    
	
}
function myFunction() {
	  var input, filter, table, tr, td, i, txtValue;
	  
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.querySelector("#myTable tbody");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[6];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}

function denyTicket(element){
	
	var approve = element.parentNode.previousSibling.firstChild;
	var id =   element.parentNode.parentNode.firstChild.innerText; 
	var status = element.parentNode.previousSibling.previousSibling;
	var value = 'DENIED';
		
	managerAction("id=" + id + "&value=" + "DENIED", element, approve, status, value );	
	
}

function approveTicket(element){
	
	var deny = element.parentNode.nextSibling.firstChild;
	var id =   element.parentNode.parentNode.firstChild.innerText;
	
	var status = element.parentNode.previousSibling;
	var value = 'APPROVED';
	
	managerAction("id=" + id + "&value=" + "APPROVED", element, deny, status, value );	
}

function managerAction(action, element1, element2, status, value ){
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("POST", 'http://localhost:8080/ERS/html/manager_action.do', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(action);	
		
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			
			element1.disabled = true;
			element2.disabled = true;
			status.innerText = value;

		}
	}
}

