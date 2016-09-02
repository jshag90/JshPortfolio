<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Manager Application</title>


<link rel="stylesheet" href="./resources/css/reset.css">
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="./resources/css/style.css">
<link rel="stylesheet" href="./resources/script/animate.css">


</head>

<body>

	<div class="pen-title">
		<img class="animated bounce" src="./resources/images/Logo.png" />
	</div>
	<!-- Form Module-->
	<div class="module form-module">
		<div class="toggle">
			<i class="fa fa-times fa-pencil"></i>
			<div class="tooltip">Click Me</div>
		</div>
		<div class="form">
			<h2>Login to your account</h2>
			<form action="./login" method="post">
				<input type="text" id="userName" name="userName" /> <input
					type="password" id="password" name="password" />
				<button type="submit">Login</button>

				<br>${message }
			</form>
		</div>
		<div class="form">
			<h2>Create an account</h2>
			<form action="./join" method="post">
				<input type="text" id="userName" name="userName"
					placeholder="Username" /> <input type="password" id="password"
					name="password" placeholder="Password" /> <input type="email"
					id="email" name="email" placeholder="Email Address" /> <input
					type="tel" id="tel" name="tel" placeholder="Phone Number" />
				<button type="submit">Register</button>
			</form>
		</div>
		<div class="cta">
			<a href="#">Welcome to Web Manager Application</a>
		</div>

	</div>


	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="./resources/js/index.js"></script>

</body>
</html>
