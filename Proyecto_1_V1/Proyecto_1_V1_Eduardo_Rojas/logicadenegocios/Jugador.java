package logicadenegocios;

import java.util.*;

/**
 * Write a description of class Jugador here.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 10/2/2023
 */
public class Jugador {
 
  private String nombre;
  
  private String correo;
  
  private String cedula;
  
  private ArrayList <Carton> cartonesAsignados;
  
    
  /**
   * Constructor for objects of class Jugador
   */
  public Jugador(String pNombre, String pCorreo, String Pcedula) {
      
    nombre = pNombre;
    
    correo = pCorreo;
    
    cedula = Pcedula;    
      
  }
  
  public String getNombre() {
    
    return this.nombre;
      
  }
  
  public String getCorreo() {
    
    return this.correo;
      
  }
  
  public String getCedula() {
    
    return this.cedula;
      
  }
  
  //public String get() {
    
    //return ;
      
  //}
  
  public void asignarCarton(Carton nuevoCarton) {
    
    cartonesAsignados.add(nuevoCarton);       
    
  }
  
  public boolean equals(Jugador jugador2, int mode) {
    
    switch (mode) {
    
      case 1: 
        
        if (jugador2.getNombre() == this.nombre) {
        
          return true;    
        
        } else {
        
          return false;
        
        }
      case 2:
        if (jugador2.getCorreo() == this.correo) {
        
          return true;    
        
        } else {
        
          return false;
        
        }
      case 3:  
        if (jugador2.getCedula() == this.cedula) {
        
          return true;    
        
        } else {
        
          return false;
        
        }        
          
      case 4:
        for (int i = 0; i < cartonesAsignados.size(); i++) {
        
          Carton unCarton = (Carton) cartonesAsignados.get(i);
          
          
        
        }
          
        if (jugador2.getNombre() == this.nombre) {
        
          return true;    
        
        } else {
        
          return false;
        
        }
      /**    
      case 5:
          
        if (jugador2.getNombre() == this.nombre) {
        
          return true;    
        
        } else {
        
          return false;
        
        }
          
      case 6:    

        if (jugador2.getNombre() == this.nombre) {
        
          return true;    
        
        } else {
        
          return false;
        
        }
      
    
      
      */
     
      default:
        return false;
    }
    
  }
  
  
  
  
  public String toString() {
    
  String msg = "";
  
  msg = "Nombre: " + nombre + "\n";
  
  msg += "Correo: " + correo + "\n";
  
  msg += "Cedula: " + cedula + "\n";
  
  for (int i = 0; i < cartonesAsignados.size(); i++) {
     Carton unCarton = (Carton) cartonesAsignados.get(i);
     
     //msg += unCarton.toString();
    
    }
  
  return msg;  
    
  }

}
