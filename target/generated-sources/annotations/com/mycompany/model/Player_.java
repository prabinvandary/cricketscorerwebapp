package com.mycompany.model;

import cricscorer.enumvalues.PlayerRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T14:20:31")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile SingularAttribute<Player, String> address;
    public static volatile SingularAttribute<Player, String> name;
    public static volatile SingularAttribute<Player, Long> id;
    public static volatile SingularAttribute<Player, PlayerRole> playerRole;

}