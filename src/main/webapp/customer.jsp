<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alforsconsulting.cicd.*" %>

<html>
<body>

<jsp:useBean id="helloBank" class="com.alforsconsulting.cicd.HelloBank" scope="session"/>
<jsp:useBean id="customer" class="com.alforsconsulting.cicd.Customer" scope="session"/>

<%
if ("login".equals(request.getParameter("action"))) {
	// get the customer from helloBank
    customer = helloBank.getCustomer(request.getParameter("name"));
}
else if ("create".equals(request.getParameter("action"))) {      
	String name = request.getParameter("name");
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
        customer = helloBank.getCustomer(request.getParameter("name"));
        customer.addCheckingAccount(new Double(request.getParameter("initialBalance")));
	}
	catch (DuplicateAccountException e) {
		out.println("Account already exists");
	}
}
%>
<br>

<% if (customer == null) { %>

Customer does not exist!

<% } else { %>
    Customer: <%=customer.getName()%>
    <br>
    <br>

    Accounts:<br>
<%
    List<Account> accounts = customer.getAccounts();
    for (Account account : accounts) {
            out.println(account.getAccountNumber() + ": Balance $" + account.getBalance() + "<br>");
    }
%>
    <br><br>
    Add Account:
    <form method="post" action="customer.jsp">
        <input type="hidden" name="action" value="addAccount">
        <input type="hidden" name="name" value="<%=customer.getName()%>">
        Initial Balance: <input name="initialBalance" type="text"> <input type="submit">
    </form>
<% } %>

</body>
</html>

<br><br>
<a href="helloBank.jsp">Return to Main Menu</a>
