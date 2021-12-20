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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sailesh Paudel
 */
public class EnrollmentServlet extends HttpServlet {

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
        doPost(request, response);
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
        String stuID = request.getParameter("studentID");
        EnrollmentModel enModel = new EnrollmentModel();
        Student student = null;
        //ArrayList list = new ArrayList();
            if(enModel.validStudent(stuID)){
                student = enModel.studentInfo(stuID);
                String course = enModel.coursesEnrolled(stuID);
                request.setAttribute("course", course);
                request.setAttribute("studentID", student.getStudentID());
                request.setAttribute("firstName", student.getFirstName());
                request.setAttribute("lastName", student.getLastName());
                request.setAttribute("address", student.getAddress());
                request.setAttribute("email", student.getEmail());
                request.setAttribute("phone", student.getPhone());
                request.getRequestDispatcher("StudentInfo.jsp").forward(request, response);
                
            } else {
                request.setAttribute("errMessage", "Student ID not Found!!!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
    
        
    }


}
