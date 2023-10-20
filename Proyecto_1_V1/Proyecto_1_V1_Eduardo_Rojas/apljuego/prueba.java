package apljuego;

import logicadenegocios.Carton;

import logicadenegocios.ValidarGanador;

import logicadenegocios.Jugador;

import logicadenegocios.RegistroXML;

import java.util.*;

import java.time.*;

import logicadenegocios.RegistroCSV;
/**
 * Write a description of class prueba here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class prueba {

  public static void main(String[] args) {
      
     // Random rand = new Random();
      ArrayList<Carton> cartones = new ArrayList<Carton>();
      Carton a = new Carton();
      
      //System.out.println(a.toString());
      Carton b = new Carton();
      Carton c = new Carton();
      Carton d = new Carton();
      cartones.add(a);
      cartones.add(b);
      cartones.add(c);
      cartones.add(d);

      Jugador unJugador = new Jugador("Eduardo Rojas ", "edu.rg", "12345");
      unJugador.asignarCarton(c);
      unJugador.asignarCarton(a);
      System.out.println(unJugador.toString());

      RegistroCSV regis = new RegistroCSV();
      ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
      jugadores.add(unJugador);
      //System.out.println(777777);
      //regis.escribirCSV("Eduardo", "1233", "edu@gmail");
      regis.escribirCSV(jugadores);
      regis.leeCSV();


      /*
      List<Integer> numeros = new ArrayList<>();
      // System.out.println(i );
      for (int i = 0; i < 40; i++) {
        int random1 = rand.nextInt(75 - 1 + 1) + 1;
        numeros.add(random1);
      }
      ValidarGanador vali = new ValidarGanador();

      vali.verificarCartonLleno(cartones, numeros);
      //Validar cartones
      
      List<Integer>uno = new ArrayList<Integer>();
      
      uno.add(1);
      uno.add(3);
      uno.add(4);
      uno.add(5);
      uno.add(6);
      uno.add(7);
      uno.add(8);
      uno.add(9);
      List<String> algo = new ArrayList<String>();
      
      algo.add("123");
      algo.add("23455");
      algo.add("345325");
      algo.add("42435345");
      algo.add("546658776978");
      LocalDate fechaActual = LocalDate.now();
      
      LocalTime horaActual = LocalTime.now();
      
      RegistroXML registro = new RegistroXML("X", uno , algo);
      registro.crearRegistro();
      //a.crearMatris();
      //a.identificacion();
      */
    }
    
}
