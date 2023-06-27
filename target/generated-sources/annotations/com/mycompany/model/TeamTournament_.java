package com.mycompany.model;

import com.mycompany.model.Team;
import com.mycompany.model.Tournament;
import com.mycompany.model.generic.GenericAbstractClass_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-27T15:00:05")
@StaticMetamodel(TeamTournament.class)
public class TeamTournament_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<TeamTournament, Team> team;
    public static volatile SingularAttribute<TeamTournament, Tournament> tournament;

}