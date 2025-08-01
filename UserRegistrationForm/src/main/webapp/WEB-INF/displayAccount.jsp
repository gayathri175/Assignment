<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="account" class="beans.BankAccount" scope="request" />
<jsp:setProperty name="account" property="*" />

<%
    String accType = request.getParameter("accountType");
    session.setAttribute("accType", accType);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
    <h2>Bank Account Details</h2>
    <p><b>Account Number:</b> ${account.accountNo}</p>
    <p><b>Name:</b> ${account.name}</p>
    <p><b>Balance:</b> ${account.balance}</p>
    <p><b>Account Type (from session):</b> ${sessionScope.accType}</p>

    <p>
        <b>Status:</b>
        ${account.balance >= 1000 ? "Sufficient Balance" : "Insufficient Balance"}
    </p>
</body>
</html>
