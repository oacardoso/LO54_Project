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
public class Client {
    private int id = -1;
    private String last_name = null;
    private String first_name = null;
    private String address = null;
    private char[] phone = null;
    private String email = null;

    public Client() {
    }
    
    public Client(String last_name, String first_name, String address, char[] phone, String email) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    
    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getAddress() {
        return address;
    }

    public char[] getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(char[] phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }
    
}
