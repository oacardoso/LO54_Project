/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mperrot
 */
public class Client {
    private int id = -1;
    private String last_name = null;
    private String first_name = null;
    private String address = null;
    private String phone = null;
    private String email = null;
    private Set sessions;

    public Client() {
    }
    
    public Client(String last_name, String first_name, String address, String phone, String email) {
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    public Set getSessions() {
        return sessions;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSessions(Set sessions) {
        this.sessions = sessions;
    }
    
    public Set addSessions(Set sessions) {
        Set f_sessions = new HashSet();
        if (sessions != null && !sessions.isEmpty())
        {
            if (this.sessions != null && !this.sessions.isEmpty())
            {
                for(Object session : this.sessions)
                {
                    for(Object session_b : sessions)
                    {
                        if (((Session)session).getId() == ((Session)session_b).getId() )
                        {
                            f_sessions.add(session_b);
                            sessions.remove(session_b);
                            break;
                        }
                    }
                }
                this.sessions.addAll(sessions);
            }
            else
                this.sessions = sessions;
        }
        return f_sessions;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", sessions=" + sessions + '}';
    }
    
}
