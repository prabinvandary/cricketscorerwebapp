/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.matchSummary;

import com.mycompany.model.MatchSummary;
import com.mycompany.pojo.cricketMatch.MatchSummaryDetailRequestPojo;

/**
 *
 * @author prabin
 */
public interface MatchSummaryService {
    MatchSummary saveMatchSummaryService(MatchSummaryDetailRequestPojo requestPojo);
}
