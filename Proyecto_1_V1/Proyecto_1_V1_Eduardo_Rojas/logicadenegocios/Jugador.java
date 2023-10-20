package logicadenegocios;

import java.util.*;

/**
 * Esta clase es ua abstraccion de un usuario la cual registra valores como el nombre, el correo, la cedula y
 * los cartones que esten asigandos a este jugador.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 2/10/2023
 */
public class Jugador {
 
  private String nombre;
  
  private String correo;
  
  private String cedula;
  
  private ArrayList <Carton> cartonesAsignados;
  
    
  /**
   * Este es el costructor de la clase Jugador y permite la creacion de objetos de este tipo.
   */
  public Jugador(String pNombre, String pCorreo, String Pcedula) {
      
    nombre = pNombre;
    
    correo = pCorreo;
    
    cedula = Pcedula;  
    
    cartonesAsignados = new ArrayList<Carton>();
      
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
  
  public String formatoCSV() {
    return this.nombre + "," + this.cedula + "," + this.correo + "\n";
  }
  /**
   * Esta clase permite la asigancion de cartones a este jugador.
   * @param nuevoCarton
   */
  public void asignarCarton(Carton nuevoCarton) {
    
    cartonesAsignados.add(nuevoCarton);       
    
  }
  
  /*
   * Esta clase verifica si los elementos de esta clase son iguales a los de otra clase ingresada
   * 
   * @param Jugador jugador2
   * @param int mode
   * 
   * @return Un valor blooleano, puede ser true si se encuentra una coincidencia o false en caso de que no se encuantre alguna.
   */
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
          
      //case 4:
        //for (int i = 0; i < cartonesAsignados.size(); i++) {
        
         // Carton unCarton = (Carton) cartonesAsignados.get(i);
          
          
        
       // }
          
        //if (jugador2.getNombre() == this.nombre) {
        
         // return true;    
        
       // } else {
        
         // return false;
        
       // }
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
  
  
  /*
   * Este metodo permite la visualizacion de los datos de este clase
   * 
   * @return msg: Datos de la clase.
   * 
   */  
  
  public String toString() {
    
  String msg = "";
  
  msg = "Nombre: " + nombre + "\n";
  
  msg += "Correo: " + correo + "\n";
  
  msg += "Cedula: " + cedula + "\n";
  
  for (int i = 0; i < cartonesAsignados.size(); i++) {
    msg += "Valores:" + "\n";
    Carton unCarton = (Carton) cartonesAsignados.get(i);
    msg += unCarton.toString();
  }
  
  return msg;  
    
  }

}
