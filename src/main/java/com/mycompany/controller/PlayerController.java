/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.PlayerRole;
import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
    
    private Boolean isPlayerListEmpty;
    
    public PlayerRole[] getPlayerRoles() {
     return PlayerRole.values();
    }
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

    public void beforCreate() {
        player = new Player();
    }

    public Player beforeEdit(Player p) {
        return this.player = playerRepository.getById(p.getId());
    }

    public void delete(Player p) {
        playerRepository.removeEntity(p);
    }

    public void savePlayer() {
        playerRepository.saveData(player);
        player = new Player();
    }

    public List<Player> getAllPlayer() {
        setPlayers(playerRepository.getAllData());
        setIsPlayerListEmpty((players.isEmpty() || players == null) ? Boolean.TRUE : Boolean.FALSE);
        return playerRepository.getAllData();
    }

    public Player getPlayerById() {
        return playerRepository.getById(player.getId());

    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
    }

    public void setIsPlayerListEmpty(Boolean isPlayerListEmpty) {
        this.isPlayerListEmpty = (players.isEmpty() || players == null) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean getIsPlayerListEmpty() {
        return isPlayerListEmpty;
    }

}
