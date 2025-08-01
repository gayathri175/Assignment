<!-- form.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Form</title>
</head>
<body>
    <h2>Enter Student Details</h2>
    <form action="check.jsp" method="post">
        Name: <input type="text" name="name"><br><br>
        Marks: <input type="number" name="marks"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
