package com.mycompany.model;

import com.mycompany.model.Player;
import com.mycompany.model.TeamTournament;
import com.mycompany.model.generic.GenericAbstractClass_;
import cricscorer.enumvalues.PlayerPosition;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T15:31:41")
@StaticMetamodel(PlayerTeamTournament.class)
public class PlayerTeamTournament_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<PlayerTeamTournament, Boolean> isWicketKeeper;
    public static volatile SingularAttribute<PlayerTeamTournament, TeamTournament> teamTournament;
    public static volatile SingularAttribute<PlayerTeamTournament, PlayerPosition> position;
    public static volatile SingularAttribute<PlayerTeamTournament, Player> player;

}