/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.entity;

/**
 *
 * @author mperrot
 */
public class Session {
    private int id = -1;
    private String start_date = null;
    private String end_date = null;
    private int max = -1;
    private Location location = null;
    private Course course = null;

    public Session() {
    }
    
    public Session(String start_date, String end_date, int max) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.max = max;
    }

    public int getId() {
        return id;
    }
    
    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getMax() {
        return max;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", max=" + max + '}';
    }    
    
}
