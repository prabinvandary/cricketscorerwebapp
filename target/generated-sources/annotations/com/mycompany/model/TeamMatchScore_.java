package com.mycompany.model;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Team;
import cricscorer.enumvalues.TossAction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T14:20:31")
@StaticMetamodel(TeamMatchScore.class)
public class TeamMatchScore_ { 

    public static volatile SingularAttribute<TeamMatchScore, Integer> score;
    public static volatile SingularAttribute<TeamMatchScore, Boolean> isWinner;
    public static volatile SingularAttribute<TeamMatchScore, CricketMatch> cricketMatch;
    public static volatile SingularAttribute<TeamMatchScore, TossAction> tossAction;
    public static volatile SingularAttribute<TeamMatchScore, Team> team;
    public static volatile SingularAttribute<TeamMatchScore, Long> id;

}