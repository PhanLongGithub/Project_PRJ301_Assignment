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

    public ArrayList<Attendance> searchBySession(int SessionID) {
        ArrayList<Attendance> atlist = new ArrayList<>();
        try {
            String sql = " SELECT st.[StudentsID],\n"
                    + "       st.StudentsFirstName,\n"
                    + "	   st.StudentsMiddleName,\n"
                    + "	   st.StudentsLastName,\n"
                    + "	   ts.TimeFrom,\n"
                    + "	   ts.Term,\n"
                    + "	   ts.SlotNumber,\n"
                    + "	   se.Room,\n"
                    + "	   se.CourseID,\n"
                    + "	   se.LecturersID,\n"
                    + "	   sg.GroupID\n"
                    + "      ,se.[SessionID]\n"
                    + "      ,at.[Commet]\n"
                    + "      ,at.[Status]\n"
                    + "      ,at.[RecordTime]\n"
                    + " FROM [dbo].StudentGroup sg\n"
                    + " JOIN [dbo].[Session] se \n"
                    + " on sg.GroupID = se.GroupID\n"
                    + " JOIN [dbo].Students st\n"
                    + " on sg.StudentsID = st.StudentsID\n"
                    + " JOIN [dbo].Attendance at\n"
                    + " on at.SessionID = se.SessionID and at.StudentsID = st.StudentsID\n"
                    + " JOIN [dbo].TimeSlot ts\n"
                    + " on ts.SlotID = se.SlotID\n"
                    + " Where se.SessionID like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, SessionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance at = new Attendance();

                Students st = new Students();
                st.setStudentsID(rs.getString("StudentsID"));
                st.setStudentsFirstName(rs.getString("StudentsFirstName"));
                st.setStudentsMiddleName(rs.getString("StudentsMiddleName"));
                st.setStudentsLastName(rs.getString("StudentsLastName"));

                TimeSlot time = new TimeSlot();
                time.setTimeFrom(rs.getDate("TimeFrom"));
                time.setTerm(rs.getString("Term"));
                time.setSlotNumber(rs.getInt("SlotNumber"));

                Courses co = new Courses();
                co.setCourseID(rs.getString("CourseID"));

                StudentGroups sg = new StudentGroups();
                sg.setGroupID(rs.getString("CourseID"));

                Lecturers lec = new Lecturers();
                lec.setLecturersID(rs.getString("LecturersID"));

                Session se = new Session();
                se.setSessionID(rs.getInt("SessionID"));
                se.setCourses(co);
                se.setGroups(sg);
                se.setSlot(time);
                se.setRoom(rs.getString("Room"));
                se.setLecturers(lec);

                at.setStudents(st);
                at.setSession(se);
                at.setCommet(rs.getString("Commet"));
                at.setRecordTime(rs.getDate("RecordTime"));
                at.setStatus(rs.getString("Status"));

                atlist.add(at);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atlist;
    }

    public void insert(Attendance model) {
        try {
            String sql = " INSERT INTO [dbo].[Attendance]\n"
                    + "           ([StudentsID]\n"
                    + "           ,[SessionID]\n"
                    + "           ,[Commet]\n"
                    + "           ,[Status]\n"
                    + "           ,[RecordTime])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getStudents().getStudentsID());
            stm.setInt(2, model.getSession().getSessionID());
            stm.setString(3, model.getCommet());
            stm.setString(4, model.getStatus());
            stm.setDate(5, model.getRecordTime());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Attendance check(int SessionID) {
        try {
            String sql = "SELECT [StudentsID]\n"
                    + "      ,[SessionID]\n"
                    + "  FROM [dbo].[Attendance]\n"
                    + "  where [SessionID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, SessionID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session se = new Session();
                se.setSessionID(rs.getInt("SessionID"));

                Students st = new Students();
                st.setStudentsID(rs.getString("StudentsID"));

                Attendance at = new Attendance();
                at.setSession(se);
                at.setStudents(st);
                return at;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
