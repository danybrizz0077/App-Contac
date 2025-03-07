package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.UsuarioProduccion;
import Vista.frmRegistroProduccion;
import javax.swing.JOptionPane;

public class crtlRegistroProduccion implements MouseListener {

    UsuarioProduccion modelo;
    frmRegistroProduccion vista;

    // Constructor
    public crtlRegistroProduccion(UsuarioProduccion Modelo, frmRegistroProduccion Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnInicioSesion.addMouseListener(this);
        vista.btnRegistroo.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnRegistroo) {
            // Validar si los campos están vacíos
            if (vista.txtNombre.getText().isEmpty() || vista.txtCorreo.getText().isEmpty() || vista.txtContraseña.getText().isEmpty()) {
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
            String contrasena = vista.txtContraseña.getText();
            if (contrasena.length() < 6) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener al menos 6 caracteres.");
                return;
            }

            // Si pasa las validaciones, se guardan los datos
            modelo.setCorreo_pro(correo);
            modelo.setNombre_pro(vista.txtNombre.getText());
            modelo.setContrasena(modelo.convertirSHA256(contrasena));
            
            modelo.GuardarUsuarioProduccion();
            
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(vista, "Usuario guardado exitosamente.");
        }

        // Clic al botón de Ir Al Login
        if (e.getSource() == vista.btnInicioSesion) {
            Vista.frmLoginProduccion.initFrmLoginProduccion();
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
