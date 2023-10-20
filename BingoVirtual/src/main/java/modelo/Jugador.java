/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.*;
/**
 *
 * @author dylan
 */

/**
 * Esta clase es ua abstraccion de un usuario la cual registra valores como el nombre, el correo, la cedula y
 * los cartones que esten asigandos a este jugador.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 2/10/2023
 */
public final class Jugador {
 
  private String nombre;
  private String correo;
  private String cedula;
    
  /**
   * Este es el costructor de la clase Jugador y permite la creacion de objetos de este tipo.
     * @param pNombre
     * @param pCorreo
     * @param pCedula
   */
  public Jugador(String pNombre, String pCorreo, String pCedula) {   
    setNombre(pNombre);
    setCorreo(pCorreo);
    setCedula(pCedula);  
  }
  
  // Métodos accesores
  public void setNombre(String pNombre) {
    nombre = pNombre;  
  }

  public String getNombre() {
    return this.nombre;  
  }  
  
  public void setCorreo(String pCorreo) {
    correo = pCorreo;  
  }  

  public String getCorreo() {
    return this.correo;    
  }  
  
  public void setCedula(String pCedula) {
    cedula = pCedula;  
  }  

  public String getCedula() { 
    return this.cedula;   
  }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Son la misma instancia
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // No son de la misma clase o es nulo
        }

        Jugador otroJugador = (Jugador) obj;
        return cedula.equals(otroJugador.cedula);
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.cedula);
        return hash;
    }
  
}