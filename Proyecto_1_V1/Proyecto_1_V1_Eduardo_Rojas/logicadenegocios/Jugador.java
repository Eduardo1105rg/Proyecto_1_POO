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
  
  
  public String toString() {
    
  String msg = "";
  
  msg = "Nombre: " + nombre + "\n";
  
  msg += "Correo: " + correo + "\n";
  
  msg += "Cedula: " + cedula + "\n";
  
  for (int i = 0; i < cartonesAsignados.size(); i++) {
    
    
    }
  
  return msg;  
    
  }

}
