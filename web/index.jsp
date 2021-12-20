<%-- 
    Document   : index
    Created on : Dec 19, 2021, 2:33:45 PM
    Author     : Sailesh Paudel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Enrollment System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div><h1>Student Enrollment System</h1><br><br>
            <h3>Enter Student Name</h3>
            <form action="enrollment" method = "post">
                Enter Student ID: <input type="text" name="studentID" /><br><br>
                <input type="submit" name="submit" value="Check"/>
                
            </form>
            <h3><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></h3>
            <h4><a href="new_enroll">Click here to add new student</a></h4><br>
            <h4><a href="courses">Add Courses on Database</a></h4><br>
            <h4><a href="course_enroll">Enroll to Course</a>
        </div>
    </body>
</html>

