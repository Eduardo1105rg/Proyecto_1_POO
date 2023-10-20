package logicadenegocios;

//import java.util.ArrayList;
import java.util.*;
import logicadenegocios.Jugador;
import java.io.*;

/**
 * Esta clase permite la escritura y lectura de un archivo CSV
 *
 * @author Eduardo Rojas Gomez y Dylan Montiel
 * @version 
 */
public class RegistroCSV {
   
  public RegistroCSV() {

  }
  
  public void escribirCSV(String pNmbre, String pCorreo, String pCedula) {

    File archivo = new File("Usuarios.csv");
    
    try {
      
      FileWriter escriba = new FileWriter(archivo, true);//Este true es de la cosas que uno nunca se imagina
      BufferedWriter escritor = new BufferedWriter(escriba);

      escritor.write(pNmbre + "," + pCorreo + "," + pCedula);
      escritor.newLine();

      escritor.close();

      //System.out.println("Datos escritos en el archivo CSV.");

    } catch (IOException e) {
      System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
    }


  }

  public void escribirCSV(ArrayList<Jugador> usuarios) {

    for (Jugador unJugador : usuarios) {
      File archivo = new File("Usuarios.csv");
      try {
        FileWriter escriba = new FileWriter(archivo, true);//Este true es de la cosas que uno nunca se imagina
        BufferedWriter escritor = new BufferedWriter(escriba);
    
        escritor.write(unJugador.formatoCSV());
        //escritor.newLine();

        escritor.close();

      //System.out.println("Datos escritos en el archivo CSV.");

      } catch (IOException e) {
        System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
    }
   }

  }  
  
  public void leeCSV() {

    File archivo = new File("Usuarios.csv");
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    String linea = "";
    //String csvSplitBy = ",";
     
    try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
      while ((linea = leer.readLine()) != null) {
        // Usa la coma como separador
        String[] datos = linea.split(",");

        // Ahora puedes usar los datos como necesites
        String nombre = datos[0];
        String cedula = datos[1];
        String correo = datos[2];

        Jugador unJugador = new Jugador(nombre, correo, cedula);

        jugadores.add(unJugador);
        // Imprime los datos para verificar
        //System.out.println("Dato 1: " + nombre + ", Dato 2: " + cedula + ", Dato 3: " + correo);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
