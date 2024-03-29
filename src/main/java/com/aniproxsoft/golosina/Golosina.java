/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aniproxsoft.golosina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ANIPROXTOART
 */
@Entity
@Table(name = "GOLOSINA") 
public class Golosina implements Serializable {
     private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GOLO_ID")
  private Integer id;
  // Las siguientes anotaciones se explican en el la página sobre Bean Validation.
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "GOLO_NOMBRE")
  private String nombre;
  
  @NotNull
  @Column(name="GOLO_PRECIO")
  private Double precio;
  
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Golosina)) {
      return false;
    }
    Golosina other = (Golosina) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.
        equals(other.id))) {
      return false;
    }
    return true;
  }
  @Override
  public String toString() {
    return "com.aniproxsoft.golosina.Golosina[ id=" + id + " ]";
  }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
