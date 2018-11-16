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
public class Course {
    private char[] code = null;
    private String title = null;

    public Course() {
    }
    
    public Course(char[] code, String title) {
        this.code = code;
        this.title = title;
    }

    public char[] getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setCode(char[] code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + '}';
    }
    
}
