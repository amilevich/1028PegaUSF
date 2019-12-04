window.onload = function(){
	document.getElementById("LoginSubmit").addEventListener('click', getQuery);
}
// Noticed that getQuery ran twice
var running = false,
    div = document.getElementById('response'),
    limit = 5,
    current = 0;

$('#trigger').click(function () {
    if (running === true) {
        alert('Error: The cycle was running. Aborting.');
        running = false;
        return false;
    }
    running = true;
    var end = setInterval(function () {
        if (current >= limit || running == false) {
            running = false;
            clearInterval(end);
        }
        div.innerHTML += 'Hello World<br />';
        current++;
    }, 500);

});

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