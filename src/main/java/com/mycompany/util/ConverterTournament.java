/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.model.Team;
import com.mycompany.model.Tournament;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author prabin
 */
@FacesConverter(value = "converterTournament")
public class ConverterTournament implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression vex
                = context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{tournament}", Tournament.class);

        Tournament tournament = (Tournament) vex.getValue(context.getELContext());
        return tournament;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object tournament) {
        return ((Tournament) tournament).getId().toString();
    }

}
