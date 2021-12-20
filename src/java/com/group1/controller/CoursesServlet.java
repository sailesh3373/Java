/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.group1.controller;

import com.group1.classes.Course;
import com.group1.enrollmodel.EnrollmentModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Sailesh Paudel
 */
public class CoursesServlet extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EnrollmentModel enModel = new EnrollmentModel();
        ArrayList arr = null;
//        if(enModel.allCourses()!=null){
            arr = enModel.allCourses();
//            request.setAttribute("courseID", course.getCourseID());
//            request.setAttribute("courseName", course.getCourseName());
            request.setAttribute("result_data", arr);
            
            
//        }
        request.getRequestDispatcher("Coursesss.jsp").forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseID = request.getParameter("courseID");
        String courseName = request.getParameter("courseName");
        EnrollmentModel ennModel = new EnrollmentModel();
        Course course = new Course();
        course.setClassID(1);
        course.setCourseID(courseID);
        course.setCourseName(courseName);
        
        
        String courseRegistration = ennModel.registerCourse(course);
        if(courseRegistration.equals("SUCCESSFUL")){
            request.setAttribute("errMessage", "Course Successfully Added");
            request.getRequestDispatcher("/Info.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errMessage", courseRegistration);
            request.getRequestDispatcher("/Info.jsp").forward(request, response);
        }
    }

    

}
