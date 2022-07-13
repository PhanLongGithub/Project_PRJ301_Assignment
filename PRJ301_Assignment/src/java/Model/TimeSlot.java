/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

public class TimeSlot {

    private int SlotID;
    private int SlotNumber;
    private Date TimeFrom;
    private Date TimeTo;
    private String Term;

    public TimeSlot() {
    }

    public int getSlotID() {
        return SlotID;
    }

    public void setSlotID(int SlotID) {
        this.SlotID = SlotID;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int SlotNumber) {
        this.SlotNumber = SlotNumber;
    }

    public Date getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(Date TimeFrom) {
        this.TimeFrom = TimeFrom;
    }

    public Date getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(Date TiemTo) {
        this.TimeTo = TiemTo;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

}
