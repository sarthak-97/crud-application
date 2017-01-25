<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit page</title>
</head>
<body>
edit the details 
<br>
<form name=frm action=modify method=post>
Student id <input type=text name=id value="${studid} ${norec}" readonly><br>
enter new name<input type=text name=name value="${name}"><br>
enter new age<input type=text name=age value="${age}"><br>
enter new clg<input type=text name=clg value="${clg}"><br>
enter new address<input type=text name=address value="${address}"><br>
<input type=submit>
</form>
<center>
<h1> ${rec} </h1></center>
</body>
</html>