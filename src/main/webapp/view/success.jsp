<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function deleteById() {
	alert("in delete function");
	document.myform.action="delete";
	document.myform.submit();
}

function edit() {
	alert("in edit function");
	document.myform.action="edit";
	document.myform.submit();
	
}









</script>


</head>
<body>
<center>
<form name="myform">
<table border="2">
<tr>
<th>select</th>
<th>Employee Id</th>
<th>Name</th>
<th>City</th>
<th>Salary</th>
<th>UserName</th>
<th>Password</th>
</tr>

<tr>
<c:forEach var="e" items="${data}">
<td><input type="radio" name="empId" value="${e.empId}">
<td>${e.empId}</td>
<td>${e.name}</td>
<td>${e.city}</td>
<td>${e.salary}</td>
<td>${e.uname}</td>
<td>${e.pass}</td>
</tr>
</c:forEach>
</table>
<br>
<hr><br>
<input type="submit" value="Delete" onclick="deleteById()">
<input type="submit" value="Edit" onclick="edit()">
</center>












</form>
</body>
</html>