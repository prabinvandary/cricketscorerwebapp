/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
@FacesConverter(value = "converterTournament",forClass = Tournament.class)
public class ConverterTournament implements Converter {

    @Inject
    private TournamentRepository tournamentRepository;
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || value.equals("") || value.equalsIgnoreCase("null") || value.toLowerCase().startsWith("sel")) {
            return null;
        }
        try {
            return tournamentRepository.getById(getKey(value));
        } catch (NumberFormatException nfe) {
            Logger.getLogger("Severe: Number format Exception, Can't convert value " + value);
            return null;
        }
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if ("".equals(object)) {
            return "";
        }
        if (object == null) {
            return null;
        }
        if (object instanceof Tournament) {
            Tournament o = (Tournament) object;
            return getStringKey(o.getId());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: converter for " + this.getClass());
        }
    }

}
