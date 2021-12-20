<%-- 
    Document   : StudentInfo
    Created on : Dec 17, 2021, 7:55:53 PM
    Author     : Sailesh Paudel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Enrollment System</title>
        <style>
            table {
              font-family: arial, sans-serif;
              border-collapse: collapse;
              width: 100%;
            }

            td, th {
              border: 1px solid #dddddd;
              text-align: left;
              padding: 8px;
            }

            tr:nth-child(even) {
              background-color: #dddddd;
            }
</style>
    </head>
    <body>
        <h1>Student Info</h1>
        <div>
            <table>
                <tr>
                <th>Student ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>E-mail</th>
                <th>Phone</th>
                <th>Courses Enrolled</th>
                </tr>
                <tr>
                    <td>${studentID}</td>
                    <td>${firstName}</td>
                    <td>${lastName}</td>
                    <td>${address}</td>
                    <td>${email}</td>
                    <td>${phone}</td>
                    <td>
                    ${course}     
                    </td>
                </tr>
                
            </table>
        </div>
                <a href="index.jsp">Return Home</a>
    </body>
</html>
