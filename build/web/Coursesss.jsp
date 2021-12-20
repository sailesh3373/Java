<%-- 
    Document   : courses
    Created on : Dec 19, 2021, 2:41:50 PM
    Author     : Kushal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Enrollment System</title>
        <style>
            #view_all {
              font-family: arial, sans-serif;
              border-collapse: collapse;
              width: 100%;
            }

            #view_tr, #view_th1, #view_th2, #view_th3 {
              border: 1px solid #dddddd;
              text-align: left;
              padding: 8px;
            }

            #view_tr:nth-child(even) {
              background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Courses!!</h1>
        <table id="view_all">
            <tr id="view_tr">
                <th id="view_th1">course ID</th>
                <th id="view_th2">Subject Code</th>
                <th id="view_th3">Course Name</th>
            </tr>
            <c:forEach items="${result_data}" var="row">
            <tr>
               <c:forEach items="${row}" var="column">
               <td><c:out value="${column}"/></td>
               </c:forEach>
            </tr>
            </c:forEach>
        </table><br><br>
            <form action="courses" method="post" onsubmit="return confirm('Do you want to submit this information?')">
                <table>
                    <tr>
                        <td>Enter Course ID</td>
                        <td><input type="text" name="courseID" /></td>
                    </tr>
                    <tr>
                        <td>Enter Course Name</td>
                        <td><input type="text" name="courseName" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="reset" value="Reset" /><input type="submit" name="submit" value="Add Course" /></td>
                    </tr>
                </table>
                
            </form><br>
            <h3><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></h3><br><br>
            <a href="index.jsp">Home</a>
    </body>
</html>
