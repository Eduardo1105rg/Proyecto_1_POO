package logicadenegocios;

import java.util.*;

/**
 * Write a description of class ValidarGanador here.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 8/10/2023
 */
public class ValidarGanador {
  
  public ArrayList<Carton> ganadores;  
  public ValidarGanador() {
    
    ganadores  = new ArrayList<Carton>();
      
  }

  
  
  public void verificarEnX(ArrayList<Carton> pCartones, List<Integer> numeros) {

    ganadores.clear();  
      
    for (Carton unCarton : pCartones) {  
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      
      List<Integer>lista0 = numerosCarton.get(0);
      
      List<Integer>lista1 = numerosCarton.get(1);
      
      List<Integer>lista2 = numerosCarton.get(2);
      
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
      
          int num2 = lista2.get(2);;
      
          int num3 = lista3.get(1);;
      
          //int num4 = lista2.get(4);;
          //int num5 = 0;
      
          if (numeros.contains(num1) && numeros.contains(num2) && numeros.contains(num3)) {
            ganadores.add(unCarton);  
          }
        }
      }
      
    }
      
  }  
  
  public void verificarCuatroEzquinas(ArrayList<Carton> pCartones, List<Integer> numeros) {
    ganadores.clear();  
      
    for (Carton unCarton : pCartones) {  
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
  
  public void verificarCartonLleno(ArrayList<Carton> pCartones, List<Integer> numeros) {
    
    ganadores.clear();  
      
    for (Carton unCarton : pCartones) {
        
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      boolean estado = false;
      for (List<Integer> numLista : numerosCarton) {
        
        boolean estado2 = false;  
          
        for (Integer num : numLista) {
            
          boolean estado3 = false;
            
          for (Integer element : numeros) {
          
            if (num == element) {

            estado3 = true;
            break;
            } else {
              estado3 = false;
              break;
            
            }

          }
          
          if (estado3 == false) {
            
            break;
            
          } else {
            
            estado2 = true;  
            
          }
          
        }
        if (estado2 == false) {
          break;  
        } else {
        
          estado = true;
        
        }
          
      }
      
      if (estado = true) {

        ganadores.add(unCarton);

      }
    }
    

  }
  
  
  public void verificarEnZ(ArrayList<Carton> pCartones, List<Integer> numeros) {

    ganadores.clear();  
      
    for (Carton unCarton : pCartones) {  
      List<List<Integer>>numerosCarton = unCarton.getValores(); 
      
      
      List<Integer>lista0 = numerosCarton.get(0);
      
      List<Integer>lista1 = numerosCarton.get(1);
      
      List<Integer>lista2 = numerosCarton.get(2);
      
      List<Integer>lista3 = numerosCarton.get(3);
      
      List<Integer>lista4 = numerosCarton.get(4);
      //int count = lista;
      
      
      int num1 = lista0.get(0);
      
      int num2 = lista1.get(1);
      
      int num3 = lista2.get(2);
    
      int num4 = lista3.get(3);
      
      int num5 = lista4.get(4);
      
      
      int num11 = lista0.get(4);
      
      int num22 = lista1.get(3);
      
      //int num33 = lista2.get(2);
      
      int num44 = lista3.get(1);
      
      int num55 = lista4.get(0);
      
      boolean estado = false;
      
      if (numeros.contains(num1) && numeros.contains(num2) && numeros.contains(num3) && numeros.contains(num4) && numeros.contains(num5)) {
        estado = true; 
      }
      
      if (numeros.contains(num11) && numeros.contains(num22)  && numeros.contains(num44) && numeros.contains(num55) && estado == false) {
        ganadores.add(unCarton);  
      }
     
    }      
      
  }
  

}