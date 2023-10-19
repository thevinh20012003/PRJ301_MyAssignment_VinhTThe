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
        <title>Login jsp</title>
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
            <form>
                <select>
                    <option disabled selected value="" style="color: rgba(0, 0, 0, 0.3);">Select campus</option>
                    <option value="fu-hoalac">FU - Hòa Lạc</option>
                    <option value="fu-hochiminh">FU - Hồ Chí Minh</option>
                    <option value="fu-danang">FU - Đà Nẵng</option>
                    <option value="fu-cantho">FU - Cần Thơ</option>
                    <option value="fu-quynhon">FU - Quy Nhơn</option>
                </select>
                <input type="text" id="emailInput" placeholder="Enter gmail" >
                <input type="password" placeholder="Enter password">
                <button>Đăng nhập</button>
            </form>
        </div>
        <footer>
            @Power by <a href="https://fpt.edu.vn/">FPT University</a> | <a href="https://cmshn.fpt.edu.vn/">CMS</a> | <a href="https://library.fpt.edu.vn/">Library books24x7</a> | <a href="https://library.books24x7.com/login.asp?ic=0">books24x7</a>
        </footer>
    </body>
    <script src="js/check_email.js"></script>
</html>


