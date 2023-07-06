/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.PlayerPosition;
import com.mycompany.model.Player;
import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.model.TeamTournament;
import com.mycompany.pojo.PlayerTeamTournamentDetailRequestPojo;
import com.mycompany.repository.PlayerRepository;
import com.mycompany.repository.PlayerTeamTournamentRepository;
import com.mycompany.repository.TeamTournamentRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
public class PlayerTeamTournamentController implements Serializable {

    private PlayerTeamTournament playerTeamTournament;

    private Long teamId;

    private PlayerTeamTournamentDetailRequestPojo requestPojo;

    private List<PlayerTeamTournamentDetailRequestPojo> listOfRequestPojo;

    private Long teamTournamentId;

    private PlayerPosition[] getPlayerPosition;

    @Inject
    PlayerTeamTournamentRepository playerTeamTournamentRepository;

    @Inject
    PlayerRepository playerRepository;

    @Inject
    TeamTournamentRepository teamTournamentRepository;

    public PlayerTeamTournament getPlayerTeamTournament() {
        return playerTeamTournament;
    }

    public void setPlayerTeamTournament(PlayerTeamTournament playerTeamTournament) {
        this.playerTeamTournament = playerTeamTournament;
    }

    public PlayerTeamTournamentDetailRequestPojo getRequestPojo() {
        return requestPojo;
    }

    public void setRequestPojo(PlayerTeamTournamentDetailRequestPojo requestPojo) {
        this.requestPojo = requestPojo;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<PlayerTeamTournamentDetailRequestPojo> getListOfRequestPojo() {
        return listOfRequestPojo;
    }

    public void setListOfRequestPojo(List<PlayerTeamTournamentDetailRequestPojo> listOfRequestPojo) {
        this.listOfRequestPojo = listOfRequestPojo;
    }

    public Long getTeamTournamentId() {
        return teamTournamentId;
    }

    public void setTeamTournamentId(Long teamTournamentId) {
        this.teamTournamentId = teamTournamentId;
    }

    public PlayerPosition[] getGetPlayerPosition() {
        return PlayerPosition.values();
    }

    public void beforeCreate() {
        requestPojo = new PlayerTeamTournamentDetailRequestPojo();
        requestPojo.setTeamTournamentId(getTeamTournamentId());
    }

    @PostConstruct
    public void init() {
        requestPojo = new PlayerTeamTournamentDetailRequestPojo();
    }

    public void initialize() {
        if (teamTournamentId != null) {
            return;
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.teamTournamentId = Long.valueOf(facesContext.getExternalContext().getRequestParameterMap().get("teamTournamentId"));
        if (teamTournamentId == null) {
            throw new IllegalArgumentException("The teamTournamentId parameter is not set.");
        }
    }

    public void savePlayerTeamTournament() {
        try {
            playerTeamTournament = new PlayerTeamTournament();
            if (requestPojo.getId() != null) {
                playerTeamTournament = playerTeamTournamentRepository.getById(requestPojo.getId());
                if (playerTeamTournament == null) {
                    playerTeamTournament = new PlayerTeamTournament();
                }
            }
            TeamTournament teamTournament = teamTournamentRepository.getById(requestPojo.getTeamTournamentId());
            if (teamTournament == null) {
                throw new RuntimeException("Team tournament not found by given Id");
            }
            Player player = playerRepository.getById(requestPojo.getPlayerId());
            if (player == null) {
                throw new RuntimeException("Player not found by given id.");
            }
            playerTeamTournament.setPlayer(player);
            playerTeamTournament.setTeamTournament(teamTournament);
            playerTeamTournament.setIsWicketKeeper(requestPojo.getIsWicketKeeper());
            playerTeamTournament.setPlayerPosition(requestPojo.getPlayerPosition());
            playerTeamTournament = playerTeamTournamentRepository.saveData(playerTeamTournament);
            if (playerTeamTournament != null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Player team tournament save successful.",
                                " Player team tournament saved successfully"));

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                " Player team tournament save unsuccessful.",
                                "Player team tournament is not saved."));

            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Couldnot save data");
        }
    }

    public List<PlayerTeamTournament> getAllPlayerOfTheTeam() {
        return playerTeamTournamentRepository.getAllPlayerTeamTournamentByTournamentId(getTeamTournamentId());
    }

    public void delete(PlayerTeamTournament ptt) {
        playerTeamTournamentRepository.removeEntity(ptt);
    }
}
