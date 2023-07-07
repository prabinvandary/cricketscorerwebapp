/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.PlayerRole;
import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import com.mycompany.restclient.PlayerClient;
import java.io.IOException;
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

    @Inject
    PlayerClient playerClient;

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

    public void beforeCreate() {
        player = new Player();
    }

    public Player beforeEdit(Player p) {
//                return this.player = playerRepository.getById(p.getId());
        this.player = getPlayerById(p.getId());
        return this.player = getPlayerById(p.getId());

    }

    public void beforeEditPlayer(Long id) {
//                return this.player = playerRepository.getById(p.getId());
        this.player = getPlayerById(id);
    }

    public void delete(Player p) {
        playerRepository.removeEntity(p);
    }

    public void deletePlayer(Long id) {
        playerClient.deletePlayer(id);
    }

    public Player getPlayerById(Long id) {
        return playerClient.getPlayerById(id);
    }

    public void updatePlayer() throws IOException {
        playerClient.updatePlayer(player.getId(), player);
    }

    public void savePlayer() throws IOException {
        playerClient.savePlayer(player);
//        player = playerRepository.saveData(player);
//        if (player != null) {
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Player save successful.",
//                            " Player saved successfully"));
//
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            " Player save unsuccessful.",
//                            "Player is not saved."));
//
//        }
        player = new Player();
    }

    public List<Player> getAllPlayer() {
        setPlayers(playerClient.getPlayers());
        setIsPlayerListEmpty((players.isEmpty() || players == null) ? Boolean.TRUE : Boolean.FALSE);
        return playerClient.getPlayers();
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

    public void savePlayerFromApi(Player player) {
        Player player1 = new Player();
        if (player.getId() != null) {
            player1 = playerRepository.getById(player.getId());
        }
        player1.setAddress(player.getAddress());
        player1.setName(player.getName());
        player1.setPlayerRole(player.getPlayerRole());
        playerRepository.saveData(player1);
    }
}
