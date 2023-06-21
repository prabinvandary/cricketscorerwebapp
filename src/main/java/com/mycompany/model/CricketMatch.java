//package com.mycompany.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
////@Entity
//@Table(name = "cricket_match")
//public class CricketMatch implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "cricket_match_seq_gen", name = "cricket_match_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "cricket_match_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "match_date")
//    private String matchDate;
//    @Column(name = "venue")
//    private String venue;
//
//    public CricketMatch() {
//    }
//
//    public CricketMatch(Integer id, String matchDate, String venue) {
//        this.matchDate = matchDate;
//        this.venue = venue;
//    }
//
//    public String getMatchDate() {
//        return matchDate;
//    }
//
//    public String getVenue() {
//        return venue;
//    }
//
//    public void setMatchDate(String matchDate) {
//        this.matchDate = matchDate;
//    }
//
//    public void setVenue(String venue) {
//        this.venue = venue;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//}
