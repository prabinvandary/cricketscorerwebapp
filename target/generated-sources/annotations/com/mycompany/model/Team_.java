package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T15:51:43")
@StaticMetamodel(Team.class)
public class Team_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<Team, String> address;
    public static volatile SingularAttribute<Team, String> manager;
    public static volatile SingularAttribute<Team, String> name;

}