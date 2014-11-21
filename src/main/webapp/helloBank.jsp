<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alforsconsulting.cicd.*" %>

<html>
<body>

Welcome to HelloBank!
<br>
<br>
<jsp:useBean id="helloBank" class="com.alforsconsulting.cicd.HelloBank" scope="session"/>

<form method="post" action="customer.jsp">
	<input type="hidden" name="action" value="login">
	Login: <br>
	Name: <input name="loginName" type="text"> <input id="loginSubmit" type="submit">
</form>

<br><br>

<form method="post" action="customer.jsp">
	<input type="hidden" name="action" value="create">
	Create Customer: <br>
	Name: <input name="createName" type="text"> <input id="createSubmit" type="submit">
</form>

<br><br>
Current Customers:
<br>
<%
List<Customer> customers = helloBank.getCustomers();
for (Customer customer : customers) {
		out.println(customer.getName() + "<br>");
}
%>

</body>
</html>
