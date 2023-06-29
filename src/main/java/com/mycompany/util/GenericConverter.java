/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.repository.generic.GenericRepository;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author prabin
 * @param <T>
 */

public abstract class GenericConverter<T> implements Converter {

//    protected abstract GenericRepository getGenericRepository();
//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        if (value == null || value.isEmpty() || value.length() == 0 || value.equals("")) {
//            return null;
//        }
//        System.out.println(getGenericRepository().getById(Long.valueOf(value)).getId());
//        return getGenericRepository().getById(Long.valueOf(value));
//    }
//
//    private String getStringKey(java.lang.String value) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(value);
//        return sb.toString();
//
//    }
//
//    @Override
//    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
//        if (o == null || o.equals("")) {
//            return "";
//        }
//
//        try {
//            if (o instanceof GenericAbstractClass) {
//                GenericAbstractClass ab = (GenericAbstractClass) o;
//                return getStringKey(ab.get());
//            }
//        } catch (Exception e) {
//            throw new IllegalArgumentException(e.getMessage());
//        }
//        return "Can't";
//    }
    /**
     *
     * @return
     */
    protected abstract GenericRepository getGenericRepository();
    
    

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || value.equals("") || value.equalsIgnoreCase("null") || value.toLowerCase().startsWith("sel")) {
            return null;
        }
        try {
            T t=(T) getGenericRepository().getById(getKey(value));
            System.out.println(t);
            return getGenericRepository().getById(getKey(value));
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
        if (object instanceof GenericAbstractClass) {
            GenericAbstractClass o = (GenericAbstractClass) object;
            return getStringKey(o.getId());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: converter for " + this.getClass());
        }
    }
}
