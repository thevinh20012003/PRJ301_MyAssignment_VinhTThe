<%-- 
    Document   : attendance
    Created on : Nov 3, 2023, 12:20:22 AM
    Author     : Admin
--%>

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
    </body>
</html>
