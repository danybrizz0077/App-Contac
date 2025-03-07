
package Controlador;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmInicio;
import javax.swing.JOptionPane;



public class crtlInicio implements MouseListener{
    
  
    frmInicio vista;
    
    
    public crtlInicio ( frmInicio Vista) {
       
        this.vista = Vista;

        vista.btnVendedor.addMouseListener(this);
        vista.btnProduccion.addMouseListener(this);
    }

    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
          if(e.getSource() == vista.btnVendedor){
            Vista.frmLogin.initFrmLogin();
            vista.dispose();
        }
     
      if(e.getSource() == vista.btnProduccion){
            Vista.frmLoginProduccion.initFrmLoginProduccion();
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
