<%-- 
    Document   : LecturerSchedule
    Created on : Jul 13, 2022, 11:21:05 AM
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
        <form action="../lecturer/schedule" method="POST">
            <!--            Campus-->
            <label for="campus">Campus: </label>
            <select name="campus" id="campus">
                <c:forEach items="${requestScope.campus}" var="c">
                    <option 
                        <c:if test="${param.campus eq c.campusID}">
                            selected="selected"
                        </c:if>
                        value="${c.campusID}">${c.campusName}</option>
                </c:forEach>
            </select>
            <br>
            <!--            Lecturer-->
            <label for="lecturer">Lecturer: </label>
            <select name="lecturer" id="lecturer">
                <c:forEach items="${requestScope.lecturers}" var="l">
                    <option 
                        <c:if test="${param.lecturer eq l.lecturersID}">
                            selected="selected"
                        </c:if>
                        value="${l.lecturersID}">${l.lecturersID}</option>
                </c:forEach>
            </select>
            <br>
            <label for="from">From: </label>
            <input type="date" value="from" name="from" id="from">
            <br>
            <label for="to">To:</label>
            <input type="date" value="to" name="to" id="to">
            <br>
            <input type="submit" value="SEARCH">
        </form>
        <c:if test="${requestScope.session ne null}">
            <table>
                <thead>
                    <tr>
                        <th id="slot">Slot</th>
                            <c:forEach items="${requestScope.date}" var="date">
                            <th>${date}</th>
                        </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.timeslot}" var="slot">
                        <tr>
                            <td headers="slot">${slot.slotNumber}</td>
                            <c:forEach items= "${requestScope.session}" var="se">
                                <c:if test="${se.slot.slotNumber eq slot.slotNumber}">
                                    <td>
                                        ${se.groups.groupID}<br>
                                        ${se.courses.courseID}<br>
                                        AT ${se.room}<br>
                                        ${se.sessionStatus}<br>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </c:if>
    </body>
</html>
