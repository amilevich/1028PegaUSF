window.onload = function(){
	//document.getElementById("LoginSubmit").addEventListener('click', getQuery);
}

function getQuery() {
	Query.setUsername(document.getElementById("txtUsernameQuery").value);
	Query.setPassword(document.getElementById("txtPasswordQuery").value);
	alert("Recieved, " + Query.getUsername() + " " + Query.getPassword());
	
	return Query;
}

var Query = (function(){
	var username = "";
	var pswd = "";
	return {
		getUsername : function (){
			return username;
		},
		setUsername : function (newUsername){
			username = newUsername;
		},
		getPassword : function (){
			return pswd;
		},
		setPassword : function (newPassword){
			pswd = newPassword;
		}
	}
}());