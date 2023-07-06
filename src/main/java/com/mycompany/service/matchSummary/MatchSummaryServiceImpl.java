/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.matchSummary;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.MatchSummary;
import com.mycompany.model.Player;
import com.mycompany.pojo.cricketMatch.MatchSummaryDetailRequestPojo;
import com.mycompany.repository.MatchRepository;
import com.mycompany.repository.MatchSummaryRepository;
import com.mycompany.repository.PlayerRepository;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
public class MatchSummaryServiceImpl implements MatchSummaryService {

    @Inject
    private MatchSummaryRepository matchSummaryRepository;

    @Inject
    private MatchRepository matchRepository;

    @Inject
    private PlayerRepository playerRepository;

    @Override
    public MatchSummary saveMatchSummaryService(MatchSummaryDetailRequestPojo requestPojo) {
        MatchSummary matchSummary = new MatchSummary();
        Player bowler = playerRepository.getById(requestPojo.getBowlerId());
        if (bowler == null) {
            throw new RuntimeException("Bowler not found by given id.");
        }

        Player batsmen = playerRepository.getById(requestPojo.getBatsMenId());
        if (batsmen == null) {
            throw new RuntimeException("Batsmen not found by given id.");
        }
        
        CricketMatch cricketMatch=matchRepository.getById(requestPojo.getMatchId());
        if (cricketMatch==null) {
            throw new RuntimeException("Cricket match doesnot exist by given id.");
        }
        if (requestPojo.getId() != null) {
            matchSummary = matchSummaryRepository.getById(requestPojo.getId());
            if (matchSummary == null) {
                matchSummary = new MatchSummary();
            }
        }
        matchSummary.setBatsMenId(batsmen);
        matchSummary.setBowlerId(bowler);
        matchSummary.setMatchBowlAction(requestPojo.getMatchBowlAction());
        matchSummary.setMatchId(cricketMatch);
        matchSummary.setRun(requestPojo.getRun());
        matchSummary.setOver(requestPojo.getOver());
        return matchSummaryRepository.saveData(matchSummary);
    }

}
