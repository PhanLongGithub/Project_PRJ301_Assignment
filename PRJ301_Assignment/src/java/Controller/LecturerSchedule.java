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
import Database.LecturersDBContext;
import Database.TimeslotDBContext;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;

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
        String TimeFrom = request.getParameter("from");
        String TimeTo = request.getParameter("to");
        Date from = (TimeFrom != null && TimeFrom.length() > 0) ? Date.valueOf(TimeFrom) : null;
        Date to = (TimeTo != null && TimeTo.length() > 0) ? Date.valueOf(TimeTo) : null;

        CampusDBContext cdb = new CampusDBContext();
        ArrayList<Campus> campus = cdb.list();
        request.setAttribute("campus", campus);

        LecturersDBContext ldb = new LecturersDBContext();
        ArrayList<Lecturers> lec = ldb.list();
        request.setAttribute("lecturers", lec);

        TimeslotDBContext tsdb = new TimeslotDBContext();
        ArrayList<TimeSlot> timeslot = tsdb.list();
        request.setAttribute("timeslot", timeslot);

        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        calFrom.setTime(from);
        calTo.setTime(to);
        ArrayList TimeList = new ArrayList<>();
        while (true) {
            String date = calFrom.getTime().toString();
            TimeList.add(date);
            if (calFrom.compareTo(calTo) > 0) {
                break;
            }
            calFrom.add(Calendar.DATE, 1);
        }
        request.setAttribute("date", TimeList);

//        Calendar cal = Calendar.getInstance();
//        cal.clear();
//        cal.set(Calendar.YEAR, 2022);
//        cal.set(Calendar.MONTH, Calendar.JANUARY);
//        cal.set(Calendar.DATE,1);
//        System.out.println("Start at " + cal.getTime());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy");
//        ArrayList Year = new ArrayList();
//        for (TimeSlot slot : timeslot) {
//            String year = format.format(slot.getTimeFrom());
//            if (!Year.contains(year)) {
//                Year.add(year);
//            }
//        }
//        request.setAttribute("year", Year);
//
//        SimpleDateFormat formatWeek = new SimpleDateFormat("dd/MM");
//        formatWeek.setLenient(false);
//        
//        
//        ArrayList Week = new ArrayList();
//        for (TimeSlot slot : timeslot) {
//            String weekFrom = formatWeek.format(slot.getTimeFrom());
//            String weekTo = formatWeek.format(slot.getTimeTo());
//            String week = weekFrom + " to " + weekTo;
//            if (!Week.contains(week)) {
//                Week.add(week);
//            }
//        }
//        request.setAttribute("week", Week);
        String LecturersID = request.getParameter("lecturer");
        int CampusID = Integer.parseInt(request.getParameter("campus"));
        SessionsDBContext sdb = new SessionsDBContext();
        ArrayList<Session> session = sdb.DisplaySchedule(LecturersID, CampusID, from, to);
        request.setAttribute("session", session);
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
        CampusDBContext cdb = new CampusDBContext();
        ArrayList<Campus> campus = cdb.list();
        request.setAttribute("campus", campus);

        LecturersDBContext ldb = new LecturersDBContext();
        ArrayList<Lecturers> lec = ldb.list();
        request.setAttribute("lecturers", lec);

        TimeslotDBContext tsdb = new TimeslotDBContext();
        ArrayList<TimeSlot> timeslot = tsdb.list();
        request.setAttribute("timeslot", timeslot);
        request.getRequestDispatcher("../View/LecturerSchedule.jsp").forward(request, response);
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
