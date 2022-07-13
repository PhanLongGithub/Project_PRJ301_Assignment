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
import Model.*;
import java.sql.Date;
import java.util.ArrayList;
import Database.CampusDBContext;

/**
 *
 * @author ADMIN
 */
public class LecturerSchedule extends HttpServlet {

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
//        Date TimeFrom = Date.valueOf(request.getParameter("timeFrom"));
//        Date TimeTo = Date.valueOf(request.getParameter("timeto"));
//        String LecturersID = request.getParameter("LecturersID");
//        int CampusID = Integer.parseInt(request.getParameter("CampusID"));
//        SessionsDBContext sdb = new SessionsDBContext();
//        ArrayList<Session> session = sdb.searchByLecturers(TimeFrom, TimeTo, LecturersID, CampusID);
//        request.setAttribute("session", session);

        CampusDBContext cdb = new CampusDBContext();
        ArrayList<Campus> campus = cdb.list();
        request.setAttribute("campus", campus);
        request.getRequestDispatcher("../View/LecturerSchedule.jsp").forward(request, response);
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
