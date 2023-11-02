/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDBContext;
import entities.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

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
        request.getRequestDispatcher("./view/login.jsp").forward(request, response);
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        Account a = new Account();
        a.setUsername(username);
        a.setPassword(password);
        AccountDBContext accDB = new AccountDBContext();
         ArrayList<Account> loggedAccount = accDB.getAccount(a);
        // get username, password, displayname
        if (loggedAccount == null) {
            response.getWriter().print("Login Failed");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loggedAccount", loggedAccount);
            response.getWriter().print("Login successfull!");
        }
    }
}
