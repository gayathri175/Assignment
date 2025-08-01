<!-- fail.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result - Fail</title>
</head>
<body>
    <h2>Result</h2>
    <p>Student <b>${studentName}</b> has <b>failed</b> with ${studentMarks} marks.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>
