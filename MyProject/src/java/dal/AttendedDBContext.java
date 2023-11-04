/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Attendance;
import entities.Session;
import entities.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AttendedDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> getAttendances(int sesid) {
        ArrayList<Attendance> atts = new ArrayList<>();
        try {
            String sql = "select st.stid,st.name,ISNULL(a.status,0) as [status],ISNULL(a.description,'')as [description],ISNULL(a.date_time,GETDATE()) AS [att_datetime] from Session s\n"
                    + "                     inner join [Group] g on s.gid = g.gid\n"
                    + "                     inner join Group_student gs on gs.gid = g.gid\n"
                    + "                     inner join Student st on st.stid = gs.stid\n"
                    + "                     left join Attendance a on st.stid = a.stid\n"
                    + "					 and s.sesid = a.sesid\n"
                    + "                     where s.sesid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sesid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                Student s = new Student();
                Session session = new Session();

                s.setStid(rs.getInt("stid"));
                s.setStname(rs.getString("name"));

                session.setId(sesid);

                att.setStudent(s);
                att.setSession(session);
                att.setStatus(rs.getBoolean("status"));
                att.setDescription(rs.getString("description"));
                att.setDatetime(rs.getTimestamp("att_datetime"));
                atts.add(att);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendedDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
