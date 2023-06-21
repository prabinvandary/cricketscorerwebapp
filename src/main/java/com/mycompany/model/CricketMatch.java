package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cricket_match")
public class CricketMatch extends GenericAbstractClass implements GenericInterface{

    private String matchDate;

    private String venue;

    public CricketMatch() {
    }

    public CricketMatch(Long id, String matchDate, String venue) {
        this.setId(id);
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

    @Override
    public String getTableName() {
        return "cricket_match";
    }

}
