/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.Authentication.BasedAuthentication;
import dal.AttendedDBContext;
import dal.SessionDBContext;
import entities.Account;
import entities.Session;
import entities.Attendance;
import entities.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class attendance extends BasedAuthentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException {
        SessionDBContext sesDB = new SessionDBContext();
        Session s = new Session();
        int id = Integer.parseInt(request.getParameter("id"));
        s.setId(id);
        Session ses = sesDB.get(s);
        request.setAttribute("ses", ses);

        AttendedDBContext attDB = new AttendedDBContext();
        ArrayList<Attendance> attendances = attDB.getAttendances(id);
        request.setAttribute("atts", attendances);

        request.getRequestDispatcher("/view/attendance.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, Account LoggedUser)
            throws ServletException, IOException {
        // Get a array student id as for each in attendance.jsp
        String[] stids = request.getParameterValues("stid");
        // delete record then insert each object att into db
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        ArrayList<Attendance> atts = new ArrayList<>();
        String mess = null;
        //each stid is a studentid
        for (String stid : stids) {
            int id = Integer.parseInt(stid);
            Attendance a = new Attendance();
            Student s = new Student();
            s.setStid(id);
            a.setStudent(s);
            a.setSession(ses);
            a.setDescription(request.getParameter("description" + stid));
            a.setStatus(request.getParameter("status" + stid).equals("present"));
            atts.add(a);
        }
        ses.setAtts(atts);
        SessionDBContext sesDB = new SessionDBContext();
        sesDB.addAttendances(ses);
        mess="Update Successfull!!!";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
