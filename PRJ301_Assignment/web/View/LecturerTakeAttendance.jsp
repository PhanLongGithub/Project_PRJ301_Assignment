<%-- 
    Document   : LecturerTakeAttendance
    Created on : Jul 14, 2022, 4:56:36 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <p>SINGLE ACTIVITY ATTENDANCE</p>
            <p>Attendance for ${requestScope.course} with Lecturer ${requestScope.lec} at Slot ${requestScope.slotNumber} on ${requestScope.date}. ${requestScope.term} in room ${requestScope.room}</p>
            <table>
                <thead>
                    <tr>
                        <th>GROUP</th>
                        <th>NAME</th>
                        <th>COMMENT</th>
                        <th>TAKER</th>
                        <th>STATUS</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.list}" var="list">
                        <tr>
                            <td>${list.groups.groupID}</td>
                            <td>${list.groups.student.studentsLastName} ${list.groups.student.studentsMiddleName} ${list.groups.student.studentsFirstName}</td>
                            <td><input type="text" name = "comment"></td>
                            <td>${list.lecturers.lecturersID}</td>
                            <td>            
                                <input 
                                    <c:if test="${param.satus eq 'present'}">
                                        checked=true
                                    </c:if>
                                    type="radio" name="staus" value="present" /> Present<br>
                                <input checked=true type="radio" name="status" value="absent"/> Absent
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="SAVE">
        </form>
    </body>
</html>
