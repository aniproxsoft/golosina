/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aniproxsoft.golosina;

import com.aniproxsoft.golosina.resources.Mensajes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ANIPROXTOART
 */
@Named
@RequestScoped
public class CtrlGolosinas {

    @Inject
    private Mensajes mensajes;
    @Inject
    private DaoGolosina dao;
    private List<Golosina> instancias;

    @PostConstruct
    void init() {
        try {
            instancias = dao.consulta();
        } catch (Exception ex) {
            mensajes.procesa(ex);
        }
    }

    public List<Golosina> getInstancias() {
        return instancias;
    }
}
