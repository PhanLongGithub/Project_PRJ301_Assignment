/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class TimeslotDBContext extends DBContext {

    @Override
    public ArrayList list() {
        ArrayList<TimeSlot> timeslot = new ArrayList<>();
        try {
            String sql = "SELECT [SlotID]\n"
                    + "      ,[SlotNumber]\n"
                    + "      ,[TimeFrom]\n"
                    + "      ,[TimeTo]\n"
                    + "      ,[Term]\n"
                    + "  FROM [dbo].[TimeSlot]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                TimeSlot slot = new TimeSlot();
                slot.setSlotID(rs.getInt("SlotID"));
                slot.setSlotNumber(rs.getInt("SlotNumber"));
                slot.setTimeTo(rs.getDate("TimeFrom"));
                slot.setTimeFrom(rs.getDate("TimeTo"));
                slot.setTerm(rs.getString("Term"));

                timeslot.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeslot;
    }

    public TimeSlot getTimeByID(int id) {
        TimeSlot slot = new TimeSlot();
        try {
            String sql = "SELECT [SlotID]\n"
                    + "      ,[SlotNumber]\n"
                    + "      ,[TimeFrom]\n"
                    + "      ,[TimeTo]\n"
                    + "      ,[Term]\n"
                    + "  FROM [dbo].[TimeSlot]\n"
                    + "  Where TimeSlot.SlotID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                slot.setSlotID(rs.getInt("SlotID"));
                slot.setSlotNumber(rs.getInt("SlotNumber"));
                slot.setTimeFrom(rs.getDate("TimeFrom"));
                slot.setTimeTo(rs.getDate("TimeTo"));
                slot.setTerm(rs.getString("Term"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slot;
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
