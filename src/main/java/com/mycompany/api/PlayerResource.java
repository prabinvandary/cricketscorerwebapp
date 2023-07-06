/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api;

import com.mycompany.api.baseController.ApiResponse;
import com.mycompany.api.baseController.BaseResource;
import com.mycompany.enumvalues.PlayerRole;
import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import com.mycompany.service.player.PlayerService;
import java.util.List;
import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author prabin
 */
@Path("/player")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource extends BaseResource {

    @Inject
    PlayerRepository playerRepository;
    @Inject
    PlayerService playerService;

    @POST
    public ApiResponse savePlayer(Player player) throws JsonParsingException {
        return success(200, "Player saved successully", playerRepository.saveData(player));
    }

    @GET
    public ApiResponse getAllPlayer() {
        return success(200, "Player saved successully", playerRepository.getAllData());
    }

    @GET
    @Path("/{id}")
    public Player getPlayerById(@PathParam("id") Long id) {
        return playerRepository.getById(id);
    }

    @PUT
    @Path("/{id}")
    public ApiResponse updatePlayerById(@PathParam("id") Long id, Player player) {
        return success(200, "Player updated successfully", playerService.upadtePlayer(id, player));
    }

    @DELETE
    @Path("/{id}")
    public ApiResponse deletePlayerById(@PathParam("id") Long id) {
        return success(200, "Player Deleted Successfully", playerService.deletePlayer(id));
    }

    @GET
    @Path("/playerRole")
    public ApiResponse getPlayerRoleApi() {
        return success(200, "Player api fetched successfully", PlayerRole.values());
    }

    @GET
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello world";
    }
}
