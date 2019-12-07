window.onload = function(){
    document.getElementById("but").addEventListener("click",UploadTicket);
    console.log("set the listener");

    var buttons = document.getElementsByClassName("btn btn-primary");

    for(var i =0;i<buttons.length;i++){

        buttons[i].addEventListener("click",this.StatusTicket);

    }
    
    
    console.log("set the listener");

    // this.document.getElementsByClassName("but2").addEventListener("click",StatusTicket);
    // this.console.log("happy days");
}

function UploadTicket(){

    var ticketID = 3;
    var IDh = ticketID;
    var costh = 100;
    var typeh = "LODGE";
    var timestamph = "12/11/13"
    var emailh = "asdf@asdf.com"
    var descriptionh = "blah blah blah"

    var table = document.getElementById("tickets-table")
    var row = table.insertRow(1);
    row.setAttribute("id",ticketID);
    row.setAttribute("class","table-warning");
    var status = row.insertCell(0);
    status.setAttribute("class","status");
    status.innerHTML = '<form method = "POST" class="statusD" action = "SetStatus.do"><select name="status"><option value = "approve">Approve</option><option value = "deny">Deny</option></select><button type="button" class="btn btn-primary">SUBMIT!!</button></form>'
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

    var buttons = document.getElementsByClassName("btn btn-primary");

    for(var i =0;i<buttons.length;i++){
        console.log("i")
        buttons[i].addEventListener("click",this.StatusTicket);

    }



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