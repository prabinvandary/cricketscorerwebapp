package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    private String name;

    private String address;

    private String manager;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Team() {
    }

    public Team(Long id, String name, String address, String manager) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public String getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
