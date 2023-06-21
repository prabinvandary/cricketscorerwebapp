package com.mycompany.model;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Player;
import cricscorer.enumvalues.MatchBowlAction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T14:20:31")
@StaticMetamodel(MatchSummary.class)
public class MatchSummary_ { 

    public static volatile SingularAttribute<MatchSummary, Double> over;
    public static volatile SingularAttribute<MatchSummary, MatchBowlAction> matchBowlAction;
    public static volatile SingularAttribute<MatchSummary, Player> playerBatsMen;
    public static volatile SingularAttribute<MatchSummary, CricketMatch> cricketMatch;
    public static volatile SingularAttribute<MatchSummary, Integer> run;
    public static volatile SingularAttribute<MatchSummary, Player> playerBolwer;
    public static volatile SingularAttribute<MatchSummary, Long> id;

}