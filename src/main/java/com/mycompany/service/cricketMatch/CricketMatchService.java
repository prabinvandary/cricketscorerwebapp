/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service.cricketMatch;

import com.mycompany.model.CricketMatch;
import com.mycompany.pojo.cricketMatch.CricketMatchDetailRequestPojo;

/**
 *
 * @author prabin
 */
public interface CricketMatchService {
    CricketMatch saveCricketMatch(CricketMatchDetailRequestPojo requestPojo);
}
