
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

// var error = <%=request.getAttribute("error")%>;
// alert(error);
// var req = new XMLHttpRequest();
// req.open('GET', document.location, false);
// req.send(null);
// var headers = req.getAllResponseHeaders().toLowerCase();
// alert(headers);

function validate()
{

	if(document.signup.password.value != document.signup.cpassword.value)
	{
		document.signup.cpassword.style.backgroundColor="red";
		document.signup.cpassword.focus();
		return false;
	}
	else
	{
		return true;
	}
}


