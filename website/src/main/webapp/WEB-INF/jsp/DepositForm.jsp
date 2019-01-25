<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<h1 align="center">Deposit Form</h1>
	<form action="deposit">
		Enter Account Number: <input name="accountNumber" /><br />
		 Enter Amount : <input name="amount" /><br /> <input type="submit" />
	</form>
	
</body>
</html>