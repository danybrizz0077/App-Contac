
package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.UsuarioVendedor;
import Vista.frmLogin;

import javax.swing.JOptionPane;



public class ctrlLogin implements MouseListener{
    
     
    UsuarioVendedor modelo;
    frmLogin vista;
   
     //2-Constructor 
    public ctrlLogin(UsuarioVendedor Modelo, frmLogin Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        vista.BtnVolver.addMouseListener(this);

        vista.btnIniciarSesion.addMouseListener(this);
    }

    

   @Override
public void mouseClicked(MouseEvent e) {
    if (e.getSource() == vista.btnIniciarSesion) {
        modelo.setCorreo_Ven(vista.txtCorreo.getText());
        modelo.setContrasena(modelo.convertirSHA256(vista.txtContra.getText()));

        // Variable para verificar si el usuario existe
        boolean comprobar = modelo.iniciarSesion();

        if (comprobar == true) {
            JOptionPane.showMessageDialog(vista, "¡Bienvenido!");

            // Abrir la pantalla principal del vendedor
            Vista.frmPrincipalVendedor.initFrmPrincipalVendedor();

            // Cerrar la pantalla actual (frmLogin)
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Correo o contraseña incorrecto");
        }
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

       
    
    
  
