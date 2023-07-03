package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name = "cricket_match")
public class CricketMatch extends GenericAbstractClass implements GenericInterface {

    @Column(name = "match_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matchDate;

    @Column(length = 50, nullable = false)
    private String venue;

    @ManyToOne(optional = false)
    @CascadeOnDelete
    @NotNull
    @JoinColumn(name = "tournament_id", referencedColumnName = "id", nullable = false)
    private Tournament tournament;
    
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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    
    @Override
    public String getTableName() {
        return "cricket_match";
    }

}
