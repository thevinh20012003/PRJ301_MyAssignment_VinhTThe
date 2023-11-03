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
public class Subject extends BaseEntity{
    private String suid;
    private String suname;
    private int termno;
    private ArrayList<Group> groups = new ArrayList<>();

    public Subject() {
    }

    public Subject(String suid, String suname, int termno) {
        this.suid = suid;
        this.suname = suname;
        this.termno = termno;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    public int getTermno() {
        return termno;
    }

    public void setTermno(int termno) {
        this.termno = termno;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
}
