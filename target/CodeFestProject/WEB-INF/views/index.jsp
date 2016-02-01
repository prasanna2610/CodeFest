<html>
<head>
<title>login</title>
<meta name="viewport" content="width=devide-width">
<link rel="stylesheet" type="text/css" href="css/style.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bookMealHome.js"></script>
</head>
<body>
<div class="wrapper">
	<div class="logo">
	
	</div>
<div class="loginText">

<p>Book your meal</p>
</div>
<div class="logInSection">
${errorMsg}
<form method="post" action="/home">
	<ul class="userName">
	<li></li>
	<li class="Inputsection"><input type="text" name="userName" id="userName"/></li>
	</ul>
	<ul class="password">
	<li></li>
	<li class="Inputsection"><input type="password" name="passWord" id="passWord"/></li>
	</ul>
	<button>Login</button>
</form>
</div>
</div>
</body>
</html>