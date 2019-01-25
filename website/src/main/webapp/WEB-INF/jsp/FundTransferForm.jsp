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
	<h1>Fund Transfer</h1>
	<form action="fundtransfer">
		Enter Account Number: <input name="senderaccountNumber" /><br />
		Enter Account Number: <input name="receiveraccountNumber" /><br />
		Enter Amount : <input name="amount" /><br /> <input type="submit" />
	</form>

</body>
</html>