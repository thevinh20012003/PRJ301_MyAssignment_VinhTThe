/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Authentication;

import entities.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract public class BasedAuthentication extends HttpServlet {

    boolean isAuthenticated(HttpServletRequest request) {
        Account loggedAccount = (Account) request.getSession().getAttribute("loggedAccount");
        return loggedAccount != null;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            doGet(request, response, (Account) request.getSession().getAttribute("loggedAccount"));
        } else {
            response.getWriter().print("Access denied");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, Account loggedAccount)
            throws ServletException, IOException;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAuthenticated(request)) {
            doPost(request, response, (Account) request.getSession().getAttribute("loggedAccount"));
        } else {
            response.getWriter().print("Access denied");
        }
    }

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, Account loggedAccount)
            throws ServletException, IOException;

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
