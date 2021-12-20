/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.group1.controller;

import com.group1.classes.Student;
import com.group1.enrollmodel.EnrollmentModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Sailesh Paudel
 */
public class NewEnrollment extends HttpServlet {

   
    

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
        response.sendRedirect(request.getContextPath() + "/newStudent.jsp");
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
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        Student student = new Student();
        student.setStudentID("a");
        student.setFirstName(fName);
        student.setLastName(lName);
        student.setAddress(address);
        student.setEmail(email);
        student.setPhone(phone);
        
        EnrollmentModel enrollmentModel = new EnrollmentModel();
        String userRegistration = enrollmentModel.registerStudent(student);
        if(userRegistration.equals("SUCCESSFUL")){
            request.setAttribute("errMessage", "Student Successfully Enrolled");
            request.getRequestDispatcher("/Info.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errMessage", userRegistration);
            request.getRequestDispatcher("/newStudent.jsp").forward(request, response);
        }
    }

   

}
