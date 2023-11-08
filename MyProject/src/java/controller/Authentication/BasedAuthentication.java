/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Authentication;

import dal.AccountDBContext;
import entities.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract public class BasedAuthentication extends HttpServlet {

    boolean isAuthenticated(HttpServletRequest request) {
        // get infor account from Session
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null) {
            return true;
        } else {
            String user = null;
            String pass = null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cooky : cookies) {
                if (user != null && pass != null) {
                    break;
                }
                if (cooky.equals("email")) {
                    user = cooky.getValue();
                }
                if (cooky.equals("pass")) {
                    pass = cooky.getValue();
                }
            }
            if (user != null && pass != null) {
                AccountDBContext db = new AccountDBContext();
                Account param = new Account();
                param.setUsername(user);
                param.setPassword(pass);
                // check accou is exin=st in database?
                account = db.getAccount(param.getUsername(), param.getPassword());
                if (account != null) {
                    // save session
                    request.getSession().setAttribute("account", db);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processGet(request, response, (Account) request.getSession().getAttribute("account"));
        } else {
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            processPost(request, response, (Account) request.getSession().getAttribute("account"));
        } else {
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
