<%-- 
    Document   : activitydetail
    Created on : Nov 4, 2023, 11:32:51 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University Academic Portal</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Acticity detail</h1>
        <div>
            Date: <fmt:formatDate value="${d}" pattern="EEEE dd-MM-yyy" var="formattedDate" />
            <p>${formattedDate}</p>
            Slot: ${requestScope.slots.id}
            Student group: ${requestScope.sessions.group.gname}
            Instructor: ${requestScope.sessions.instructor.name} 
            Course: ${requestScope.sessions.group.suid}
            Course session number: 
            Course session type:
            Course session description: 
            Campus/Programme: 
            Attendance: <c:if test="${requestScope.sessions.isAtt}">
                         attended
                        </c:if>
                        <c:if test="${!requestScope.sessions.isAtt}">
                         absent
                        </c:if>
            Record time:
        </div>
        <p>Mọi chú ý thắc mắc xin liên hệ: Phòng dịch vụ sinh viên: Email: <a href="mailto:dichvusinhvien@fe.edu.vn">dichvusinhvien@fe.edu.vn</a>. Điện thoại:(024)7308.13.13)</p>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
