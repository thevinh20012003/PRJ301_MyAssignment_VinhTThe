/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Authentication;

import dal.AccountDBContext;
import entities.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("pass");
        AccountDBContext db = new AccountDBContext();
        Account account = db.getAccount(username, password);

        if (account != null) {
            request.getSession().setAttribute("account", account);
            Cookie c_user = new Cookie("email", username);
            Cookie c_pass = new Cookie("pass", password);
            c_user.setMaxAge(3600 * 24);
            c_pass.setMaxAge(3600 * 24);
            response.addCookie(c_user);
            response.addCookie(c_pass);
            request.getRequestDispatcher("view/Home.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("account", null);
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }
}
