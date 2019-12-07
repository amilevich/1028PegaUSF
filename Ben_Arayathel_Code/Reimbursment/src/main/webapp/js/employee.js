window.onload = function(){
    document.getElementById("but").addEventListener("click",UploadTicket);
    console.log("set the listener");

//    var buttons = document.getElementsByClassName("btn btn-primary");
//
//    for(var i =0;i<buttons.length;i++){
//
//        buttons[i].addEventListener("click",this.StatusTicket);
//
//    }
//    
//    
//    console.log("set the listener");

    // this.document.getElementsByClassName("but2").addEventListener("click",StatusTicket);
    // this.console.log("happy days");
}

function UploadTicket(e){
	
	
	let ticketobj = {
			price: document.getElementById("price").value,
			ttype: document.getElementById("ticketType").value,
			desc: document.getElementById("description").value
	}
  
    let xhttp = new XMLHttpRequest();
	
    xhttp.onreadystatechange = function(){
    	
		if(xhttp.readyState == 4 && xhttp.status == 200){
			
			console.log(xhttp.response);
    		let ticket = JSON.parse(xhttp.response);
    		
    		
		}
    	
    }
	xhttp.open("POST", 'http://localhost:9001/Reimbursment/html/RegisterTicket.do', true);
	
	xhttp.setRequestHeader("data","json");
	let tet = JSON.stringify(ticketobj);
	xhttp.send(tet);
	console.log(ticket);
	
	
	
	
    var ticketID = 7;
    var IDh = ticketID;
    var costh = ticketobj.price;
    var typeh = ticketobj.ttype;
    var timestamph = "12/11/13";
    var emailh = "asdf@asdf.com";
    var descriptionh = ticketobj.desc;

    var table = document.getElementById("tickets-table")
    var row = table.insertRow(1);
    row.setAttribute("id",ticketID);
    row.setAttribute("class","table-warning");
    var status = row.insertCell(0);
    status.setAttribute("class","status");
    status.innerText = "Pending";
    var ID = row.insertCell(1);
    ID.setAttribute("class","ID");
    ID.innerText = IDh;
    var cost = row.insertCell(2);
    cost.setAttribute("class","cost");
    cost.innerText = costh;
    var type = row.insertCell(3);
    type.setAttribute("class","type");
    type.innerText = typeh;
    var timestamp = row.insertCell(4);
    timestamp.setAttribute("class","timestamp");
    timestamp.innerText = timestamph;
    var email = row.insertCell(5);
    email.setAttribute("class","email");
    email.innerText = emailh;
    var description = row.insertCell(6);
    description.setAttribute("class","description");
    description.innerText = descriptionh;

}

function StatusTicket(){

    var id = this.parentNode.parentNode.parentNode.getAttribute("id");
    
    var statush = this.parentNode.childNodes[1].value;
    var tableRow = document.getElementById(id);
    var status = document.getElementById(id).getElementsByTagName("td")[0];

    if(statush === "approve"){
        status.innerText = "Approved";
        tableRow.setAttribute("class", "table-success");
    }else {
        status.innerText = "Denied";
        tableRow.setAttribute("class", "table-danger");
    }

    console.log("button press");
}