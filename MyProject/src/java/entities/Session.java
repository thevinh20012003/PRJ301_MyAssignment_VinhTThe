/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class Session extends BaseEntity {

    private int id;
    private Date date;
    private Time_Slot time;
    private Group group;
    private int index;
    private Room room;
    private Instructor instructor;
    private Subject subject;
    private boolean isAtt;
    private ArrayList<Attendance> atts = new ArrayList<>();

    public Session(int id, Date date, Time_Slot time, Group group, int index, Room room, Instructor instructor, Subject subject, boolean isAtt) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.group = group;
        this.index = index;
        this.room = room;
        this.instructor = instructor;
        this.subject = subject;
        this.isAtt = isAtt;
    }

    public Session() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time_Slot getTime() {
        return time;
    }

    public void setTime(Time_Slot time) {
        this.time = time;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isIsAtt() {
        return isAtt;
    }

    public void setIsAtt(boolean isAtt) {
        this.isAtt = isAtt;
    }

    public ArrayList<Attendance> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<Attendance> atts) {
        this.atts = atts;
    }

    
}
