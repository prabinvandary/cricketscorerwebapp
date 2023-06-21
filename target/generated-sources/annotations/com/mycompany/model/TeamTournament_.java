package com.mycompany.model;

import com.mycompany.model.Team;
import com.mycompany.model.Tournament;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T14:20:31")
@StaticMetamodel(TeamTournament.class)
public class TeamTournament_ { 

    public static volatile SingularAttribute<TeamTournament, Team> team;
    public static volatile SingularAttribute<TeamTournament, Tournament> tournament;
    public static volatile SingularAttribute<TeamTournament, Long> id;

}