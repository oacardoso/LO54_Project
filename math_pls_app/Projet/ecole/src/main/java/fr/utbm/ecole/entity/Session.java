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
    private char[] start_date = null;
    private char[] end_date = null;
    private int max = -1;

    public Session() {
    }
    
    public Session(char[] start_date, char[] end_date, int max) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.max = max;
    }

    public int getId() {
        return id;
    }
    
    public char[] getStart_date() {
        return start_date;
    }

    public char[] getEnd_date() {
        return end_date;
    }

    public int getMax() {
        return max;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setStart_date(char[] start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(char[] end_date) {
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
