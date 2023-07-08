<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/QuizApp/register" method="post">
	<table>
		
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
					<label>Enter First Name : </label>
				</td>
				<td>
					<input type="text" name="fname" />
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Middle Name : </label>
				</td>
				<td>
					<input type="text" name="mname" />
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Last Name : </label>
				</td>
				<td>
					<input type="text" name="lname" />
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Email  : </label>
				</td>
				<td>
					<input type="email" name="email" />
				</td>
			</tr>
			
			<tr>
				<td>
					<label>Enter Contact : </label>
				</td>
				<td>
					<input type="text" name="num" />
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" style="float:left;" value="REGISTER"/>
				</td>
				<td>
					<input type="reset" style="float:right;" name="RESET" />
				</td>
			</tr>		
		</table>
	</form>

</body>
</html>