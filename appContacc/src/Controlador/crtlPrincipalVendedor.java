
package Controlador;

import Modelo.Trabajos;
import Vista.frmPrincipalVendedor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author danie
 */
public class crtlPrincipalVendedor implements MouseListener{

    frmPrincipalVendedor vista;
    public crtlPrincipalVendedor(Trabajos modelo, frmPrincipalVendedor vista) {
        
        this.vista = vista;  
        vista.BtnVolver.addMouseListener(this);
        
        modelo.Mostrar(vista.tbVendedor);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if (e.getSource() == vista.BtnVolver) {
        Vista.frmLogin.initFrmLogin();
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
