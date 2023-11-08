/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Account;
import entities.Instructor;
import entities.BaseEntity;
import entities.Campus;
import entities.Instructor;
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
public class AccountDBContext extends DBContext {

    public Account getAccount(String username, String password) {
        try {
            String sql = "select a.username,a.password,a.[displayname], c.cid,c.cname,i.iid from Account a \n"
                    + "inner join campus c on a.cid = c.cid\n"
                    + "inner join Instructor i on i.iid = a.iid\n"
                    + "where a.username =? and a.password =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setDisplayname(rs.getString("displayname"));

                Campus c = new Campus();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                a.setCampus(c);

                Instructor i = new Instructor();
                i.setId(rs.getInt("iid"));
                a.setInstructor(i);
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BaseEntity get(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
