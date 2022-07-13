/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import Model.*;

public class SessionsDBContext extends DBContext {
    
    public ArrayList<Session> searchByLecturers(Date TimeFrom, Date TimeTo, String LecturersID, int CampusID) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT [SessionID]\n"
                    + " ,[GroupID]\n"
                    + " ,s.[LecturersID]\n"
                    + " ,[CourseID]\n"
                    + " ,s.[SlotID]\n"
                    + " ,t.SlotNumber\n"
                    + " ,t.TimeFrom\n"
                    + " ,t.TimeTo\n"
                    + " ,[Room]\n"
                    + " ,[SlotStatus]\n"
                    + " FROM [dbo].[Session] s\n"
                    + " LEFT JOIN [dbo].[TimeSlot] t on t.[SlotID] = s.[SlotID]\n"
                    + " LEFT JOIN [dbo].Lecturers l on l.LecturersID = s.LecturersID\n"
                    + " WHERE t.TimeFrom >= '?' and t.TimeFrom <= '?' and s.[LecturersID] like '?' and l.CampusID like '?'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, TimeFrom);
            stm.setDate(2, TimeTo);
            stm.setString(3, LecturersID);
            stm.setInt(4, CampusID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session se = new Session();
                se.setSessionID(rs.getInt("SessionID"));
                se.setRoom(rs.getString("Room"));
                se.setSessionStatus(rs.getString("SlotStatus"));
                
                Lecturers lec = new Lecturers();
                lec.setLecturersID(rs.getString("LecturersID"));
                se.setLecturers(lec);
                
                StudentGroups sg = new StudentGroups();
                sg.setGroupID(rs.getString("GroupID"));
                se.setGroups(sg);
                
                TimeSlot slot = new TimeSlot();
                slot.setSlotID(rs.getInt("SlotID"));
                slot.setSlotNumber(rs.getInt("SlotNumber"));
                slot.setTimeFrom(rs.getDate("TimeFrom"));
                slot.setTiemTo(rs.getDate("TimeTo"));
                se.setSlot(slot);
                
                Courses courses = new Courses();
                courses.setCourseID(rs.getString("CourseID"));
                se.setCourses(courses);
                
                sessions.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }
    
    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
