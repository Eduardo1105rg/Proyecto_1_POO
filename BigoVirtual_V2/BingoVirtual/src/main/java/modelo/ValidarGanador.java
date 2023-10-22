package modelo;

import java.util.*;

/**
 * Esta clase es una abtraccion de una validacion de ganador en un carton de bigo
 * 
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 8/10/2023
 */
public class ValidarGanador {
  
  /**
   * Esta clase permite la creacion de objetos tipos ValidarGanador
   * 
   */
  public ArrayList<CartonBingo> ganadores;  

  public ValidarGanador() {

    ganadores = new ArrayList<CartonBingo>();

  }

  public List<CartonBingo> getGanadores() {
    return this.ganadores;
  }

  /*
   * Esta clase permite la validacion de los cartones ganadores en Z
   * 
   * @params ArrayList<Carton> pCartones
   * @params List<Integer> numeros
   */
  public void verificarEnZ(ArrayList<CartonBingo> pCartones, List<Integer> numeros) {

    ganadores.clear();  
      
    for (CartonBingo unCarton : pCartones) {  
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      
      List<Integer>lista0 = numerosCarton.get(0);
      
      List<Integer>lista1 = numerosCarton.get(1);
      
      //List<Integer>lista2 = numerosCarton.get(2);
      
      List<Integer>lista3 = numerosCarton.get(3);
      
      List<Integer>lista4 = numerosCarton.get(4);
      //int count = lista;
      
      boolean estado0 = false;
      for (Integer volatil1 : lista0) {
        
        if (!numeros.contains(volatil1)) {
          estado0 = false;  
          break;
        }  else {
          estado0 = true;
        }  
        
      }
      
      if (estado0 == true) {
        boolean estado1 = false;    
        for (Integer volatil1 : lista4) {
        
          if (!numeros.contains(volatil1)) {
            estado1 = false;  
            break;
          }  else {
            estado1 = true;
          }  
        
        }  
        if (estado1 == true) {
          int num1 = lista1.get(3);
      
          //int num2 = lista2.get(2);;
      
          int num3 = lista3.get(1);;
      
          //int num4 = lista2.get(4);;
          //int num5 = 0;
      
          if (numeros.contains(num1) && numeros.contains(num3)) {
            ganadores.add(unCarton);  
          }
        }
      }
      
    }
      
  }  
  
 
  /*
   * Esta clase permite la validacion dentro de un carton en formato cuatro ezqunas 
   * @params ArrayList<Carton> pCartones
   * @params List<Integer> numeros
   */
  public void verificarCuatroEzquinas(ArrayList<CartonBingo> pCartones, List<Integer> numeros) {
    ganadores.clear();  
      
    for (CartonBingo unCarton : pCartones) {  
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      
      List<Integer>lista1 = numerosCarton.get(0);
      
      List<Integer>lista2 = numerosCarton.get(4);
      //int count = lista;
      
      int num1 = lista1.get(0);
      
      int num2 = lista1.get(4);;
      
      int num3 = lista2.get(0);;
      
      int num4 = lista2.get(4);;
      //int num5 = 0;
      
      if (numeros.contains(num1) && numeros.contains(num2) && numeros.contains(num3) && numeros.contains(num4)) {
        ganadores.add(unCarton);  
      }     
      
    }

  }
  

  /*
   * Esta clase permite la validacion dentro de un carton en formato carton lleno 
   * @params ArrayList<Carton> pCartones
   * @params List<Integer> numeros
   */  
  public void verificarCartonLleno(ArrayList<CartonBingo> pCartones, List<Integer> numeros) {
    ganadores.clear();  
      
    for (CartonBingo unCarton : pCartones) {
      boolean estado = true;
      List<List<Integer>> numerosCarton = unCarton.getValores();

      List<Integer> lista0 = numerosCarton.get(0);

      List<Integer> lista1 = numerosCarton.get(1);

      List<Integer> lista2 = numerosCarton.get(2);

      List<Integer> lista3 = numerosCarton.get(3);

      List<Integer> lista4 = numerosCarton.get(4);

      for (Integer num0 : lista0) {

        if (!numeros.contains(num0)) {
          estado = false;
          break;
        }
      }
      for (Integer num1 : lista1) {

        if (!numeros.contains(num1)) {
          estado = false;
          break;
        }
      }
      int count1 = 0;
      for (Integer num2 : lista2) {

        if (count1 != 2) {
          if (!numeros.contains(num2)) {
            estado = false;
            break;
          }
          
        }
        count1++; 
      }

      for (Integer num3 : lista3) {

        if (!numeros.contains(num3)) {
          estado = false;
          break;
        }
      }


      for (Integer num4 : lista4) {

        if (!numeros.contains(num4)) {
          estado = false;
          break;
        }
      }

      if (estado == true) {
        ganadores.add(unCarton);
      }  
    }  
  }


  /*
   * Esta clase permite la validacion dentro de un carton en formato X
   * @params ArrayList<Carton> pCartones
   * @params List<Integer> numeros
   */  
  public void verificarEnX(ArrayList<CartonBingo> pCartones, List<Integer> numeros) {

    ganadores.clear();  
      
    for (CartonBingo unCarton : pCartones) {  
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      
      List<Integer>lista0 = numerosCarton.get(0);
      
      List<Integer>lista1 = numerosCarton.get(1);
      
      //List<Integer>lista2 = numerosCarton.get(2);
      
      List<Integer>lista3 = numerosCarton.get(3);
      
      List<Integer>lista4 = numerosCarton.get(4);
      //int count = lista;
      
      
      int num1 = lista0.get(0);
      
      int num2 = lista1.get(1);
      
      //int num3 = lista2.get(2);
    
      int num4 = lista3.get(3);
      
      int num5 = lista4.get(4);
      
      
      int num11 = lista0.get(4);
      
      int num22 = lista1.get(3);
      
      //int num33 = lista2.get(2);
      
      int num44 = lista3.get(1);
      
      int num55 = lista4.get(0);
      
      boolean estado = false;
      
      if (numeros.contains(num1) && numeros.contains(num2) && numeros.contains(num4) && numeros.contains(num5)) {
        estado = true; 
      }
      
      if (numeros.contains(num11) && numeros.contains(num22)  && numeros.contains(num44) && numeros.contains(num55) && estado == true) {
        ganadores.add(unCarton);  
      }
     
    }      
      
  }
  

}