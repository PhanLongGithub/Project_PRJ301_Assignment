/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Database.AttendanceDBContext;
import Model.Attendance;
import Model.Session;
import Model.Students;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class ShowAttendance extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] raw_index = request.getParameterValues("index");
        for (String raw_index1 : raw_index) {
            String studentID = request.getParameter(raw_index1 + "StudentID");
            int sessionID = Integer.parseInt(request.getParameter(raw_index1 + "SessionID"));
            String Comment = request.getParameter(raw_index1 + "comment");
            String status = request.getParameter(raw_index1 + "status");
            Calendar cal = Calendar.getInstance();
            Date date = new Date(cal.getTimeInMillis());
            Students st = new Students();
            st.setStudentsID(studentID);
            Session se = new Session();
            se.setSessionID(sessionID);
            Attendance at = new Attendance();
            at.setStudents(st);
            at.setSession(se);
            at.setCommet(Comment);
            at.setStatus(status);
            at.setRecordTime(date);

            AttendanceDBContext adb = new AttendanceDBContext();
            adb.insert(at);
        }
        request.getRequestDispatcher("View/ShowAttendance.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
