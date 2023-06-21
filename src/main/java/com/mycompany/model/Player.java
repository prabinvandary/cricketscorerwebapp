/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.PlayerRole;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @SequenceGenerator(sequenceName = "player_seq_gen", name = "player_seq_gen", allocationSize = 1)
    @GeneratedValue(generator = "player_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "player_role")
    @Enumerated(EnumType.STRING)
    private PlayerRole playerRole;
    @Column(name = "address")
    private String address;

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
