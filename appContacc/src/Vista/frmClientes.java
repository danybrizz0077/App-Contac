/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlCliente;
import javax.swing.JOptionPane;


/**
 *
 * @author danie
 */
public class frmClientes extends javax.swing.JFrame {

    /**
     * Creates new form frmClientes
     */
     public frmClientes() {
        initComponents();
        this.setLocationRelativeTo(this);
           setResizable(false); // Evitar redimensionar
           }
    
     public static void initfrmClientes(){
        frmClientes vista = new frmClientes();
         CtrlCliente controlador = new CtrlCliente(vista);
        
        vista.setVisible(true);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTrabajos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCliente1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        btnActualizar2 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        btnTrabajos.setBackground(new java.awt.Color(33, 45, 62));
        btnTrabajos.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnTrabajos.setForeground(new java.awt.Color(255, 255, 255));
        btnTrabajos.setText("Trabajos");
        btnTrabajos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnTrabajos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(btnTrabajos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente?");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 570, 60));

        jTextField1.setBackground(new java.awt.Color(18, 30, 49));
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 974, 452, 39));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CONTRASEÑA");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 944, 179, 24));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 1019, 452, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(73, 181, 172));
        jLabel7.setMaximumSize(new java.awt.Dimension(554, 512));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 391, -1, 39));
        jPanel3.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 40));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿Deseas agregar un nuevo");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 60));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de Cliente");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtNombreCliente.setBackground(new java.awt.Color(153, 0, 51));
        txtNombreCliente.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreCliente.setBorder(null);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 320, 30));

        jSeparator3.setForeground(new java.awt.Color(33, 45, 62));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, 20));

        tbCliente.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCliente.setGridColor(new java.awt.Color(255, 204, 102));
        jScrollPane1.setViewportView(tbCliente);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 590, 250));

        btnLimpiar.setBackground(new java.awt.Color(33, 45, 62));
        btnLimpiar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 120, 30));

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 120, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre de Cliente");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtNombreCliente1.setBackground(new java.awt.Color(153, 0, 51));
        txtNombreCliente1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtNombreCliente1.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreCliente1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreCliente1.setBorder(null);
        txtNombreCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCliente1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombreCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 320, 30));

        jSeparator4.setForeground(new java.awt.Color(33, 45, 62));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, 20));

        btnAgregar.setBackground(new java.awt.Color(33, 45, 62));
        btnAgregar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 100, 40));

        btnActualizar1.setBackground(new java.awt.Color(33, 45, 62));
        btnActualizar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("Actualizar");
        btnActualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 30));

        btnAgregar1.setBackground(new java.awt.Color(33, 45, 62));
        btnAgregar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 100, 40));

        btnActualizar2.setBackground(new java.awt.Color(33, 45, 62));
        btnActualizar2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnActualizar2.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar2.setText("Actualizar");
        btnActualizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 30));

        btnLimpiar1.setBackground(new java.awt.Color(33, 45, 62));
        btnLimpiar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnLimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 120, 30));

        btnEliminar1.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setText("Eliminar");
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 120, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 640, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrabajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrabajosActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtNombreCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCliente1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmClientes();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar1;
    public javax.swing.JButton btnActualizar2;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAgregar1;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEliminar1;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnLimpiar1;
    public javax.swing.JButton btnTrabajos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label1;
    public javax.swing.JTable tbCliente;
    public javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txtNombreCliente1;
    // End of variables declaration//GEN-END:variables
}
