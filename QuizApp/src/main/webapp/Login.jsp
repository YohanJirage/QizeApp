<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

${cookie.msg.value}
<form action="http://localhost:8080/QuizApp/logincheck" method="post">
	<table >
		
			<tr>
				<td>
					<label>Enter User Id : </label>
				</td>
				<td>
					<input type="text" name="uid" />
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Password : </label>
				</td>
				<td>
					<input type="password" name="pwd" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="btn-success" style="float:left;" value="LOGIN"/>
				</td>
				<td>
					<input type="reset" class="btn-primary" name="RESET" /><br/>
				</td>
				 
			</tr>		
		</table>
	</form>
		
	<form action="Registration.jsp">
	 	<br/><input type="submit" class="btn-primary" value="Registration" />
	</form>


</body>
</html>