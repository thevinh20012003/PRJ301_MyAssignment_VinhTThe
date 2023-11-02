/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Campus extends BaseEntity{
    private int cid;
    private String cname;
    ArrayList<Account> listStudents = new ArrayList<>();

    public Campus() {
    }

    public Campus(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public ArrayList<Account> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Account> listStudents) {
        this.listStudents = listStudents;
    }
}
