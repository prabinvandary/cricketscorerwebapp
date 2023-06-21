package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass_;
import cricscorer.enumvalues.PlayerRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T16:38:59")
@StaticMetamodel(Player.class)
public class Player_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<Player, String> address;
    public static volatile SingularAttribute<Player, String> name;
    public static volatile SingularAttribute<Player, PlayerRole> playerRole;

}