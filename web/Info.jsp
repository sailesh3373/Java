<%-- 
    Document   : StudentInvalid
    Created on : Dec 17, 2021, 7:57:57 PM
    Author     : Sailesh Paudel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Enrollment System</title>
    </head>
    <body>
        <h1>Information Corner!</h1><br><br><br>
        <h3><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></h3><br><br>
        <a href="index.jsp">Home</a>
        
    </body>
</html>
