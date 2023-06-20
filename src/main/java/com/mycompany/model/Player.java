/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.PlayerRole;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {
    
    private String name;
    private PlayerRole playerRole;
    private String address;
    @Id
    private Long id;
    
    public Player() {
    }
    
    public Player(Integer id, String name, PlayerRole role, String address) {
        this.name = name;
        this.playerRole = role;
        this.address = address;
    }
    
    public PlayerRole getPlayerRole() {
        return playerRole;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
