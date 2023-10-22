/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.MessagingException;

/**
 * Esta clase representa una cuenta de correo electrónico y proporciona 
 * métodos para enviar correos electrónicos.
 * 
 * @author Dylan Montiel Zúñiga
 * @version 1.0
 */
public class CuentaCorreo {
  private String usuario;
  private String clave = "dapqojpvcopkgmiv";
  private String servidor = "smtp.gmail.com";
  private String puerto = "587";
  private Properties propiedades;
  
  /**
   * Método constructor que inicializa una instancia de CuentaCorreo con la dirección de correo electrónico proporcionada.
   *
   * @param pCorreo La dirección de correo electrónico de la cuenta.
   */
  public CuentaCorreo(String pCorreo) {
    propiedades = new Properties();
    propiedades.put("mail.smtp.host", servidor);
    propiedades.put("mail.smtp.port", puerto);
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    usuario = pCorreo;
  }

  /**
   * Método para abrir una sesión de correo electrónico autenticada.
   *
   * @return Una instancia de Session para la cuenta de correo.
   */
  private Session abrirSesion() {
    Session sesion = Session.getInstance(propiedades,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(usuario, clave);
        }      
    });
    return sesion;
  }
  
  /**
   * Método para enviar un correo electrónico con archivos adjuntos.
   *
   * @param destinatario La dirección de correo electrónico del destinatario.
   * @param tituloCorreo El asunto del correo electrónico.
   * @param cuerpo El cuerpo del correo electrónico.
   * @param archivosAdjuntos Un arreglo de cadenas de caracteres que representa los archivos a adjuntar.
   */
  public void enviarCorreo(String destinatario, String tituloCorreo, String cuerpo, String[] archivosAdjuntos) {
    
    Session sesion = abrirSesion();

    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(
        Message.RecipientType.TO,
        InternetAddress.parse(destinatario)
      );
      message.setSubject(tituloCorreo);

      // Crear la parte del cuerpo del mensaje
      MimeBodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setText(cuerpo);

      // Crear la parte para cada archivo adjunto
      MimeMultipart multipart = new MimeMultipart();
      multipart.addBodyPart(mimeBodyPart);

      // Adjuntar los archivos al mensaje
      for (String archivo : archivosAdjuntos) {
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.attachFile(archivo);
        multipart.addBodyPart(adjunto);
      }

      // Establecer el contenido del mensaje
      message.setContent(multipart);

      // Enviar el mensaje
      Transport.send(message);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
