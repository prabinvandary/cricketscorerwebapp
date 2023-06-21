package com.mycompany.model;

import cricscorer.enumvalues.TournamentType;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T14:20:31")
@StaticMetamodel(Tournament.class)
public class Tournament_ { 

    public static volatile SingularAttribute<Tournament, LocalDate> tournamentDate;
    public static volatile SingularAttribute<Tournament, TournamentType> tournamentType;
    public static volatile SingularAttribute<Tournament, Long> id;

}