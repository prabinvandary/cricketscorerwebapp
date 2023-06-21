//package com.mycompany.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
////@Entity
//@Table(name = "team")
//public class Team implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "team_seq_gen", name = "team_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "team_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "address")
//    private String address;
//    @Column(name = "manager")
//    private String manager;
//
//    public Team() {
//    }
//
//    public Team(Integer id, String name, String address, String manager) {
//        this.name = name;
//        this.address = address;
//        this.manager = manager;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getManager() {
//        return manager;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setManager(String manager) {
//        this.manager = manager;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//}
