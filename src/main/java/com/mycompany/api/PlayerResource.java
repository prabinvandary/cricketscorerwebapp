/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api;

import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import java.util.List;
import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
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
@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @Inject
    PlayerRepository playerRepository;
    
    @POST
    public Boolean savePlayer(Player player) throws JsonParsingException{
        playerRepository.saveData(player);
        return Boolean.TRUE;
    }

    @GET
    public List<Player> getAllPlayer() {
        return playerRepository.getAllData();
    }
}
