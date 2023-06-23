package com.mycompany.model;

import com.mycompany.enumvalues.PlayerPosition;
import com.mycompany.model.Player;
import com.mycompany.model.TeamTournament;
import com.mycompany.model.generic.GenericAbstractClass_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-23T13:45:12")
@StaticMetamodel(PlayerTeamTournament.class)
public class PlayerTeamTournament_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<PlayerTeamTournament, Boolean> isWicketKeeper;
    public static volatile SingularAttribute<PlayerTeamTournament, TeamTournament> teamTournament;
    public static volatile SingularAttribute<PlayerTeamTournament, PlayerPosition> position;
    public static volatile SingularAttribute<PlayerTeamTournament, Player> player;

}