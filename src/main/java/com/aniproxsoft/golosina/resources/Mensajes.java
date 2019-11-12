/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aniproxsoft.golosina.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author ANIPROXTOART
 */
@ApplicationScoped
public class Mensajes {

    @Inject
    private FacesContext facesContext;

    public void información(String idDeComponente, final String texto) {
        mensaje(idDeComponente, FacesMessage.SEVERITY_INFO, texto, null);
    }

    public void error(String idDeComponente, final String texto) {
        mensaje(idDeComponente, FacesMessage.SEVERITY_ERROR, texto, null);
    }

    public void mensaje(String idDeComponente, FacesMessage.Severity tipo,
            String resumen, String detalle) {
        facesContext
                .addMessage(idDeComponente, new FacesMessage(tipo, resumen, detalle));
    }

    public void procesa(Throwable e) {
        Throwable causa = e.getCause();
        while (causa != null && causa != e) {
            e = causa;
            causa = e.getCause();
        }
        final String mensaje = e.getLocalizedMessage();
        if (mensaje == null || mensaje.isEmpty()) {
            error(null, e.toString());
        } else {
            error(null, e.getLocalizedMessage());
        }
    }
}
