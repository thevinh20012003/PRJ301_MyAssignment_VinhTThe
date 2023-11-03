/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Group;
import entities.Room;
import entities.Session;
import entities.Subject;
import entities.Time_Slot;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Session> getSessions(int iid, Date from, Date to) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "Select s.sesid,s.date,r.rid,t.tid,g.gid,g.gname,su.suid,su.suname,i.iid,i.iname,s.isAtt from Session s \n"
                    + "inner join Instructor i on i.iid = s.iid\n"
                    + "inner join [Group] g on g.gid = s.gid\n"
                    + "inner join Time_slot t on s.tid = t.tid\n"
                    + "inner join room r on r.rid =s.rid\n"
                    + "inner join subject su on su.suid = g.suid\n"
                    + "where i.iid =? and s.date >= ? and s.date <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, iid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setId(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIsAtt(rs.getBoolean("isAtt"));

                Room room = new Room();
                room.setRid(rs.getString("rid"));
                session.setRoom(room);

                Time_Slot t = new Time_Slot();
                t.setId(rs.getInt("tid"));
                session.setTime(t);

                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));

                session.setGroup(g);

                Subject subject = new Subject();
                subject.setSuid(rs.getString("suid"));
                subject.setSuname(rs.getString("suname"));
                session.setSubject(subject);
                sessions.add(session);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(Session entity) {
        try {
            String sql = "Select s.sesid,s.date,r.rid,t.tid,t.description   ,g.gid,g.gname,su.suid,su.suname,i.iid,i.iname,s.isAtt from Session s \n"
                    + "inner join Instructor i on i.iid = s.iid\n"
                    + "inner join [Group] g on g.gid = s.gid\n"
                    + "inner join Time_slot t on s.tid = t.tid\n"
                    + "inner join room r on r.rid =s.rid\n"
                    + "inner join subject su on su.suid = g.suid\n"
                    + "where s.sesid =? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setId(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIsAtt(rs.getBoolean("isAtt"));

                Room room = new Room();
                room.setRid(rs.getString("rid"));
                session.setRoom(room);

                Time_Slot t = new Time_Slot();
                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                session.setTime(t);

                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getString("gname"));

                session.setGroup(g);

                Subject subject = new Subject();
                subject.setSuid(rs.getString("suid"));
                subject.setSuname(rs.getString("suname"));
                session.setSubject(subject);
                return session;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
