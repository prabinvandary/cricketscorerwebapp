/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@ViewScoped
public class PlayerController implements Serializable {

    @Inject
    private PlayerRepository playerRepository;

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void clearMultiViewState(Player player) {
    }
    
    @PostConstruct
    public void init() {
        player = new Player();
    }

    public String savePlayer() {
        System.out.println("Inside save");
        playerRepository.saveData(player);
        player = new Player();
        return "/faces/view/player/Create.xhtml?faces-redirect=true";
    }

    public String getAllPlayer() {
        System.out.println("Inside get all.");
        System.out.println(playerRepository.getAllData().stream().findFirst().get().getAddress());
        init();
        return "/faces/view/player/Create.xhtml?faces-redirect=true";
    }

    public String getPlayerById() {
        System.out.println("Inside Get by Id");
        System.out.println(playerRepository.getById(player.getId()).getName());
        init();
        return "/faces/view/player/Create.xhtml?faces-redirect=true";
    }
}
