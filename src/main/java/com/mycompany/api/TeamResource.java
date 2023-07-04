/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api;

import com.mycompany.model.Team;
import com.mycompany.repository.TeamRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author prabin
 */
@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    private TeamRepository teamRepository;
    
    @GET
    public List<Team> getAllTeam(){
        return teamRepository.getAllData();
    }
    
    @POST
    public Boolean saveTeam(Team team){
        teamRepository.saveData(team);
        return Boolean.TRUE;
    }
}
