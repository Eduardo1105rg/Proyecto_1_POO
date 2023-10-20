package logicadenegocios;

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
    
    crearRegistro();
    leerXML();
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

          System.out.println("tipo" + elemento.getElementsByTagName("tipo").item(0).getTextContent());

          System.out.println("numerosCantados" + elemento.getElementsByTagName("numerosCantados").item(0).getTextContent());
          
          System.out.println("ganadores" + elemento.getElementsByTagName("ganadores").item(0).getTextContent());
          
          System.out.println("fecha" + elemento.getElementsByTagName("fecha").item(0).getTextContent());
          
          System.out.println("hora" + elemento.getElementsByTagName("hora").item(0).getTextContent());
          
          //System.out.println("" + elemento.getElementsByTagName("").item(i).getTextContent());
          //System.out.println("" + elemento.getElementsByTagName("").item(i).getTextContent());
          
        }

      }
    
    }  catch (Exception e) {
      e.printStackTrace();// Agregar algo mas.
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

    return msg;
  }

} 
