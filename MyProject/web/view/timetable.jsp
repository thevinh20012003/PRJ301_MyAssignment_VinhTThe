<%-- 
    Document   : timetable
    Created on : Nov 3, 2023, 12:20:00 AM
    Author     : Admin
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logoTitle.png" type="img/x-icon"/>
        <title>View Schedule</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/> 
        <div class="container">
            <h2>Activities for VinhTThe176288 (Trần Thế Vinh)</h2>
            <div>
                <p><mark>Note:</mark> These activities do not include extra-curriculum activities, such as club activities ...</p>
                <p><mark>Chú thích:</mark> Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa, ví dụ như hoạt động câu lạc bộ ...</p>
                <p>
                    Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...<br/>
                    Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..<br/>
                    Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...<br/>
                    Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.<br/>
                    Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..<br/>
                    Little UK (LUK) thuộc tầng 5 tòa nhà Delta
                </p>
            </div>
        </div>
        <table border="1">
            <tr>
                <td><form action="timetable" method="GET">
                        From <input type="date" name="from" value="${requestScope.from}"/> <br/>
                        To <input type="date" name="to" value="${requestScope.to}"/>
                        <input type="hidden" value="${param.id}" name="id"/>
                        <input type="submit" value="View"/>
                    </form></td>
                    <c:forEach items="${requestScope.dates}" var="d">
                    <td>
                        <fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="formattedDate" />
                        <p>${formattedDate}</p>
                    </td>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${ses.time.id eq s.id and ses.date eq d}">
                                    <a href="att?id=${ses.id}">
                                        ${ses.group.gname}-${ses.subject.suname} - ${ses.room.rid}
                                        <c:choose>
                                            <c:when test="${ses.isAtt}">
                                                <span style="color: green;">(attended)</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span style="color: red;">(Not yet)</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </c:if>
                            </c:forEach>

                        </td>
                    </c:forEach>
                </tr>  
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp"/> 
    </body>
</html>
