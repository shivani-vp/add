
<!DOCTYPE html>  
<html>  
	<head>  
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<link rel="stylesheet" type="text/css" href="Registration style.css">  
	</head>  
<body style="background:#c6d4c5;">  
<form method="POST" action="patient.php">  
<div class="container">  
  <center>  <h1 class="heading"> New Registration </h1>  
  <hr>

<label for="firstname"> <b> Firstname  </b> </label> <br>
<input type="text" name="firstname" placeholder= "Firstname" size="15" required /> <br>

<label for="middlename"> <b> Middlename </b> </label> <br>  
<input type="text" name="middlename" placeholder="Middlename" size="15" required /> <br>

<label for="lastname"> <b> Lastname </b> </label> <br>   
<input type="text" name="lastname" placeholder="Lastname" size="15"required /> <br>

<div>  
	<label for="age"> <b> Age </b> </label> <br>   
	<input type="number" name="age" placeholder="Age" min="0" size="2" required /> <br>

	<label for="select"> <b> Gender  </b> </label><br>
		<input type="radio" value="Male" name="gender" /> Male 
		<input type="radio" value="Female" name="gender" /> Female 
		<input type="radio" value="Other" name="gender" /> Other 
	<br>   
</div>
<div>
	<br>
	<label for="mobile"> <b> Phone </b> </label> <br> 
	<input type="number" name="mobile" placeholder="Mobile number" size="10" required> <br>

	<label for="email"> <b> Email  </b> </label> <br> 
	<input type="email" placeholder="Enter Email" name="email" required /><br>

	<label for="address"> <b> Address </b> </label> <br> 
	<input type="text" placeholder="Address" name="address" required />
</div>
 
<button type="submit" name="submit" class="registerbtn"> Register </button>    
</center> 
</form>  
</body>  
</html> 
<?php
	$con = mysqli_connect("localhost","root","","covid");         
	if(isset($_REQUEST['submit']))
	{
		$firstname=$_REQUEST['firstname'];
		$middlename=$_REQUEST['middlename'];
		$lastname=$_REQUEST['lastname'];
		$age=$_REQUEST['age'];
		$gender=$_REQUEST['gender'];
		$mobile=$_REQUEST['mobile'];
		$email=$_REQUEST['email'];
		$address=$_REQUEST['address'];
	
		if(mysqli_connect_errno())                                
		{
		echo "Failed to connect to the database: ".mysqli_connect_error(); 
		} 
		else
		{
		mysqli_query($con,"insert into registration(FirstName,MiddleName,LastName,Age,Gender,Mobile,Email,Address) values('$firstname','$middlename','$lastname','$age','$gender','$mobile','$email','$address')");
		}
	}
	mysqli_close($con);
?> 