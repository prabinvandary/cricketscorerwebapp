/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Team;
import com.mycompany.repository.TeamRepository;
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
public class TeamControllerDemo implements Serializable {

    @Inject
    private TeamRepository teamRepository;

    private Team team;
    
    private Boolean isTeamListEmpty;
    
    private List<Team> teams;



    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    
    @PostConstruct
    public void init() {
        team = new Team();
    }

    public void beforCreate() {
        team = new Team();
    }

    public Team beforeEdit(Team p) {
        return this.team = teamRepository.getById(p.getId());
    }

    public void delete(Team p) {
        teamRepository.removeEntity(p);
    }

    public void saveTeam() {
        teamRepository.saveData(team);
        team = new Team();
    }

    public List<Team> getAllTeam() {
        setTeams(teamRepository.getAllData());
        setIsTeamListEmpty((teams.isEmpty() || teams==null) ? Boolean.TRUE : Boolean.FALSE);
        return teamRepository.getAllData();
    }

    public Team getTeamById() {
        return teamRepository.getById(team.getId());

    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
    }

    public void setIsTeamListEmpty(Boolean isTeamListEmpty) {
        this.isTeamListEmpty = (teams.isEmpty() || teams == null) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean getIsTeamListEmpty() {
        return isTeamListEmpty;
    }

}
