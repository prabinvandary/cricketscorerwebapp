package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team extends GenericAbstractClass {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String manager;

    public Team() {
    }

    public Team(Long id, String name, String address, String manager) {
        this.setId(id);
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

    @Override
    public String getTableName() {
        return "team";
    }

    @Override
    public String toString() {
        return "" + getId();
    }

}
