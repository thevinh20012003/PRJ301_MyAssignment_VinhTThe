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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" href="img/logoTitle.png" type="img/x-icon"/>
        <title>Attendance</title>
        <style>
            body {
                margin-left: 200px;
                margin-right: 200px;
            }
        </style>
    </head>
    <body>
          <form action="home" method="POST">
            <div class="row">
                <div class="col-md-8">
                    <h1><span>FPT University Academic Portal</span></h1>
                </div>
                <div class="col-md-4">
                    <table>
                        <tbody>
                            <tr>
                                <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>
                            </tr>
                            <tr>
                                <td><a href="https://apps.apple.com/app/id1527723314">
                                        <img src="https://fap.fpt.edu.vn/images/app-store.png"
                                             style="width: 120px; height: 40px" alt="apple store"></a></td>
                                <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                                        <img src="https://fap.fpt.edu.vn/images/play-store.png"
                                             style="width: 120px; height: 40px" alt="google store"></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
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
        <div class="footer">
            <div id="ctl00_divSupport" style="text-align: center">
                <br>
                <b>Mọi góp ý, thắc mắc xin liên hệ: </b><span
                    style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;">Phòng
                    dịch vụ sinh viên</span>: Email: <a
                    href="mailto:dichvusinhvien@fe.edu.vn">dichvusinhvien@fe.edu.vn</a>.
                Điện thoại: <span class="style1"
                                  style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;">(024)7308.13.13
                </span>
                <br>
            </div>

            <p style="text-align: center">
                © Powered by <a href="http://fpt.edu.vn" target="_blank">FPT University</a>&nbsp;|&nbsp;
                <a href="http://cms.fpt.edu.vn/" target="_blank">CMS</a>&nbsp;|&nbsp; <a
                    href="http://library.fpt.edu.vn" target="_blank">library</a>&nbsp;|&nbsp; <a
                    href="http://library.books24x7.com" target="_blank">books24x7</a>
                <span id="ctl00_lblHelpdesk"></span>
            </p>
        </div>
    </body>
</html>
