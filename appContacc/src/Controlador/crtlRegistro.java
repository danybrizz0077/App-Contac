package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.UsuarioVendedor;
import Vista.frmRegistro;
import javax.swing.JOptionPane;

public class crtlRegistro implements MouseListener {

    UsuarioVendedor modelo;
    frmRegistro vista;

    // Constructor
    public crtlRegistro(UsuarioVendedor Modelo, frmRegistro Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        vista.BtnVolver.addMouseListener(this);
        vista.btnRegistroo.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnRegistroo) {
            // Validar si los campos están vacíos
            if (vista.txtCorreo.getText().isEmpty() || vista.txtCorreo.getText().isEmpty() || vista.txtContraseñaa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, llene todos los campos.");
                return;
            }

            // Validar formato de correo
            String correo = vista.txtCorreo.getText();
            if (!correo.contains("@") || !correo.contains(".com")) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo electrónico válido.");
                return;
            }

            // Validar que la contraseña tenga al menos 6 caracteres
            String contrasena = vista.txtContraseñaa.getText();
            if (contrasena.length() < 6) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener al menos 6 caracteres.");
                return;
            }

            // Si pasa las validaciones, se guardan los datos
            modelo.setCorreo_Ven(correo);
            modelo.setNombre_Ven(vista.txtNombre.getText());
            modelo.setContrasena(modelo.convertirSHA256(contrasena));
            
            modelo.GuardarUsuario();
            
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(vista, "Usuario guardado exitosamente.");
        }

        // Clic al botón de Ir Al Login
        if (e.getSource() == vista.BtnVolver) {
            Vista.frmTrabajo.initfrmTrabajo();
            vista.dispose();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
