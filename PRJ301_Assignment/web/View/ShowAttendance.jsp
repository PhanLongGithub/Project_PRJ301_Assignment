<%-- 
    Document   : ShowAttendance
    Created on : Jul 15, 2022, 3:30:39 PM
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
        <p>INSERT SUCCESS!!!!</p>
        <p>SINGLE ACTIVITY ATTENDANCE</p>
        <p>Attendance for ${requestScope.c} with Lecturer ${requestScope.lec} at Slot ${requestScope.sn} on ${requestScope.date}. ${requestScope.term} in room ${requestScope.room}</p>
        <table>
            <tr>
                <td>Group</td>
                <td>Name</td>
                <td>Comment</td>
                <td>Taker</td>
                <td>Status</td>
                <td>Record Time</td>
            </tr>
            <c:forEach items="${requestScope.list}" var="l">
                <tr>
                    <td>${l.session.groups.groupID}</td>
                    <td>${l.students.studentsLastName} ${l.students.studentsMiddleName} ${l.students.studentsFirstName}</td>
                    <td>${l.commet}</td>
                    <td>${l.session.lecturers.lecturersID}</td>
                    <td>${l.status}</td>
                    <td>${l.recordTime}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
