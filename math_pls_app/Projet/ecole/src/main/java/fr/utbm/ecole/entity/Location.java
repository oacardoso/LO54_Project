/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author mperrot
 */
@Entity
@Table(name="LOCATION",  uniqueConstraints = {@UniqueConstraint(columnNames={"ID"})})
public class Location implements Serializable{
    @Id
    private int id = -1;
    private String city = null;

    public Location() {
    }

    public Location(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }
    
    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + '}';
    }
    
}
