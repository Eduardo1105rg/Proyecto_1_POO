package modelo;


import java.util.*;

import java.io.File;

import java.time.*;

import javax.xml.parsers.*;

import javax.xml.transform.*;

import javax.xml.transform.dom.*;

import javax.xml.transform.stream.*;

import org.w3c.dom.*;



/**
 * Esta clase permite la creacion de registros en un documento XML.
 *
 * @author: Eduardo Rojas Gomez y Dylan Montiel
 * @version: 19-10-2023
 */
public class RegistroXML {

  private String configuracion;
  
  private List<Integer>numerosCantados;
  
  private List<String> cedulas;

  //private String cedula;
  
  private LocalDate fechaJuego;
  
  private LocalTime horaJuego; 
  
  private String nombreArchivo = "Historial_Partidas.xml";
  
  /*
   * Este es el constructor de la clase RegistroXML, permite la creacion de objetos RegistroXML
   * 
   */
  public RegistroXML(String pConfiguracion, List<Integer>pNumerosCantados, List<String> pCedulas) {
  
    configuracion = pConfiguracion;  
    
    numerosCantados = pNumerosCantados;
    
    cedulas = pCedulas;
    
    fechaJuego = LocalDate.now();//pFechaJuego;
    
    horaJuego = LocalTime.now();//pHoraJuego;
    
    //crearRegistro();
    //leerXML();
  }
  
  /*
   * Este metodo permite el registro de los datos de la partida actual en un documento XML
   */
  public void crearRegistro() {
     try {
        DocumentBuilderFactory crearDocumento = DocumentBuilderFactory.newInstance();
        DocumentBuilder crearDocumento2 = crearDocumento.newDocumentBuilder();
        Document archivo;
        Element inicio;

        File file = new File(nombreArchivo);
        //Verificar si el archivo existe.
        if (file.exists()) {
          // Si el archivo existe, lo abrimos y obtenemos la raíz
          archivo = crearDocumento2.parse(nombreArchivo);
          inicio = archivo.getDocumentElement();
        } else {
          // Si el archivo no existe, creamos uno nuevo con la raíz "partidasJuego"
          archivo = crearDocumento2.newDocument();
          inicio = archivo.createElement("partidasJuego2");
          archivo.appendChild(inicio);
    }

    // Aquí va el resto del código para añadir la nueva partida...
      
    Element nuevaPartida = archivo.createElement("partida");

    Element tipo = archivo.createElement("tipo");
    tipo.appendChild(archivo.createTextNode(configuracion));
    nuevaPartida.appendChild(tipo);

    Element numerosCantadosElement = archivo.createElement("numerosCantados");
    numerosCantadosElement.appendChild(archivo.createTextNode(numerosCantados.toString()));
    nuevaPartida.appendChild(numerosCantadosElement);

    Element ganadores = archivo.createElement("ganadores");
    ganadores.appendChild(archivo.createTextNode(cedulas.toString()));
    nuevaPartida.appendChild(ganadores);

    Element fecha = archivo.createElement("fecha");// No me dejaron escribir con mayusculas
    fecha.appendChild(archivo.createTextNode(fechaJuego.toString()));
    nuevaPartida.appendChild(fecha);

    Element hora = archivo.createElement("hora");
    hora.appendChild(archivo.createTextNode(horaJuego.toString()));
    nuevaPartida.appendChild(hora);

    inicio.appendChild(nuevaPartida);

      //TransformerFactory transformerFactory = TransformerFactory.newInstance();
      //Transformer transformer = transformerFactory.newTransformer();
      //DOMSource domSource = new DOMSource(document);
      //StreamResult streamResult = new StreamResult(new File(filePath));
      
      //transformer.transform(domSource, streamResult);
      
    TransformerFactory saltoDeLinea = TransformerFactory.newInstance();
    Transformer saltar = saltoDeLinea.newTransformer();
    
    // Configurar el Transformer para que indente el XML
    saltar.setOutputProperty(OutputKeys.INDENT, "yes");
    saltar.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    
    DOMSource DOM = new DOMSource(archivo);
    StreamResult resultado = new StreamResult(new File(nombreArchivo));
    
    saltar.transform(DOM, resultado);
      
    } catch (Exception e) {
      e.printStackTrace();// Agregar algo mas.
    } 
    
    
  }

  
  /*
   * Este metodo permite leer el contenido del registro de los datos de las partidas jugadas 
   * los cuales estan registrados en un documento XML
   */  
  public static void leerXML() {
    
    try {
    
      File archivo = new File("Historial_Partidas.xml");
      
      DocumentBuilderFactory fabricar = DocumentBuilderFactory.newInstance();
      DocumentBuilder constructor = fabricar.newDocumentBuilder();
      Document documento = constructor.parse(archivo);

      documento.getDocumentElement().normalize();

      System.out.println("Elemento raiz: " + documento.getDocumentElement().getNodeName());
      NodeList lista1 = documento.getElementsByTagName("partida");
      for (int i = 0; i < lista1.getLength(); i++) {
        
        Node nodo = lista1.item(i);
        System.out.println("Elemento: " + nodo.getNodeName());

        if (nodo.getNodeType() == Node.ELEMENT_NODE) {

          Element elemento = (Element) nodo;
          /*
          System.out.println("tipo" + elemento.getElementsByTagName("tipo").item(0).getTextContent());
          
          System.out.println("numerosCantados" + elemento.getElementsByTagName("numerosCantados").item(0).getTextContent());
          
          System.out.println("ganadores" + elemento.getElementsByTagName("ganadores").item(0).getTextContent());
          
          System.out.println("fecha" + elemento.getElementsByTagName("fecha").item(0).getTextContent());
          
          System.out.println("hora" + elemento.getElementsByTagName("hora").item(0).getTextContent());
          */
          String tipo = elemento.getElementsByTagName("tipo").item(0).getTextContent();
          //System.out.println(tipo);

          //Sacar el elemento y combertirlo a un enetero.
          String numerosCantadosString = elemento.getElementsByTagName("numerosCantados").item(0).getTextContent();
          
         //System.out.println(numerosCantadosString);
          
          numerosCantadosString = numerosCantadosString.substring(1, numerosCantadosString.length() - 1); // Elimina los corchetes
          
          String[] nuStrings = numerosCantadosString.split(", "); // Divide el String en un array usando la coma como separador
          
          //List<String> numerosString = Arrays.asList(nuStrings); // Convierte el array a una lista
          
          List<Integer> numerosCantados = new ArrayList<Integer>();
          
          //for (String s : nuStrings) {
            //numerosCantados.add(Integer.parseInt(s));
          //}
          //for (int j : numerosCantados) {
            //System.out.println(j);
          //}

          String ganadoresString = elemento.getElementsByTagName("ganadores").item(0).getTextContent();
          //System.out.println(ganadoresString);
          ganadoresString = ganadoresString.substring(1, ganadoresString.length() - 1); // Elimina los corchetes
          String[] ganadorString = ganadoresString.split(", "); // Divide el String en un array usando la coma como separador
          List<String> ganadores = Arrays.asList(ganadorString);

          //for (String ele : ganadores) {
            
            //System.out.println(ele);
          //}
          
          String fecha = elemento.getElementsByTagName("fecha").item(0).getTextContent();
          //System.out.println(fecha);
          
          String hora = elemento.getElementsByTagName("hora").item(0).getTextContent();
          //System.out.println(hora);
          /*
          
          // Registro de los datos en variables=============================
          String tipo = elemento.getElementsByTagName("tipo").item(0).getTextContent();
          System.out.println(tipo);
          //String tipo = elemento.getElementsByTagName("tipo").item(0).getTextContent();
          /*
          
          //Pasemos esta madre a Entero, asi bien locos
          String numerosString = elemento.getElementsByTagName("numerosCantados").item(0).getTextContent();
          List<String> numerosLiStrings = Arrays.asList(numerosString.split(","));
          List<String> numerosLiStrings2 = new ArrayList<String>();
          List<Integer> numeroJugados = new ArrayList<Integer>();
          numerosLiStrings2 =  numerosLiStrings; 
          numerosLiStrings2.remove(0);
          numerosLiStrings2.remove(numerosLiStrings.size() - 1);
          
          for (String element : numerosLiStrings2) {
            numeroJugados.add(Integer.parseInt(element));
          }
          
          String ganadoreString = elemento.getElementsByTagName("ganadores").item(0).getTextContent();
          List<String> ganadores = Arrays.asList(ganadoreString.split(","));
          List<String> ganadores2 = new ArrayList<String>();
          ganadores2 = ganadores;
          ganadores2.remove(0);
          ganadores2.remove(ganadores.size() - 1);
          
          
          
          //System.out.println("" + elemento.getElementsByTagName("").item(i).getTextContent());
          //System.out.println("" + elemento.getElementsByTagName("").item(i).getTextContent());
          
          
          for (Integer num1 : numeroJugados) {
            System.out.println(num1);
          
          }
          for (String valor1 : ganadores2) {
            System.out.println(valor1);
          }
          
          
          String fechaString = elemento.getElementsByTagName("fecha").item(0).getTextContent();
          System.out.println(fechaString);
          
          String horaString = elemento.getElementsByTagName("hora").item(0).getTextContent();          
          System.out.println(horaString);
          //System.out.println();
           */
        }

      }
    
    }  catch (Exception e) {
      e.printStackTrace();// Agregar algo mas.
    }   

  }
 
  
  public int calcularRepetidos() {

    try {
    
      File archivo = new File("Historial_Partidas.xml");
      
      DocumentBuilderFactory fabricar = DocumentBuilderFactory.newInstance();
      DocumentBuilder constructor = fabricar.newDocumentBuilder();
      Document documento = constructor.parse(archivo);

      documento.getDocumentElement().normalize();

      System.out.println("Elemento raiz: " + documento.getDocumentElement().getNodeName());
      NodeList lista1 = documento.getElementsByTagName("partida");
      for (int i = 0; i < lista1.getLength(); i++) {
        
        Node nodo = lista1.item(i);
        System.out.println("Elemento: " + nodo.getNodeName());

        if (nodo.getNodeType() == Node.ELEMENT_NODE) {

          Element elemento = (Element) nodo;

          String numerosCantadosString = elemento.getElementsByTagName("numerosCantados").item(0).getTextContent();

          numerosCantadosString = numerosCantadosString.substring(1, numerosCantadosString.length() - 1); // Elimina los corchetes

          String[] nuStrings = numerosCantadosString.split(", "); // Divide el String en un array usando la coma como separador

          //List<String> numerosString = Arrays.asList(nuStrings); // Convierte el array a una lista

          List<Integer> numerosCantados = new ArrayList<Integer>();

          //for (String s : nuStrings) {
          //numerosCantados.add(Integer.parseInt(s));
          //}
          //for (int j : numerosCantados) {
          //System.out.println(j);
          //}
          List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4); // Tu lista aquí

          Map<Integer, Integer> countMap = new HashMap<>();
          for (int num : list) {
              countMap.put(num, countMap.getOrDefault(num, 0) + 1);
          }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        for (int f = 0; f < Math.min(10, entryList.size()); f++) {
            System.out.println("Number: " + entryList.get(f).getKey() + ", Count: " + entryList.get(i).getValue());
        }
    
          String ganadoresString = elemento.getElementsByTagName("ganadores").item(0).getTextContent();
          //System.out.println(ganadoresString);
          ganadoresString = ganadoresString.substring(1, ganadoresString.length() - 1); // Elimina los corchetes
          String[] ganadorString = ganadoresString.split(", "); // Divide el String en un array usando la coma como separador
          List<String> ganadores = Arrays.asList(ganadorString);
          return 1;

        }

      }
    
    } catch (Exception e) {
      e.printStackTrace();// Agregar algo mas.
    }
    return 1;
  }
  /*
   * Este metodo permite la visualizacion de los datos de este clase
   * 
   * @return msg: Datos de la clase.
   * 
   */
  public String toString() {
    String msg = "";

    return msg;
  }

} 