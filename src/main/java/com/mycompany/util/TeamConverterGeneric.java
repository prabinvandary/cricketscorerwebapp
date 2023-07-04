/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.model.Team;
import com.mycompany.repository.TeamRepository;
import com.mycompany.repository.generic.GenericRepository;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
@FacesConverter(value = "teamConverterGeneric", forClass = Team.class)
public class TeamConverterGeneric extends GenericConverter<Team> {

    @Inject
    TeamRepository teamRepository;

    @Override
    protected GenericRepository getGenericRepository() {
        return teamRepository;
    }

}
