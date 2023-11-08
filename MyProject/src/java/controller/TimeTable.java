/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.Authentication.BasedAuthentication;
import dal.AccountDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import entities.Account;
import entities.Session;
import entities.Time_Slot;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateTimeHelper;

/**
 *
 * @author Admin
 */
public class TimeTable extends BasedAuthentication {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int instructorid = Integer.parseInt(request.getParameter("id"));
        String r_from = request.getParameter("from");
        String r_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();

        if (r_from == null)//this week
        {
            dates = DateTimeHelper.getCurrentWeekDates();
        } else {
            try {
                dates = DateTimeHelper.getSqlDatesInRange(r_from, r_to);
            } catch (ParseException ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // oke
        TimeSlotDBContext timeDB = new TimeSlotDBContext();
        ArrayList<Time_Slot> slots = timeDB.list();

        // 
        SessionDBContext sessDB = new SessionDBContext();
        ArrayList<Session> sessions = sessDB.getSessions(instructorid, dates.get(0), dates.get(dates.size() - 1));

        AccountDBContext accDB = new AccountDBContext();
        Account accounts = accDB.getAccount(r_from, r_to);
        
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("from", dates.get(0));
        request.setAttribute("to", dates.get(dates.size() - 1));
        request.setAttribute("sessions", sessions);

        request.getRequestDispatcher("view/timetable.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processGet(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processPost(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
