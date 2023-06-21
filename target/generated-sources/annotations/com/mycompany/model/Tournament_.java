package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass_;
import cricscorer.enumvalues.TournamentType;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-21T15:51:43")
@StaticMetamodel(Tournament.class)
public class Tournament_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<Tournament, LocalDate> tournamentDate;
    public static volatile SingularAttribute<Tournament, TournamentType> tournamentType;

}