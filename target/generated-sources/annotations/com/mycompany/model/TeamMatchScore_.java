package com.mycompany.model;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Team;
import com.mycompany.model.generic.GenericAbstractClass_;
import cricscorer.enumvalues.TossAction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T15:31:41")
@StaticMetamodel(TeamMatchScore.class)
public class TeamMatchScore_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<TeamMatchScore, Integer> score;
    public static volatile SingularAttribute<TeamMatchScore, Boolean> isWinner;
    public static volatile SingularAttribute<TeamMatchScore, CricketMatch> cricketMatch;
    public static volatile SingularAttribute<TeamMatchScore, TossAction> tossAction;
    public static volatile SingularAttribute<TeamMatchScore, Team> team;

}