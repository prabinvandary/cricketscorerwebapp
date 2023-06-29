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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@ViewScoped
public class TeamController implements Serializable {

    @Inject
    private TeamRepository teamRepository;

    private Team team;

    private List<Team> teams;

    private Boolean isTeamListEmpty;

    public Team getTeam() {
        return team;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    public void init() {
        team = new Team();
    }

    public void beforeCreate() {
        team = new Team();
    }

    public void saveTeam() {
        teamRepository.saveData(team);
        team = new Team();
    }

    public List<Team> getAllTeam() {
        setTeams(teamRepository.getAllData());
        return teamRepository.getAllData();
    }

    public Team getTeamById() {
        return getTeamRepository().getById(team.getId());
    }

    public Team beforeEdit(Team t) {
        return this.team = teamRepository.getById(t.getId());
    }

    public void delete(Team t) {
        teamRepository.removeEntity(t);
    }

    public void setIsTeamListEmpty(Boolean isTeamListEmpty) {
        this.isTeamListEmpty = (teams.isEmpty() || teams.contains(null)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean getIsTeamListEmpty() {
        return isTeamListEmpty;
    }

    public Team getById(Long id) {
        return getTeamRepository().getById(id);
    }
}
