/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Lecturers {

    private String LecturersID;
    private String LecturersLastName;
    private String LecturersMiddleName;
    private String LecturersFirstName;
    private String LecturersEmail;
    private Campus campus;

    public Lecturers() {
    }

    public String getLecturersID() {
        return LecturersID;
    }

    public void setLecturersID(String LecturersID) {
        this.LecturersID = LecturersID;
    }

    public String getLecturersLastName() {
        return LecturersLastName;
    }

    public void setLecturersLastName(String LecturersLastName) {
        this.LecturersLastName = LecturersLastName;
    }

    public String getLecturersMiddleName() {
        return LecturersMiddleName;
    }

    public void setLecturersMiddleName(String LecturersMiddleName) {
        this.LecturersMiddleName = LecturersMiddleName;
    }

    public String getLecturersFirstName() {
        return LecturersFirstName;
    }

    public void setLecturersFirstName(String LecturersFirstName) {
        this.LecturersFirstName = LecturersFirstName;
    }

    public String getLecturersEmail() {
        return LecturersEmail;
    }

    public void setLecturersEmail(String LecturersEmail) {
        this.LecturersEmail = LecturersEmail;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus Campus) {
        this.campus = Campus;
    }

}
