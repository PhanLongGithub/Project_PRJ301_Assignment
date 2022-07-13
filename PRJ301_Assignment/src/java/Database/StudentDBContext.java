/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Campus;
import Model.Session;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Students;

/**
 *
 * @author ADMIN
 */
public class StudentDBContext extends DBContext {

    @Override
    public ArrayList<Students> list() {
        ArrayList<Students> students = new ArrayList<>();
        try {
            String sql = "SELECT [StudentsID]\n"
                    + "      ,[StudentsLastName]\n"
                    + "      ,[StudentsMiddleName]\n"
                    + "      ,[StudentsFirstName]\n"
                    + "      ,[StudentsEmail]\n"
                    + "      ,[CampusID]\n"
                    + "  FROM [dbo].[Students]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setStudentsID(rs.getString("StudentsID"));
                s.setStudentsFirstName(rs.getString("StudentsFirstName"));
                s.setStudentsMiddleName(rs.getString("StudentsMiddleName"));
                s.setStudentsLastName(rs.getString("StudentsLastName"));
                s.setStudentsEmail(rs.getString("StudentsEmail"));
                
                Campus c = new Campus();
                c.setCampusID(rs.getInt("CampusID"));
                s.setCampus(c);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
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
