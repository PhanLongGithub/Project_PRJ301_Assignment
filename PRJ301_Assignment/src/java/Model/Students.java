/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Students {

    private String StudentsID;
    private String StudentsLastName;
    private String StudentsMiddleName;
    private String StudentsFirstName;
    private String StudentsEmail;
    private Campus campus;

    public Students() {
    }

    public String getStudentsID() {
        return StudentsID;
    }

    public void setStudentsID(String StudentsID) {
        this.StudentsID = StudentsID;
    }

    public String getStudentsLastName() {
        return StudentsLastName;
    }

    public void setStudentsLastName(String StudentsLastName) {
        this.StudentsLastName = StudentsLastName;
    }

    public String getStudentsMiddleName() {
        return StudentsMiddleName;
    }

    public void setStudentsMiddleName(String StudentsMiddleName) {
        this.StudentsMiddleName = StudentsMiddleName;
    }

    public String getStudentsFirstName() {
        return StudentsFirstName;
    }

    public void setStudentsFirstName(String StudentsFirstName) {
        this.StudentsFirstName = StudentsFirstName;
    }

    public String getStudentsEmail() {
        return StudentsEmail;
    }

    public void setStudentsEmail(String StudentsEmail) {
        this.StudentsEmail = StudentsEmail;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

}
