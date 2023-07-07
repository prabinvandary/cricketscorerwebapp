package com.mycompany.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.api.baseController.ApiResponse;
import com.mycompany.enumvalues.PlayerRole;
import com.mycompany.model.Player;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Entity;

@RequestScoped
public class PlayerClient implements Serializable {

    private List<Player> players;
    Client client;
    WebTarget target;
    String baseUrl = "http://10.120.3.205:8080/cricketwebapp-1.0-SNAPSHOT/cricketWebApp/player";

    public PlayerClient() {
        this.client = ClientBuilder.newClient();
        this.target = client.target(baseUrl);
    }

    public List<Player> getPlayers() {
        ApiResponse apiResponse = target.request(MediaType.APPLICATION_JSON).get(ApiResponse.class);
        Object object = apiResponse.getData();
        List<Player> player = (List<Player>) object;
        this.players = player;
        return players;
    }

    public ApiResponse savePlayer(Player player) throws IOException {
        String playerJson = new ObjectMapper().writeValueAsString(player);
        return target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).buildPost(Entity.json(playerJson)).invoke(ApiResponse.class);
    }

    public ApiResponse deletePlayer(Long id) {
        target.path("/{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON).buildDelete().invoke(ApiResponse.class);
        return null;
    }

    public ApiResponse updatePlayer(Long id, Player player) throws IOException {
        String playerJson = new ObjectMapper().writeValueAsString(player);
        return target.path("/{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).buildPut(Entity.json(playerJson)).invoke(ApiResponse.class);
    }

    public Player getPlayerById(Long id) {
        ApiResponse apiResponse = target.path("/{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON).get(ApiResponse.class);
        Object object = apiResponse.getData();
        Player player = convert((LinkedHashMap) object);
        return player;
    }

    public Player convert(LinkedHashMap map) {
        Player player = new Player();
        player.setId(Long.valueOf(String.valueOf((Integer) map.get("id"))));
        player.setName((String) map.get("name"));
        player.setAddress((String) map.get("address"));
        player.setPlayerRole(PlayerRole.valueOf((String) map.get("playerRole")));
        return player;
    }
}
