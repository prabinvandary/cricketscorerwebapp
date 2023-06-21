/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bundle;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named(value = "bundle")
@SessionScoped
public class Bundle {

    private String player;

    private String createPlayerTitle;

    public String getPlayer() {
        return "Player";
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getCreatePlayerTitle() {
        return "Create Player";
    }

    public void setCreatePlayerTitle(String createPlayerTitle) {
        this.createPlayerTitle = createPlayerTitle;
    }
    
    
}
