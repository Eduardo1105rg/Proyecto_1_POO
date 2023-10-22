/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.CartonBingo;
import modelo.CuentaCorreo;

/**
 *
 * @author dylan
 */
public class GUI_EnviarCartones extends javax.swing.JFrame {
    private final String rutaCartones = "src/main/java/modelo/Cartones/Imagenes/";
    private final List<String> cedulasEnviadas = new ArrayList<>();
    private CuentaCorreo cuentaCorreo;
    
    /**
     * Creates new form GUI_EnviarCartones
     */
    public GUI_EnviarCartones() {
        initComponents();
        setLocationRelativeTo(null);

        btn_EnviarCartones.addActionListener((java.awt.event.ActionEvent evt) -> {
            int cantidad = (int) js_Cantidad.getValue();   
            String cedula = jtf_Cedula.getText().trim();            
            EnviarCartones(cantidad, cedula);            
        });                    
    }

    private boolean validarCedula(String cedula) {
        return cedula.trim().matches("^\\d{9}$");
    }    

    private String obtenerCorreoPorCedula(String cedula) {
        try (Scanner scanner = new Scanner(new File("src/main/java/modelo/RegistroJugadores/RegistroJugadores.csv"))) {
            while (scanner.hasNextLine()) {
                String[] partes = scanner.nextLine().split(";");
                if (partes.length >= 3) {
                    String cedulaRegistro = partes[1].trim();
                    String correo = partes[2].trim();
                    if (cedulaRegistro.equals(cedula)) {
                        System.out.println("Correo: " + correo);
                        return correo;                        
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }    
    
    private void EnviarCartones(int cantidad, String cedula) {

        if (!validarCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "Cédula inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cedulasEnviadas.contains(cedula)) {
            JOptionPane.showMessageDialog(this, "Los cartones ya se enviaron para esta cédula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el correo del jugador por cédula
        String correo = obtenerCorreoPorCedula(cedula);
        if (correo == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un jugador con la cédula especificada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Enviar cartones aleatoriamente
        enviarCartonesAleatorios(correo, cantidad);

        // Registrar que se han enviado los cartones
        cedulasEnviadas.add(cedula);

        JOptionPane.showMessageDialog(this, "Cartones enviados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void enviarCartonesAleatorios(String correo, int cantidad) {

        GUI_CrearCartones guiCrearCartones = GUI_CrearCartones.getInstance();
        ArrayList<CartonBingo> cartonesGenerados = guiCrearCartones.getCartonesGenerados();

        if (cartonesGenerados.isEmpty()) {
            System.out.println("No se han generado cartones aún.");
        } else {
            for (CartonBingo carton : cartonesGenerados) {
                System.out.println("Identificador del Cartón: " + carton.getIdentificador() + ", Matriz: " + Arrays.toString(carton.getMatrizNumeros()));
            }
        }       
        
        File carpetaCartones = new File(rutaCartones);
        if (!carpetaCartones.exists() || !carpetaCartones.isDirectory()) {
            JOptionPane.showMessageDialog(this, "La carpeta de cartones no existe o no es una carpeta válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File[] archivosCartones = carpetaCartones.listFiles();
        if (archivosCartones == null || archivosCartones.length == 0) {
            JOptionPane.showMessageDialog(this, "No hay cartones disponibles para enviar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Directorio base donde se encuentran los cartones
        String directorioCartones = "src/main/java/modelo/Cartones/Imagenes/";

        // Escoge 'cantidad' de cartones aleatoriamente
        Random random = new Random();
        String[] cartonesAleatorios = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio = random.nextInt(archivosCartones.length);

            // Nombre del cartón (por ejemplo, "carton1.png")
            String nombreCarton = archivosCartones[indiceAleatorio].getName();

            // Ruta completa del cartón
            String rutaCartonRelativa = directorioCartones + nombreCarton;

            cartonesAleatorios[i] = rutaCartonRelativa;
        }

        // Enviar los cartones al correo del jugador
        System.out.println(Arrays.toString(cartonesAleatorios));
        cuentaCorreo = new CuentaCorreo(correo);
        cuentaCorreo.enviarCorreo(correo, "Cartones Bingo", "Adjuntamos tus cartones para el juego de Bingo.", cartonesAleatorios);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_Cuerpo = new javax.swing.JPanel();
        jp_Inputs = new javax.swing.JPanel();
        jl_Cantidad = new javax.swing.JLabel();
        js_Cantidad = new javax.swing.JSpinner();
        jl_Cedula = new javax.swing.JLabel();
        jtf_Cedula = new javax.swing.JTextField();
        btn_EnviarCartones = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jp_Encabezado.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Enviar cartones a jugador registrado");

        javax.swing.GroupLayout jp_EncabezadoLayout = new javax.swing.GroupLayout(jp_Encabezado);
        jp_Encabezado.setLayout(jp_EncabezadoLayout);
        jp_EncabezadoLayout.setHorizontalGroup(
            jp_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_EncabezadoLayout.setVerticalGroup(
            jp_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_Cuerpo.setBackground(new java.awt.Color(204, 204, 255));

        jl_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Cantidad.setText("Cantidad:");

        js_Cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        js_Cantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        js_Cantidad.setEditor(new javax.swing.JSpinner.NumberEditor(js_Cantidad, ""));

        jl_Cedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Cedula.setText("Cédula:");

        jtf_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_CedulaActionPerformed(evt);
            }
        });

        btn_EnviarCartones.setText("Enviar Cartones");

        javax.swing.GroupLayout jp_InputsLayout = new javax.swing.GroupLayout(jp_Inputs);
        jp_Inputs.setLayout(jp_InputsLayout);
        jp_InputsLayout.setHorizontalGroup(
            jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_InputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Cantidad)
                    .addComponent(jl_Cedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(js_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_InputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_EnviarCartones)
                .addGap(106, 106, 106))
        );
        jp_InputsLayout.setVerticalGroup(
            jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_InputsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cantidad)
                    .addComponent(js_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jtf_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn_EnviarCartones)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jp_CuerpoLayout = new javax.swing.GroupLayout(jp_Cuerpo);
        jp_Cuerpo.setLayout(jp_CuerpoLayout);
        jp_CuerpoLayout.setHorizontalGroup(
            jp_CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_CuerpoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jp_Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jp_CuerpoLayout.setVerticalGroup(
            jp_CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_CuerpoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jp_Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_Cuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_Cuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_CedulaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_EnviarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_EnviarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_EnviarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_EnviarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_EnviarCartones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_EnviarCartones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jl_Cantidad;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JPanel jp_Cuerpo;
    private javax.swing.JPanel jp_Encabezado;
    private javax.swing.JPanel jp_Inputs;
    private javax.swing.JSpinner js_Cantidad;
    private javax.swing.JTextField jtf_Cedula;
    // End of variables declaration//GEN-END:variables
}
