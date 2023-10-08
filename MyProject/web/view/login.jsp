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
        <link rel="stylesheet" href="login.css">
        <style>
            body {
                background-image: url('background_login.jpg'); /* Thay 'link_background.jpg' bằng URL của hình nền */
                background-size: cover;
            }

            header {
                background-color: orange;
                text-align: left;
                padding: 10px;
                color: black;

            }

            .header-content {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .header-content img {
                max-height: 50px;
            }

            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh; /* Để căn giữa chiều dọc */
            }

            .form-container {
                background-color: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
                width: 33.33%; /* Chiếm 1/3 chiều rộng */
                text-align: center; /* Để căn giữa theo chiều ngang */
            }

            select, input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            button {
                background-color: orange;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            footer {
                text-align: center;
                color: green;
                margin-top: 20px;
            }

            a {
                text-decoration: none;
                color: green;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="logo_fpt">
                <img src="logo_fpt.jpg" alt="Logo_Fpt"></a>
            </div>
            <div class="header-content">
                <h1>FPT University Academic Portal</h1>
            </div>
            <div>
                <p>FAP mobile app(myFAP) is ready at</p>
                <a href="https://apps.apple.com/us/app/myfap/id1527723314"><img src="link_image1.jpg" alt="Image 1"></a>
                <a href="https://play.google.com/store/apps/details?id=com.fuct"><img src="link_image1.jpg" alt="Image 2"></a>
            </div>
        </header>
        <div class="form-container">
            <h2 style="color: orange;">Đăng nhập FAP</h2>
            <form>
                <select>
                    <option disabled selected value="" style="color: rgba(0, 0, 0, 0.3);">Sinh viên, giảng viên, phụ huynh</option>
                    <option value="sinhvien">Sinh viên</option>
                    <option value="giangvien">Giảng viên</option>
                    <option value="phuhuynh">Phụ huynh</option>
                </select>
                <select>
                    <option disabled selected value="" style="color: rgba(0, 0, 0, 0.3);">Select campus</option>
                    <option value="fu-hoalac">FU - Hòa Lạc</option>
                    <option value="fu-hochiminh">FU - Hồ Chí Minh</option>
                    <option value="fu-danang">FU - Đà Nẵng</option>
                    <option value="fu-cantho">FU - Cần Thơ</option>
                    <option value="fu-quynhon">FU - Quy Nhơn</option>
                </select>
                <input type="text" placeholder="Enter gmail">
                <input type="password" placeholder="Enter password">
                <button>Đăng nhập</button>
            </form>
        </div>
        <footer>
            @Power by <a href="https://fpt.edu.vn/">FPT University</a> | <a href="https://cmshn.fpt.edu.vn/">CMS</a> | <a href="https://library.fpt.edu.vn/">Library books24x7</a> | <a href="https://library.books24x7.com/login.asp?ic=0">books24x7</a>
        </footer>
    </body>
</html>


