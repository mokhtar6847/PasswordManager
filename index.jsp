<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Password Manager</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.2/css/all.min.css'><link rel="stylesheet" href="./style.css">
</head>
<body>
<!-- partial:index.partial.html -->
<h2>Password Manager</h2>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form name="signup" action="signup" onsubmit="return validate()" method="POST">
			<h1>Create Account</h1>
			<br> <br>
			<input type="email" name="email" id="email" placeholder="Enter Email Here!" required><div id=2 style= color:brown></div> 
            <input type="password" name="password" id="password "placeholder="Enter Master Password!" required> <div id=3 style= color:brown></div>
            <input type="password" name="cpassword" id="cpassword" placeholder="Retype Master Password!" required> <div id=4 style= color:brown></div>
			<input type="text" name="question" placeholder="Type a Security Question" required>
            <input type="text" name="answer" placeholder="Type Your Answer" required> <br>
			<button type="submit">Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form name="login" action="login" method="POST">
			<h1>Sign in</h1>
			<input type="email" name="email" placeholder="Email" required/>
			<input type="password" name="password" placeholder="Password" required />
			<a href="fpw.html">Forgot your password?</a>
			<button type="submit">Sign In</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>

<footer>
	<p>
		Created with <i class="fa fa-heart"></i> by
		<a target="_blank" href="https://www.twitter.com/najum98">Najam Ul Saqib</a>
	</p>
</footer>
<!-- partial -->
<script  src="./awsd.js"></script>
</body>
</html>
