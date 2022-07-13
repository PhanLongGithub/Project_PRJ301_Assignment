/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Campus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Lecturers;

/**
 *
 * @author ADMIN
 */
public class LecturersDBContext extends DBContext {

    @Override
    public ArrayList<Lecturers> list() {
        ArrayList<Lecturers> lecturers = new ArrayList<>();
        try {
            String sql = "SELECT [LecturersID]\n"
                    + "      ,[LecturersLastName]\n"
                    + "      ,[LecturersMiddleName]\n"
                    + "      ,[LecturersFirstName]\n"
                    + "      ,[LecturersEmail]\n"
                    + "      ,[CampusID]\n"
                    + "  FROM [dbo].[Lecturers]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lecturers lec = new Lecturers();
                lec.setLecturersID(rs.getString("LecturersID"));
                lec.setLecturersFirstName(rs.getString("LecturersFirstName"));
                lec.setLecturersMiddleName(rs.getString("LecturersMiddleName"));
                lec.setLecturersLastName(rs.getString("LecturersLastName"));
                lec.setLecturersEmail(rs.getString("LecturersEmail"));
                
                Campus campus = new Campus();
                campus.setCampusID(rs.getInt("CampusID"));
                lec.setCampus(campus);
                
                lecturers.add(lec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lecturers;
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
