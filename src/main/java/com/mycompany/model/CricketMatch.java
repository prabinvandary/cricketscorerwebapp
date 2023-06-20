package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cricket_match")
public class CricketMatch implements Serializable {

    @Id
    private Long id;
    private String matchDate;
    private String venue;

    public CricketMatch() {
    }

    public CricketMatch(Integer id, String matchDate, String venue) {
        this.matchDate = matchDate;
        this.venue = venue;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
