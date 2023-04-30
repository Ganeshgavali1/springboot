<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<pre>
<form action="update">
<input type="hidden" name="empId" value="${data.empId}">

Name :    <input type="text" name="name" value="${data.name }">

City :    <input type="text" name="city" value="${data.city }">

Salary :  <input type="text" name="salary" value="${data.salary }">

Username :<input type="text" name="uname" value="${data.uname }">

Password :<input type="text" name="pass" value="${data.pass }">

<input type="submit" value="SUBMIT">
</pre>
</center>

</form>
</body>
</html>