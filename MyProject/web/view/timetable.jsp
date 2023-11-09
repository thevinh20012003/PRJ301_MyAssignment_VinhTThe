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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                margin-left: 200px;
                margin-right: 200px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-8">
                <h1><span>FPT University Academic Portal</span></h1>
            </div>
            <div class="col-md-4 text-right">
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
            <div class="row">
                <div class="col-md-12 breadcrumb">
                    <div id="ctl00_divUser" style="float: right; margin-right: 16px;">
                        <a href="view/userDetail.jsp?view=user">
                            <span id="ctl00_lblLogIn" class="label label-success">${sessionScope.account.displayname}</span></a> |
                        <a href="<%= request.getContextPath() %>/logout" class="label label-success">logout</a> |
                        <span id="ctl00_lblCampusName" class="label label-success" "> Campus: FU-Hòa Lạc</span>
                    </div>
                    <!-- <div style="position: absolute; top: -35px; right: 30px; width: 150px;"></div> -->
                </div>
            </div>
        </div>

    </div>
    <div class="container">
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
    <table border="1" >
        <tr style="background-color: #0077be;">
            <td><form action="timetable" method="GET">
                    <span style="color: red;">From</span> <input type="date" name="from" value="${requestScope.from}"/> <br/>
                    <span style="color: red;">From</span> <input type="date" name="to" value="${requestScope.to}"/>
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
                                <a href="attendance?id=${ses.id}">
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
