/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;

/**
 *
 * @author dylan
 */
public class GUI_MENU_PRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form GUI_MENU_PRINCIPAL
     */

    public GUI_MENU_PRINCIPAL() {
        initComponents();
        setLocationRelativeTo(null);

        // Agrega un manejador de eventos al botón
        btn_CrearCartones.addActionListener((ActionEvent e) -> {
            // Crea una instancia de la nueva ventana y hazla visible
            GUI_CrearCartones gui_CrearCartones = new GUI_CrearCartones();
            gui_CrearCartones.setVisible(true);
        });

        btn_VerCartones.addActionListener((ActionEvent e) -> {
            // Crea una instancia de la nueva ventana y hazla visible
            GUI_VerCartones gui_VerCartones = new GUI_VerCartones();
            gui_VerCartones.setVisible(true);
        });  

        btn_RegistrarJugador.addActionListener((ActionEvent e) -> {
            // Crea una instancia de la nueva ventana y hazla visible
            GUI_RegistrarJugador gui_RegistrarJugador = new GUI_RegistrarJugador();
            gui_RegistrarJugador.setVisible(true);
        });        

        btn_EnviarCartones.addActionListener((ActionEvent e) -> {
            // Crea una instancia de la nueva ventana y hazla visible
            GUI_EnviarCartones gui_EnviarCartones = new GUI_EnviarCartones();
            gui_EnviarCartones.setVisible(true);
        });         
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_General = new javax.swing.JPanel();
        jl_Titulo = new javax.swing.JLabel();
        jp_Admin = new javax.swing.JPanel();
        btn_VerCartones = new javax.swing.JButton();
        jl_Administracion = new javax.swing.JLabel();
        btn_CrearCartones = new javax.swing.JButton();
        btn_RegistrarJugador = new javax.swing.JButton();
        btn_EnviarCartones = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jp_General.setBackground(new java.awt.Color(255, 255, 255));

        jl_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_Titulo.setText("Bienvenido a tu bingo virtual!");

        jp_Admin.setBackground(new java.awt.Color(204, 204, 255));

        btn_VerCartones.setBackground(new java.awt.Color(102, 102, 102));
        btn_VerCartones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_VerCartones.setForeground(new java.awt.Color(255, 255, 255));
        btn_VerCartones.setText("Ver Cartones ");
        btn_VerCartones.setActionCommand("Crear ");

        jl_Administracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_Administracion.setText("Administración");

        btn_CrearCartones.setBackground(new java.awt.Color(102, 102, 102));
        btn_CrearCartones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_CrearCartones.setForeground(new java.awt.Color(255, 255, 255));
        btn_CrearCartones.setText("Crear Cartones");
        btn_CrearCartones.setActionCommand("Crear ");
        btn_CrearCartones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearCartonesActionPerformed(evt);
            }
        });

        btn_RegistrarJugador.setBackground(new java.awt.Color(102, 102, 102));
        btn_RegistrarJugador.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_RegistrarJugador.setForeground(new java.awt.Color(255, 255, 255));
        btn_RegistrarJugador.setText("Registrar Jugador");
        btn_RegistrarJugador.setActionCommand("Crear ");

        btn_EnviarCartones.setBackground(new java.awt.Color(102, 102, 102));
        btn_EnviarCartones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_EnviarCartones.setForeground(new java.awt.Color(255, 255, 255));
        btn_EnviarCartones.setText("Enviar Cartones");
        btn_EnviarCartones.setActionCommand("Crear ");

        javax.swing.GroupLayout jp_AdminLayout = new javax.swing.GroupLayout(jp_Admin);
        jp_Admin.setLayout(jp_AdminLayout);
        jp_AdminLayout.setHorizontalGroup(
            jp_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_EnviarCartones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_RegistrarJugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_Administracion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_VerCartones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_CrearCartones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jp_AdminLayout.setVerticalGroup(
            jp_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Administracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CrearCartones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_VerCartones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_RegistrarJugador)
                .addGap(18, 18, 18)
                .addComponent(btn_EnviarCartones)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jp_GeneralLayout = new javax.swing.GroupLayout(jp_General);
        jp_General.setLayout(jp_GeneralLayout);
        jp_GeneralLayout.setHorizontalGroup(
            jp_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Titulo)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_GeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_GeneralLayout.setVerticalGroup(
            jp_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Titulo)
                .addGap(18, 18, 18)
                .addComponent(jp_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CrearCartonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearCartonesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CrearCartonesActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MENU_PRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CrearCartones;
    private javax.swing.JButton btn_EnviarCartones;
    private javax.swing.JButton btn_RegistrarJugador;
    private javax.swing.JButton btn_VerCartones;
    private javax.swing.JLabel jl_Administracion;
    private javax.swing.JLabel jl_Titulo;
    private javax.swing.JPanel jp_Admin;
    private javax.swing.JPanel jp_General;
    // End of variables declaration//GEN-END:variables
}
