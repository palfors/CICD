<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alforsconsulting.cicd.*" %>

<html>
<body>

<jsp:useBean id="helloBank" class="com.alforsconsulting.cicd.HelloBank" scope="session"/>
<jsp:useBean id="customer" class="com.alforsconsulting.cicd.Customer" scope="session"/>        

<%
out.println("action: " + request.getParameter("action") + "\n");
String name = request.getParameter("name");

if ("login".equals(request.getParameter("action"))) {
	customer = helloBank.getCustomer(name);
} 
else if ("create".equals(request.getParameter("action"))) {      
	try {
		helloBank.addCustomer(name);

        customer = helloBank.getCustomer(name);
	}
	catch (DuplicateCustomerException e) {
		out.println("Customer [" + name + "] already exists");        
	}
}
else if ("addAccount".equals(request.getParameter("action"))) {
	try {
        customer.addCheckingAccount(new Double(request.getParameter("initialBalance")));
	}
	catch (DuplicateAccountException e) {
		out.println("Account already exists");
	}
}
%>
<br>
Customer Name: <%=customer.getName()%>
<br>
<br>
Accounts:<br>
<%
List<Account> accounts = customer.getAccounts();
for (Account account : accounts) {
		out.println("Account [" + account.getAccountNumber() + "] Balance [" + account.getBalance() + "]\n");
}
%>

<br><br>

Add Account:
<form method="post" action="customer.jsp">
	<input type="hidden" name="action" value="addAccount">
	Initial Balance: <input name="initialBalance" type="text"> <input type="submit">
</form>

</body>
</html>

<a href="helloBank.jsp">Return to Main Menu</a>
