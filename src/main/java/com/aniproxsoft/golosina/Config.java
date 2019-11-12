/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aniproxsoft.golosina;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.annotation.FacesConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ANIPROXTOART
 */
@Dependent
@FacesConfig
public class Config {
  /* @Produces indica que se puede usar en @Inject. @PersistenceContext indica
   * que usa transacciones y el archivo persistence.xml */
  @Produces
  @PersistenceContext
  EntityManager em;
}
