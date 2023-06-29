package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cricket_match")
public class CricketMatch extends GenericAbstractClass implements GenericInterface {

    @Column(name = "match_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matchDate;

    @Column(length = 50, nullable = false)
    private String venue;

    public CricketMatch() {
    }

    public CricketMatch(Long id, Date matchDate, String venue) {
        this.setId(id);
        this.matchDate = matchDate;
        this.venue = venue;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setMatchDate(Date matchDate) {
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
