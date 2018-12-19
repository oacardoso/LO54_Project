/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author mperrot
 */
@Entity
@Table(name="CLIENT",  uniqueConstraints = {@UniqueConstraint(columnNames={"ID"})})
public class Client implements Serializable {

    @Id
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

    public boolean addSession(Session session) {
        if (session != null) {
            if (this.sessions != null) {
                for (Object s : this.sessions) {
                    if (((Session) s).getId() == session.getId()) {
                        return false;
                    }
                }
                this.sessions.add(session);
            } else {
                this.sessions = new HashSet();
                this.sessions.add(session);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", sessions=" + sessions + '}';
    }

}
