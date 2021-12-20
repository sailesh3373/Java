<%-- 
    Document   : CourseEnroll
    Created on : Dec 19, 2021, 6:17:12 PM
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
        <h1>Course Enroll</h1><br><br>
        <div>
            <form action="course_enroll" method="post" onsubmit="return confirm('Do you want to submit the Information?');">
                <table>
                    <tr>
                        <td>Enter Student ID</td>
                        <td><input type="text" name="stuID" /></td>
                    </tr>
                    <tr>
                        <td>Enter Subject Code</td>
                        <td><input type="text" name="courseID" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="reset" value="Reset" /><input type="submit" name="submit" value="Enroll in the Subject" /><td>
                    </tr>
                    
                </table>
                <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
            </form>
            <h3><a href="index.jsp">Home</a></h3>
        </div>
    </body>
</html>
