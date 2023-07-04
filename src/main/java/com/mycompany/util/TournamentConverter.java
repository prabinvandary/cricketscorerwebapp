/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import com.mycompany.repository.generic.GenericRepository;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
@FacesConverter(value = "tournamentConverter", forClass = Tournament.class)
public class TournamentConverter extends GenericConverter<Tournament> {

    @Inject
    TournamentRepository tournamentRepository;

    @Override
    protected GenericRepository getGenericRepository() {
        return tournamentRepository;
    }
}
