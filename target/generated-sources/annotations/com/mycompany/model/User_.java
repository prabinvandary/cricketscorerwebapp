package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-06-27T10:14:43")
@StaticMetamodel(User.class)
public class User_ extends GenericAbstractClass_ {

    public static volatile SingularAttribute<User, String> emailAddress;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, String> userName;

}