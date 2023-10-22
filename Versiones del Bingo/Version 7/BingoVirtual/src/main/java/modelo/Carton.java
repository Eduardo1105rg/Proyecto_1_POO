package modelo;

import java.util.*;

/**
 * Esta clase es una abstraccion de un objeto tipo Carton para un Bingo.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel.
 * @version: 5/10/2023
 */
public class Carton {
    
  //private String nBingo = "BINGO";  
  
  private List<List<Integer>> valores;
  
  private String identificador;
  
  private static int consecutivos = 0;
  
  private Jugador jugador;
  
  /**
   * Esta clase es el constructor de los objetos tipo Carton. 
   */
  public Carton() {
      
    valores = new ArrayList<>();
    
    crearMatris();
    
    consecutivos++;
    
    setIdentificacion();
    
    //mostrarValores();
    
  
    //System.out.print(identificador);    
  }

  /**
   * Esta clase permite obtener elidentificador del carton
   * 
   * @return identificador del carton 
   */
  public String getIdentificador() {

    return this.identificador;

  }
  
  public Jugador getJugador() {

    return this.jugador;

  }
  
  public List<List<Integer>> getValores() {

    return this.valores;
  }
  
  public void setJugador(Jugador pJugador) {

    jugador = pJugador;

  }
  
  public void  setIdentificacion() {

    Random random = new Random();
    
    String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    StringBuilder cambiar = new StringBuilder();

    for(int i = 0; i < 3; i++) {
        
      int indice = random.nextInt(letras.length());
      
      cambiar.append(letras.charAt(indice));
    }
    cambiar.append(String.format("%03d", consecutivos));
    //consecutivos++;
    identificador = cambiar.toString();
    //return sb.toString();
    }  
    
    /**
     * Este metodo permite la creaion de la matriz de numeros de un carton
     * 
     */     
  public void crearMatris() {
    Random rand = new Random();  
   
    for (int i = 0; i < 5; i++) {
      List<Integer> numeros = new ArrayList<>();  
      //System.out.println(i );
  
      int random1 = rand.nextInt(15-1+1)+ 1; 
      
      numeros.add(random1);
      
      //System.out.println(random1);
      
      random1 = 0;
      
      //System.out.println(random1+ "a");
      
      
      int random2 = rand.nextInt(30-16+1)+ 16;
      numeros.add(random2);
      random2 = 0;
      
      if (i != 2){
        int random3 = rand.nextInt(45-31+1)+ 31; 
        numeros.add(random3);
        random3 = 0;
      } else {
       
        numeros.add(0);  
        
      }
      
      
      int random4 = rand.nextInt(60-46+1)+ 46; 
      numeros.add(random4);
      random4 = 0;
      
      int random5 = rand.nextInt(75-61+1)+ 61; 
      numeros.add(random5);
      random5 = 0;
      
      
      valores.add(numeros);
      //List<Integer> primeraLista = valores.get(0);
      //for (Integer num: primeraLista) {
      
        //System.out.print(num + "\t");
        
     // }  
      
      //numeros.clear();/
     // System.out.print("\n");
      
      //random = rand.nextInt(15-1+1)+ 1; 
      //numeros.add(random);
      
    }
    /*
    for (List<Integer> subLista : valores) {
      System.out.println("ab");
      for (Integer num: subLista) {
      
        System.out.print(num + "\t");
        
        System.out.print("dc");
      }  
    
      System.out.print("\n");
      
    } 
    */
    
  }
 
  /**
   * Esta clase permite visualizar los numero de la matriz del carton.
   */
  public void mostrarValores() {
    
    //if (valores.isEmpty()) {
      //System.out.println("La lista 'valores' está vacía.");
    //} else {
    //  System.out.println("La lista 'valores' contiene elementos.");
    //}
    
    for (List<Integer> subLista : valores) {
        
        //if (subLista.isEmpty()) {
          //  System.out.println("La lista 'sub' está vacía.");
        //} else {
         //   System.out.println("La lista 'sub' contiene elementos.");
        //}   
        
        //List<Integer> subLista1 = valores.get(0);
        //System.out.println("ab");
        for (Integer num : subLista) {
            System.out.print(num + "\t");
            //System.out.print("dc");
        }
        System.out.print("\n");
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
    for (List<Integer> unaLista : getValores()) {
      for (Integer num : unaLista) {
        
        msg += num + "\t";
        //msg += "\t";
      }
      msg += "\n";
    }
    msg += "Identificador:" + getIdentificador() + "\n";
    return msg;
    


  }
  
}
