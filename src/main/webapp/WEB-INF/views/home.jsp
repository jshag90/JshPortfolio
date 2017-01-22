<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
*, *:after, *:before {
  box-sizing: border-box;
}

body {
  background: #313654;
}

.ryan {
  position: relative;
  margin: 50px auto;
  width: 400px;
  height: 380px;
}

.ryan:hover .eyebrow.left {
  top: 100px;
}

.ryan:hover .eyebrow.right {
  -webkit-transform: rotate(-10deg);
  transform: rotate(-10deg);
}

.ryan:hover .eye.right {
  -webkit-transform: scale(2, 0.1);
  transform: scale(2, 0.1);
}

.ryan .ear {
  position: absolute;
  top: 0;
  width: 92px;
  height: 92px;
  border: 10px solid #000;
  border-radius: 100%;
  background: #d59729;
}

.ryan .ear.left {
  left: 54px;
}

.ryan .ear.right {
  right: 54px;
}

.ryan .face {
  position: absolute;
  bottom: 0;
  width: 400px;
  height: 367px;
  border-radius: 100%;
  border: 10px solid #000;
  background: #d59729;
}

.ryan .eyebrow {
  position: absolute;
  top: 106px;
  width: 78px;
  height: 14px;
  border-radius: 14px;
  background: #000;
  transition: all 0.2s;
}

.ryan .eyebrow.left {
  left: 68px;
}

.ryan .eyebrow.right {
  right: 68px;
}

.ryan .eye {
  position: absolute;
  top: 147px;
  width: 26px;
  height: 26px;
  border-radius: 100%;
  background: #000;
  transition: all 0.2s;
}

.ryan .eye.left {
  left: 98px;
}

.ryan .eye.right {
  right: 98px;
}

.ryan .nose {
  position: absolute;
  top: 184px;
  left: 50%;
  margin-left: -16px;
  width: 32px;
  height: 33px;
  border-radius: 80% 80% 100% 100%;
  background: #000;
  z-index: 2;
}

.ryan .mouth {
  position: absolute;
  top: 191px;
  right: 73px;
  width: 73px;
  height: 68px;
  border: 10px solid #000;
  border-radius: 50%;
  background: #fff;
}
.ryan .mouth.left {
  left: 127px;
}

.ryan .mouth.right {
  right: 127px;
}

.ryan .mouth:before {
  content: "";
  position: absolute;
  width: 30px;
  height: 33px;
  background: #fff;
  -webkit-transform: rotate(-45deg);
  transform: rotate(-45deg);
  z-index: 1;
}

.ryan .mouth.left:before {
  top: 2px;
  left: 29px;
}

.ryan .mouth.right:before {
  top: 2px;
  right: 31px;
}

</style>
<title>Web Manager Application</title>


<link rel="stylesheet" href="./resources/css/reset.css">
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
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
				<input type="text" id="userName" name="userName" placeholder="Username" /> 
				<input type="password" id="password"	name="password" placeholder="Password" /> <input type="email"
					id="email" name="email" placeholder="Email Address" /> <input
					type="tel" id="tel" name="tel" placeholder="Phone Number" />
				<button type="submit">Register</button>
			</form>
		</div>
		<div class="cta">
			<a href="./">Welcome to Web Manager Application</a>
	</div>
		

	</div>

	<!-- RYAN -->
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="./resources/js/index.js"></script>

		<div class="ryan">
		<div class="ear left"></div>
		<div class="ear right"></div>

		<div class="face">
			<div class="eyebrow left"></div>
			<div class="eyebrow right"></div>
			<div class="eye left"></div>
			<div class="eye right"></div>
			<div class="nose"></div>
			<div class="mouth left"></div>
			<div class="mouth right"></div>

		</div>
		</div>
</body>
</html>
