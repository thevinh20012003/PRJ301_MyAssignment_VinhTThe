<%-- 
    Document   : login
    Created on : Oct 7, 2023, 4:11:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/logoTitle.png" type="img/x-icon"/>
        <title>FPT University Academic Portal</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <header>
            <div class="logo_fpt">
                <img src="img/Logo-FU-03.jpg" alt="Logo_Fpt" width="" height="100"></a>
            </div>
            <div class="header-content">
                <h1>FPT University Academic Portal</h1>
            </div>
            <div>
                <p>FAP mobile app(myFAP) is ready at</p>
                <a href="https://apps.apple.com/us/app/myfap/id1527723314"><img src="https://fap.fpt.edu.vn/images/app-store.png" alt="Apple_logo" width="120" height="40"></a>
                <a href="https://play.google.com/store/apps/details?id=com.fuct"><img src="https://fap.fpt.edu.vn/images/play-store.png" alt="google_play" width="120" height="40"></a>
            </div>
        </header>
        <div class="form-container">
            <h2 style="color: orange;">Đăng nhập FAP</h2>
            <form action="login" method="post">
                <select>
                    <option disabled selected value="" style="color: rgba(0, 0, 0, 0.3);">Select campus</option>
                    <option value="fu-hoalac">FU - Hòa Lạc</option>
                    <option value="fu-hochiminh">FU - Hồ Chí Minh</option>
                    <option value="fu-danang">FU - Đà Nẵng</option>
                    <option value="fu-cantho">FU - Cần Thơ</option>
                    <option value="fu-quynhon">FU - Quy Nhơn</option>
                </select>
                <input type="text" id="emailInput" placeholder="Enter gmail" name="email" required="">
                <input type="password" placeholder="Enter password" name="pass" required="">
                <a href="Home.jsp" ><button>Đăng nhập</button></a>
            </form>
        </div>
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


