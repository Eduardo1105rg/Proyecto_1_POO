/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class GUI_RegistrarJugador extends javax.swing.JFrame {
    private final HashSet<String> cedulasRegistradas = new HashSet<>();
    
    /**
     * Creates new form GUI_RegistrarJugador
     */
    public GUI_RegistrarJugador() {
        initComponents();
        setLocationRelativeTo(null);
        
        cargarCedulasRegistradas();
        btn_Registrar.addActionListener((java.awt.event.ActionEvent evt) -> {
            String nombre = jtf_Nombre.getText().trim();
            String correo = jtf_Correo.getText().trim();     
            String cedula = jtf_Cedula.getText().trim();            
            RegistrarJugador(nombre, correo, cedula);            
        });         
    }

    private boolean validarNombre(String nombre) {
        return !nombre.trim().isEmpty();
    }

    private boolean validarCorreo(String correo) {
        return correo.trim().matches("^.+@(gmail|hotmail)\\..+$");
    }

    private boolean validarCedula(String cedula) {
        return cedula.trim().matches("^\\d{9}$");
    }
    
    
    private void RegistrarJugador(String nombre, String correo, String cedula) {

        if (!validarNombre(nombre)) {
            // Mostrar mensaje de error para el nombre
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarCorreo(correo)) {
            // Mostrar mensaje de error para el correo
            JOptionPane.showMessageDialog(this, "Correo inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarCedula(cedula)) {
            // Mostrar mensaje de error para la cédula
             JOptionPane.showMessageDialog(this, "Cedula inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        

        // Validar que la cédula no se haya registrado previamente
        if (cedulasRegistradas.contains(cedula)) {
            JOptionPane.showMessageDialog(this, "Cedula ya registrada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        
        // Guardar en un csv
        try (FileWriter writer = new FileWriter("src/main/java/modelo/RegistroJugadores/RegistroJugadores.csv", true)) {
            // Escribir una línea en el archivo CSV
            writer.append(nombre + ";" + cedula + ";" + correo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        // Agregar la cédula registrada al HashSet
        cedulasRegistradas.add(cedula);        
        
        JOptionPane.showMessageDialog(this, "Jugador registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // Cerrar el JFrame
        this.dispose();            
    }

    // Cargar cédulas registradas desde el archivo CSV
    private void cargarCedulasRegistradas() {
        try (Scanner scanner = new Scanner(new File("src/main/java/modelo/RegistroJugadores/RegistroJugadores.csv"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                if (parts.length >= 3) {
                    String cedula = parts[1].trim();
                    cedulasRegistradas.add(cedula);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        jl_Titulo = new javax.swing.JLabel();
        jp_Cuerpo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jl_Correo = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jl_Cedula = new javax.swing.JLabel();
        btn_Registrar = new javax.swing.JButton();
        jtf_Nombre = new javax.swing.JTextField();
        jtf_Correo = new javax.swing.JTextField();
        jtf_Cedula = new javax.swing.JTextField();

        jp_Encabezado.setBackground(new java.awt.Color(255, 255, 255));

        jl_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_Titulo.setText("Registrar jugador");

        javax.swing.GroupLayout jp_EncabezadoLayout = new javax.swing.GroupLayout(jp_Encabezado);
        jp_Encabezado.setLayout(jp_EncabezadoLayout);
        jp_EncabezadoLayout.setHorizontalGroup(
            jp_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_EncabezadoLayout.setVerticalGroup(
            jp_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_Cuerpo.setBackground(new java.awt.Color(204, 204, 255));

        jl_Correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Correo.setText("Correo:");

        jl_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Nombre.setText("Nombre:");

        jl_Cedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Cedula.setText("Cedula:");

        btn_Registrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Registrar.setText("Registrar");

        jtf_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_NombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Nombre)
                    .addComponent(jl_Correo)
                    .addComponent(jl_Cedula))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_Nombre)
                    .addComponent(jtf_Correo)
                    .addComponent(jtf_Cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(btn_Registrar)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Nombre)
                    .addComponent(jtf_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Correo)
                    .addComponent(jtf_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jtf_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btn_Registrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jp_CuerpoLayout = new javax.swing.GroupLayout(jp_Cuerpo);
        jp_Cuerpo.setLayout(jp_CuerpoLayout);
        jp_CuerpoLayout.setHorizontalGroup(
            jp_CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_CuerpoLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        jp_CuerpoLayout.setVerticalGroup(
            jp_CuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_CuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jp_Cuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NombreActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_RegistrarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistrarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_RegistrarJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Correo;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Titulo;
    private javax.swing.JPanel jp_Cuerpo;
    private javax.swing.JPanel jp_Encabezado;
    private javax.swing.JTextField jtf_Cedula;
    private javax.swing.JTextField jtf_Correo;
    private javax.swing.JTextField jtf_Nombre;
    // End of variables declaration//GEN-END:variables
}