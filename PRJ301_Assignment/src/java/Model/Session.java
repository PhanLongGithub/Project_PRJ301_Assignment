/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Session {

    private int SessionID;
    private StudentGroups groups;
    private Lecturers lecturers;
    private Courses courses;
    private TimeSlot slot;
    private String Room;
    private String SessionStatus;

    public Session() {
    }

    public int getSessionID() {
        return SessionID;
    }

    public void setSessionID(int SessionID) {
        this.SessionID = SessionID;
    }

    public StudentGroups getGroups() {
        return groups;
    }

    public void setGroups(StudentGroups groups) {
        this.groups = groups;
    }

    public Lecturers getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturers lecturers) {
        this.lecturers = lecturers;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public String getSessionStatus() {
        return SessionStatus;
    }

    public void setSessionStatus(String SessionStatus) {
        this.SessionStatus = SessionStatus;
    }

}
