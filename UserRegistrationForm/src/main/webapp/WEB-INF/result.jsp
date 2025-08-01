<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String marksStr = request.getParameter("marks");

    if (name == null || marksStr == null) {
%>
    <h2>Enter Student Details</h2>
    <form method="post">
        Name: <input type="text" name="name"><br><br>
        Marks: <input type="number" name="marks"><br><br>
        <input type="submit" value="Submit">
    </form>
<%
    } else {
        int marks = Integer.parseInt(marksStr);
%>

    <h2>Result</h2>
    <%
        if (marks >= 40) {
    %>
        <p>Student <b><%= name %></b> has <b>passed</b> with <%= marks %> marks.</p>
    <%
        } else {
    %>
        <p>Student <b><%= name %></b> has <b>failed</b> with <%= marks %> marks.</p>
    <%
        }
    %>

    <!-- Footer Section -->
    <hr>
    <footer>
        <p style="text-align:center;">&copy; 2025 Student Results Portal</p>
    </footer>

<%
    }
%>

</body>
</html>
