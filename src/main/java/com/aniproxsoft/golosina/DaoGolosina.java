/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aniproxsoft.golosina;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author ANIPROXTOART
 */
@Stateless
@Dependent
public class DaoGolosina {

    @Inject
    private EntityManager em;

    public List<Golosina> consulta() {

        return em.createQuery("SELECT g FROM Golosina g ORDER BY g.nombre",
                Golosina.class).getResultList();
    }

    public Golosina busca(Integer id) {
        return em.find(Golosina.class, id);
    }

    public void agrega(Golosina modelo) {
        em.persist(modelo); // Agrega el modelo a la base de datos.
    }

    public void modifica(Golosina modelo) {
        em.merge(modelo);// Guarda los cambios al modelo.
    }

    public void elimina(Golosina modelo) {
        // Busca el modelo en base a su id.
        final Golosina anterior = em.find(Golosina.class, modelo.getId());

        if (anterior != null) {

            em.remove(anterior);
        }
    }
}
