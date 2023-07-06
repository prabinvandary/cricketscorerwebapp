/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.player;

import com.mycompany.model.Player;
import com.mycompany.repository.PlayerRepository;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
public class PlayerServiceImpl implements PlayerService {

    @Inject
    private PlayerRepository playerRepository;

    @Override
    public Player upadtePlayer(Long id, Player updatePlayer) {
        Player player = playerRepository.getById(id);
        if (player == null) {
            throw new RuntimeException("Player doesnot exist by given id.");
        }
        player.setAddress(updatePlayer.getAddress() != null ? updatePlayer.getAddress() : player.getAddress());
        player.setName(updatePlayer.getName() != null ? updatePlayer.getName() : player.getName());
        player.setPlayerRole(updatePlayer.getPlayerRole() != null ? updatePlayer.getPlayerRole() : player.getPlayerRole());
        return playerRepository.saveData(player);
    }

    @Override
    public Boolean deletePlayer(Long id) {
        Player player = playerRepository.getById(id);
        if (player == null) {
            throw new RuntimeException("Player doesnot exist by given id.");
        }
        
        playerRepository.removeEntity(player);
        return true;
    }

}
