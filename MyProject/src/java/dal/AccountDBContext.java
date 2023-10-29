/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Account;
import entities.Campus;
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

    public ArrayList<Account> list() {
        ArrayList<Account> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Account> getAccount(Account acc) {
        ArrayList<Account> listAccounts = new ArrayList<>();
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[cid]\n"
                    + "      ,[stuid]\n"
                    + "  FROM [Account] WHERE username=? AND password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, acc.getUsername());
            stm.setString(2, acc.getPassword());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setStuid(rs.getInt("stuid"));

                Campus c = new Campus();
                c.setCid(rs.getInt("cid"));
                a.setCid(c);
                listAccounts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccounts;
    }
}
