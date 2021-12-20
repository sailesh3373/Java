<%-- 
    Document   : newStudent
    Created on : Dec 18, 2021, 4:12:44 PM
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
        <h1>Insert New Student Information</h1>
        <div>
            <form action="new_enroll" method="post" onsubmit="return confirm('Do you want to submit the information?');">
                <table>
                    <tr>
                        <td>Enter Student First Name: </td>
                        <td><input type="text" name="firstName" /></td>
                    </tr>
                    <tr>
                        <td>Enter Student Last Name: </td>
                        <td><input type="text" name="lastName" /></td>
                    </tr>
                    <tr>
                        <td>Enter Address: </td>
                        <td><input type="text" name="address" /></td>
                    </tr>
                    <tr>
                        <td>Enter E-mail: </td>
                        <td><input type="text" name="email" /></td>
                        
                    </tr>
                    <tr>
                        <td>Enter Phone: </td>
                        <td><input type="text" name="phone" /></td>
                    </tr>
                    <tr>
                        <td><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="reset" value="Reset" /><input type="submit" name="submit" value="Submit Entry" /></td>
                    </tr>
                </table>
                               
        </div><br>
                    <a href="index.jsp">Home</a>
    </body>
    
</html>
