<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <h2>User Information</h2>

    <form method="post">
        User Name: <input type="text" name="username" value="${param.username}"><br><br>

        Password: <input type="password" name="password" value="${param.password}"><br><br>

        Address:<br>
        <textarea name="address" rows="4" cols="40">${param.address}</textarea><br><br>

        Subscribe Newsletter: 
        <input type="checkbox" name="subscribe" value="yes" 
            ${param.subscribe == 'yes' ? 'checked' : ''}><br><br>

        Favorite Web Frameworks:<br>
        <input type="checkbox" name="framework" value="Spring MVC" 
            ${paramValues.framework.contains('Spring MVC') ? 'checked' : ''}> Spring MVC
        <input type="checkbox" name="framework" value="Struts 1" 
            ${paramValues.framework.contains('Struts 1') ? 'checked' : ''}> Struts 1
        <input type="checkbox" name="framework" value="Struts 2" 
            ${paramValues.framework.contains('Struts 2') ? 'checked' : ''}> Struts 2
        <input type="checkbox" name="framework" value="Apache Wicket" 
            ${paramValues.framework.contains('Apache Wicket') ? 'checked' : ''}> Apache Wicket
        <br><br>

        Gender:
        <input type="radio" name="gender" value="Male" 
            ${param.gender == 'Male' ? 'checked' : ''}> Male
        <input type="radio" name="gender" value="Female" 
            ${param.gender == 'Female' ? 'checked' : ''}> Female
        <br><br>

        Favorite Number:
        <input type="radio" name="fnumber" value="1" ${param.fnumber == '1' ? 'checked' : ''}>1
        <input type="radio" name="fnumber" value="2" ${param.fnumber == '2' ? 'checked' : ''}>2
        <input type="radio" name="fnumber" value="3" ${param.fnumber == '3' ? 'checked' : ''}>3
        <input type="radio" name="fnumber" value="4" ${param.fnumber == '4' ? 'checked' : ''}>4
        <br><br>

        <input type="submit" value="Submit">
    </form>

    <hr>

    <h3>Submitted Data:</h3>
    <p><b>User Name:</b> ${param.username}</p>
    <p><b>Password:</b> ${param.password}</p>
    <p><b>Address:</b> ${param.address}</p>
    <p><b>Subscribed:</b> ${param.subscribe}</p>
    <p><b>Frameworks:</b> 
        ${paramValues.framework[0]}, 
        ${paramValues.framework[1]}, 
        ${paramValues.framework[2]}, 
        ${paramValues.framework[3]}
    </p>
    <p><b>Gender:</b> ${param.gender}</p>
    <p><b>Favorite Number:</b> ${param.fnumber}</p>

</body>
</html>
