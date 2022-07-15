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
import Model.*;

/**
 *
 * @author ADMIN
 */
public class AttendanceDBContext extends DBContext {

    public ArrayList<Session> searchByLecturers(int SessionID) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = " SELECT se.GroupID,\n"
                    + "  st.StudentsFirstName,\n"
                    + "	 st.StudentsMiddleName,\n"
                    + "	 st.StudentsLastName,\n"
                    + "	 se.LecturersID,\n"
                    + "	 se.CourseID,\n"
                    + "	 se.SlotID,\n"
                    + "	 se.Room\n"
                    + " FROM [dbo].StudentGroup sg\n"
                    + " JOIN [dbo].[Session] se \n"
                    + " on sg.GroupID = se.GroupID\n"
                    + " JOIN [dbo].Students st\n"
                    + " on sg.StudentsID = st.StudentsID\n"
                    + " Where se.SessionID like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, SessionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance at = new Attendance();
                
                Students st = new Students();
                st.setStudentsFirstName(rs.getString(SessionID));
                st.setStudentsMiddleName(sql);
                st.setStudentsLastName(sql);
                at.setStudents(st);
                
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
