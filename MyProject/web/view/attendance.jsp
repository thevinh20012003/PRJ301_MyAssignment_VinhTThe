<%-- 
    Document   : attendance
    Created on : Nov 3, 2023, 12:20:22 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logoTitle.png" type="img/x-icon"/>
        <title>Attendance</title>
    </head>
    <body>
        ${requestScope.ses.group.gname}-${requestScope.ses.subject.suname} at ${requestScope.ses.room.rid}
        - ${requestScope.ses.time.description}
        <br/>
        <form action="attendance" method="post">
            <table border="1px"> 
                <tr>
                    <td>Student</td>
                    <td>Status</td>
                    <td>Description</td>
                    <td>Time</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.stname}
                        <input type="hidden" name="stid" value="${a.student.stid}"/></td>
                        <td>
                            <input type="radio" 
                                   <c:if test="${!a.status}">
                                       checked="checked"
                                   </c:if>
                                   name="status${a.student.stid}" value="absent"/>absent
                            <input type="radio" 
                                   <c:if test="${a.status}">
                                       checked="checked"
                                   </c:if>
                                   name="status${a.student.stid}" value="present"/>present
                        </td>
                        <td>
                            <input type="text" value="${a.description}" name="description${a.student.stid}">
                        </td>
                        <td>${a.datetime}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" value="${requestScope.ses.id}" name="sesid"/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
