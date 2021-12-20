/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group1.enrollmodel;

import com.group1.classes.Course;
import com.group1.classes.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sailesh Paudel
 */
public class EnrollmentModel {
    public boolean validStudent(String stuID){
        String sql = "SELECT * FROM students where studentId=?;";
        Connection con1 = null;
        PreparedStatement preps = null;
        con1 = DBConnection.connection();
        //DBConnection dbc = new DBConnection();
        try {
            preps = con1.prepareStatement(sql);
            int studentID = Integer.parseInt(stuID);
            preps.setInt(1, studentID);
            ResultSet r1 = preps.executeQuery();
            
            
            //con1.close();
            return r1.next();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;                                   
    }
    
    public Student studentInfo(String stuID){
        Student student = new Student();
        Connection conn = null;
        PreparedStatement prps = null;
        conn = DBConnection.connection();
        String query = "SELECT * FROM students WHERE studentId=?;";
       
        try {
            
            int studID = Integer.parseInt(stuID);
            prps = conn.prepareStatement(query);
            prps.setInt(1, studID);
            ResultSet result1 = prps.executeQuery();

            while (result1.next()) {
                student.setStudentID(result1.getString("studentId"));
                student.setFirstName(result1.getString("firstName"));
                student.setLastName(result1.getString("lastName"));
                student.setAddress(result1.getString("address"));
                student.setEmail(result1.getString("email"));
                student.setPhone(result1.getString("phone"));
                
            }
            //conn.close();
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       return null; 
    }
    
    public String registerStudent(Student student){
        String fName = student.getFirstName();
        String lName = student.getLastName();
        String address = student.getAddress();
        String email = student.getEmail();
        String phone = student.getPhone();
        
        try {
            
            Connection connn = null;
            PreparedStatement prest = null;
            connn = DBConnection.connection();
            String query = "INSERT INTO students VALUES (NULL,?,?,?,?,?);";
            prest = connn.prepareStatement(query);
            //prest.setInt(1, 5);
            prest.setString(1, fName);
            prest.setString(2, lName);
            prest.setString(3, address);
            prest.setString(4, email);
            prest.setString(5, phone);
            
            
            int i = prest.executeUpdate();
            //connn.close();
            if(i!=0){
                return("SUCCESSFUL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return("SOMETHING WENT WRONG");
    }
    public ArrayList allCourses(){
        Connection connnn = null;
        PreparedStatement prpss = null;
        connnn = DBConnection.connection();
        String qry5 = "select * from classes;";
        try {
            prpss = connnn.prepareStatement(qry5);
            //ResultSet rs1 = prpss.executeQuery();
            ResultSet rs5 = prpss.executeQuery();
//            rs5.last();
//            int size = rs5.getRow();
//            rs5.beforeFirst();
            ArrayList Rows = new ArrayList();
            
            
            while (rs5.next()){
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3 ; i++){
                    row.add(rs5.getString(i));
//                    course.setClassID(rs5.getInt("classId"));
//                    course.setCourseID(rs5.getString("subjectCode"));
//                    course.setCourseName(rs5.getString("subject"));
                }
                Rows.add(row);
            }
            
            connnn.close();
            return Rows;
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //This function is used to register new course on the Database
    public String registerCourse(Course course) {
        String courseID = course.getCourseID();
        String courseName = course.getCourseName();
        Connection connn5 = null;
        PreparedStatement prest5 = null;
        try {
            
            String query5 = "INSERT INTO classes VALUES (NULL,?,?);";
            connn5 = DBConnection.connection();
                prest5 = connn5.prepareStatement(query5);
                prest5.setString(1, courseID);
                prest5.setString(2, courseName);
                int i = prest5.executeUpdate();

                if(i!=0){
                    connn5.close();
                    return("SUCCESSFUL");
                } 
//            }
//            else {
//                return("Database Closed");
//            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return("UNABLE TO ADD COURSE");
    }
    public String courseEnrollment(String stuID, String courseID){
        Connection con6 = null;
        PreparedStatement pre6 = null;
        con6 = DBConnection.connection();
        String qry6 = "INSERT INTO enrollment VALUES (NULL,?,?);";
        try {
            pre6 = con6.prepareStatement(qry6);
            pre6.setString(1, stuID);
            pre6.setString(2, courseID);
            int i = pre6.executeUpdate();
            //con6.close();
            if(i!=0){
                return("SUCCESSFUL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("UNABLE TO ADD YOU TO THE COURSE! TRY AGAIN LATER");
        
    }
    public String coursesEnrolled(String stuID){
        Connection con7 =null;
        PreparedStatement pre7 = null;
        con7 = DBConnection.connection();
        String qry = "SELECT subjectCode FROM enrollment WHERE studentId=?;";
        try {
            pre7 = con7.prepareStatement(qry);
            //pre7 = con7.prepareStatement(qry);
            pre7.setString(1, stuID);
            ResultSet result1 = pre7.executeQuery();
            String courses = result1.getString("subjectCode");
            return courses;
//            result1.last();
//            int size = result1.getRow();
//            result1.beforeFirst();
            //ArrayList Rows = new ArrayList();
            
            //while (result1.next()){
                //for (int i = 1; i <=  ; i++){
                    //Rows.add(result1.getString(i));
//                    course.setClassID(rs5.getInt("classId"));
//                    course.setCourseID(rs5.getString("subjectCode"));
//                    course.setCourseName(rs5.getString("subject"));
                //}
            //}
            //con7.close();
            //return Rows;
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Enrolled Courses Fetching Error";
    }
}
