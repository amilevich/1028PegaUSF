

/**
 * 
 */




// window.onload = function(){
// 	document.getElementById("loginSubmit").addEventListener('click', getData);
// }


console.log("abc");

var base64str;



let ticketsDiv = document.getElementById("ticketsDiv");

let profileSrc= "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg";

function createTickets(profileSrc, firstName, secondName, amount, category, key){
    //this div will hold all the info
    var div = document.createElement("div");
    div.setAttribute("class", "individualTicketDiv");

    var imagediv = document.createElement("div");
    var image= document.createElement("img");
    image.src= profileSrc;
    image.style.width="200px";
    image.style.height="200px";

    image.setAttribute("id", "image");
    imagediv.append(image);
    
    var descDiv = document.createElement("div");

    var pName = document.createElement("p");
    pName.innerText= firstName + " "+ secondName;
    var pAmount = document.createElement("p");
    pAmount.innerText= "Amoount: " + amount;
    var pType = document.createElement("p");
    pType.innerText= "Category: "+ category;
    var acceptButton = document.createElement("button");
    
    acceptButton.innerText= "Accept";
    acceptButton.setAttribute("class", "acceptButton");
    acceptButton.setAttribute("data-id", key);

    var denyButton = document.createElement("button");
    denyButton.innerText= "Deny";
    denyButton.setAttribute("class", "denyButton");
    denyButton.setAttribute("data-number", key);

    var demoBtn = document.createElement("button");
    demoBtn.setAttribute("class", "btn btn-primary");
    demoBtn.setAttribute("data-toggle", "modal");
    demoBtn.setAttribute("data-target", "#exampleModal");
    demoBtn.innerText= "show receipt";

    var receiptImage = document.getElementById("imageReceipt");
    receiptImage.src=profileSrc;
    receiptImage.height="200";
    receiptImage.width="200";


    descDiv.append(pName);
    descDiv.append(pAmount);
    descDiv.append(pType);
    descDiv.append(acceptButton);
    descDiv.append(denyButton);
    descDiv.append(demoBtn);

    


    div.append(imagediv);
    div.append(descDiv);

    ticketsDiv.append(div);

//     <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
//     Launch demo modal
//   </button>
    
}

//createTickets(profileSrc, "Diwal", "Pyakurel", 7600, "Food", 123);



// document.getElementsByClassName("acceptButton")[0].addEventListener("click", function(){
//     console.log(this);
//     let className = this.getAttribute("class");
//     let test = this.getAttribute("data-id");
    
//     console.log(test);
// })

//document.getElementById("submit").addEventListener("click", function(){
//    console.log("working");
//  
//    //console.log(base64str);
//    console.log(base64str.length);
//})


function getBase64() {
   var file = document.getElementById("imageUpload").files[0];
    var reader  = new FileReader();
    reader.addEventListener("load", function () {
      base64str= reader.result
    }, false);
  
    if (file) {
      reader.readAsDataURL(file);
    }
  }




// function getData(){
	
	
// 	let xhttp = new XMLHttpRequest(); 
// 	xhttp.onreadystatechange = function(){
// 		if(xhttp.readyState == 4 && xhttp.status == 200){
// 			let data= JSON.parse(xhttp.responseText);
// 			console.log(data);
// 		}
// 	}
// 	xhttp.open("GET", "http://localhost:8080/PracticeProject2/users", true);
// 	xhttp.send(); //step three
// }
  


// function getRegestration(e){

//   e.preventDefault();
//   console.log("this was clicked");
//   let firstName = document.getElementById("signUpFirstName").value;
//   let secondName = document.getElementById("signUplastName").value;
//   let email = document.getElementById("signUpEmail").value;
//   let userName = document.getElementById("signUpUserName").value;
//   let password = document.getElementById("signUpPassword").value;
//   let status = "FinanceManager";

//   let toAdd = {
//     firstName: firstName,
//     secondName, secondName,
//     email:email,
//     userName:userName,
//     password: password,
//     status:status
//   };

//   let data= {
//     test: JSON.stringify(toAdd)
//   }

//  // let status = document.getElementById("status").value;
 

//   //let toAdd = "firstName="+firstName+"&secondName="+secondName+"&email="+email+"&userName="+userName+"&password="+password+"&status="+status;

//   let xhttp = new XMLHttpRequest(); 
// 	xhttp.onreadystatechange = function(){
// 		if(xhttp.readyState == 4 && xhttp.status == 200){
//       console.log("sucess");
// 		}
// 	}
//   xhttp.open("POST", "http://localhost:8080/PracticeProject2/Register.do", true);
  
//   xhttp.setRequestHeader("Content-type","application/json");
//   xhttp.setRequestHeader("mime-type","application/json");
// 	xhttp.send(data); //step three

// }




// let signUpbtn = document.getElementById("signupButton");
// signUpbtn.addEventListener("click", getRegestration)

//method="POST" action="Register.do"