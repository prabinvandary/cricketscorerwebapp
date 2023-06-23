/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

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

    private List<Player> players;

    private List<Player> filteredPlayers;

    private Player selectedPlayer;
    
    

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getFilteredPlayers() {
        return filteredPlayers;
    }

    public void setFilteredPlayers(List<Player> filteredPlayers) {
        this.filteredPlayers = filteredPlayers;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

    @PostConstruct
    public void init() {
        player = new Player();
    }

    public void savePlayer() {
        System.out.println("Inside save");
        playerRepository.saveData(player);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Player Saved Successfully",
                        "Player has been saved successfully"));
        init();
//        return "/faces/view/player/Create.xhtml?faces-redirect=true";
    }

    public List<Player> getAllPlayer() {
        System.out.println("Inside get all.");
        System.out.println(playerRepository.getAllData().stream().findFirst().get().getAddress());
        setPlayers(playerRepository.getAllData());
        return playerRepository.getAllData();
    }

    public String getPlayerById() {
        System.out.println("Inside Get by Id");
        System.out.println(playerRepository.getById(player.getId()).getName());
        init();
        return "/faces/view/player/Create.xhtml?faces-redirect=true";
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().clearTableStates();
    }

}
