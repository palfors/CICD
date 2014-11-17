<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.alforsconsulting.cicd.*" %>

<html>
<body>

Welcome to HelloBank!

<jsp:useBean id="helloBank" class="com.alforsconsulting.cicd.HelloBank" scope="session"/>

<form method="post" action="customer.jsp">
	<input type="hidden" name="action" value="login">
	Login: <br>
	Name: <input name="name" type="text"> <input type="submit">
</form>

<br><br>

<form method="post" action="customer.jsp">
	<input type="hidden" name="action" value="create">
	Create Customer: <br>
	Name: <input name="name" type="text"> <input type="submit">
</form>

</body>
</html>
