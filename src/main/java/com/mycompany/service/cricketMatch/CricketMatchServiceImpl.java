/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.cricketMatch;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Team;
import com.mycompany.model.TeamMatchScore;
import com.mycompany.model.Tournament;
import com.mycompany.pojo.cricketMatch.CricketMatchDetailRequestPojo;
import com.mycompany.pojo.cricketMatch.UpdateRunDetailRequestPojo;
import com.mycompany.pojo.cricketMatch.UpdateWinnerDetailRequestPojo;
import com.mycompany.repository.MatchRepository;
import com.mycompany.repository.TeamMatchScoreRepository;
import com.mycompany.repository.TeamRepository;
import com.mycompany.repository.TournamentRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author prabin
 */
public class CricketMatchServiceImpl implements CricketMatchService {

    @Inject
    private MatchRepository matchRepostiory;

    @Inject
    private TeamRepository teamRepository;

    @Inject
    private TournamentRepository tournamentRepository;

    @Inject
    TeamMatchScoreRepository teamMatchScoreRepository;

    @Override
    @Transactional
    public CricketMatch saveCricketMatch(CricketMatchDetailRequestPojo requestPojo) {
        CricketMatch cricketMatch = new CricketMatch();
        Team firstTeam = teamRepository.getById(requestPojo.getTeamMatchDetailRequestPojo().getFirstTeamId());
        Team secondTeam = teamRepository.getById(requestPojo.getTeamMatchDetailRequestPojo().getSecondTeamId());
        Tournament tournament = tournamentRepository.getById(requestPojo.getTournamentId());

        if (requestPojo.getMatchId() != null) {
            cricketMatch = matchRepostiory.getById(requestPojo.getMatchId());
            if (cricketMatch == null) {
                cricketMatch = new CricketMatch();
            }
        }
        cricketMatch.setMatchDate(requestPojo.getMatchDate());
        cricketMatch.setVenue(requestPojo.getMatchVenue());
        if (tournament == null) {
            throw new RuntimeException("Tournament not found by given id");
        }
        if (firstTeam == null) {
            throw new RuntimeException("Team not found by given id " + requestPojo.getTeamMatchDetailRequestPojo().getFirstTeamId());
        }
        if (secondTeam == null) {
            throw new RuntimeException("Team not found by given id " + requestPojo.getTeamMatchDetailRequestPojo().getFirstTeamId());
        }
        cricketMatch = matchRepostiory.saveData(cricketMatch);
        saveTeamMatchScore(cricketMatch, firstTeam, requestPojo);
        saveTeamMatchScore(cricketMatch, secondTeam, requestPojo);
        return cricketMatch;
    }

    private TeamMatchScore saveTeamMatchScore(CricketMatch cricketMatch, Team team, CricketMatchDetailRequestPojo requestPojo) {
        TeamMatchScore teamMatchScore = new TeamMatchScore();
        if (requestPojo.getTeamMatchScoreId() != null) {
            teamMatchScore = teamMatchScoreRepository.getByMatch(cricketMatch, team);
            if (teamMatchScore == null) {
                teamMatchScore = new TeamMatchScore();
            }
        }
        if (requestPojo.getTeamMatchDetailRequestPojo().getTossWinTeamId().equals(team.getId())) {
            teamMatchScore.setTossAction(requestPojo.getTeamMatchDetailRequestPojo().getTossWinTeamAction());
        }
        teamMatchScore.setTossAction(requestPojo.getTeamMatchDetailRequestPojo().getTossLooseTeamAction());
        teamMatchScore.setCricketMatch(cricketMatch);
        teamMatchScore.setTeam(team);
        return teamMatchScoreRepository.saveData(teamMatchScore);
    }

    public TeamMatchScore updateTeamRun(UpdateRunDetailRequestPojo requestPojo) {
        TeamMatchScore teamMatchScore = teamMatchScoreRepository.getById(requestPojo.getTeamMatchScoreId());
        if (teamMatchScore == null) {
            throw new RuntimeException("Team match details not found by given id");
        }

        teamMatchScore.setScore(requestPojo.getScore());
        return teamMatchScoreRepository.saveData(teamMatchScore);
    }

    public TeamMatchScore updateTeamWinner(UpdateWinnerDetailRequestPojo requestPojo) {
        TeamMatchScore teamMatchScore = teamMatchScoreRepository.getById(requestPojo.getTeamMatchScoreId());
        if (teamMatchScore == null) {
            throw new RuntimeException("Team match details not found by given id");
        }
        teamMatchScore.setIsWinner(requestPojo.getIsWinner());
        return teamMatchScoreRepository.saveData(teamMatchScore);
    }

    public TeamMatchScore addTeamRun(UpdateRunDetailRequestPojo requestPojo) {
        TeamMatchScore teamMatchScore = teamMatchScoreRepository.getById(requestPojo.getTeamMatchScoreId());
        if (teamMatchScore == null) {
            throw new RuntimeException("Team match details not found by given id");
        }

        teamMatchScore.setScore(teamMatchScore.getScore()+requestPojo.getScore());
        return teamMatchScoreRepository.saveData(teamMatchScore);
    }
}
