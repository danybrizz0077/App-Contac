
package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.UsuarioProduccion;
import Vista.frmLoginProduccion;

import javax.swing.JOptionPane;


public class ctrlLoginProduccion implements MouseListener{
    
     
    UsuarioProduccion modelo;
    frmLoginProduccion vista;
   
     //2-Constructor 
    public ctrlLoginProduccion(UsuarioProduccion Modelo, frmLoginProduccion Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
          vista.BtnVolver.addMouseListener(this);

        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnRegistro.addMouseListener(this);
    }

    

    @Override
public void mouseClicked(MouseEvent e) {
    if (e.getSource() == vista.btnIniciarSesion) {
        modelo.setCorreo_pro(vista.txtCorreo.getText());
        modelo.setContrasena(modelo.convertirSHA256(vista.txtContra.getText()));

        // Variable "comprobar" guarda el resultado de iniciarSesion()
        boolean comprobar = modelo.iniciarSesion();

        if (comprobar == true) {
            JOptionPane.showMessageDialog(vista, "¡Bienvenido!");

            // Inicializa la nueva pantalla principal
            Vista.frmPrincipalProduccion.initfrmPrincipalProduccion();
            
            // Cierra la ventana de login
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Correo o contraseña incorrecta");
        }
    }

    // Clic al botón de Ir Al Registro
    if (e.getSource() == vista.btnRegistro) {
        Vista.frmRegistroProduccion.initFrmRegistroProduccion();
        vista.dispose();
    }
      if (e.getSource() == vista.BtnVolver) {
        Vista.frmInicio.initFrmInicio();
        vista.dispose();
    }
    
}


    @Override
    public void mousePressed(MouseEvent e) {
        }

    @Override
    public void mouseReleased(MouseEvent e) {
     }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
   }
    
}
