/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Database.SessionsDBContext;
import Database.StudentDBContext;
import Database.TimeslotDBContext;
import Model.Session;
import Model.TimeSlot;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class LecturerTakeAttendance extends HttpServlet {

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
        int SessionID = Integer.parseInt(request.getParameter("sessionID"));
        SessionsDBContext sdb = new SessionsDBContext();
        ArrayList<Session> list = sdb.GetAtendance(SessionID);
        request.setAttribute("list", list);

        String Group = null;
        for (Session se : list) {
            Group = se.getGroups().getGroupID();
        }
        request.setAttribute("group", Group);

        String Lecturer = null;
        for (Session se : list) {
            Lecturer = se.getLecturers().getLecturersID();
        }
        request.setAttribute("lec", Lecturer);

        int SlotNumber = 0;
        Date date = null;
        String term = null;
        for (Session se : list) {
            TimeslotDBContext tdb = new TimeslotDBContext();
            TimeSlot time = tdb.getTimeByID(se.getSlot().getSlotID());
            SlotNumber = time.getSlotNumber();
            date = time.getTimeFrom();
            term = time.getTerm();
        }
        request.setAttribute("slotNumber", SlotNumber);
        request.setAttribute("date", date);
        request.setAttribute("term", term);

        String Room = null;
        for (Session se : list) {
            Room = se.getRoom();
        }
        request.setAttribute("room", Room);

        String Course = null;
        for (Session se : list) {
            Course = se.getCourses().getCourseID();
        }
        request.setAttribute("course", Course);

        String StudentName = null;
        for (Session se : list) {
            StudentDBContext stdb = new StudentDBContext();
            StudentName = stdb.getStudentNameByID(se.getGroups().getStudent().getStudentsID());
        }
        request.setAttribute("StudentName", StudentName);
        request.getRequestDispatcher("../View/LecturerTakeAttendance.jsp").forward(request, response);
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
