package Controlador;

import static Vista.frmClientes.initfrmClientes;
import Vista.frmPrincipalProduccion;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class crtlPrincipalProduccion implements MouseListener {

    frmPrincipalProduccion vista;

    public crtlPrincipalProduccion(frmPrincipalProduccion vista) {
        this.vista = vista;
        vista.BtnVolver.addMouseListener(this);
        vista.btnClientes.addMouseListener(this);
        vista.btnTrabajos.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnClientes) {
            Vista.frmClientes.initfrmClientes();
            vista.dispose();
        }

        if (e.getSource() == vista.btnTrabajos) {
            Vista.frmTrabajo.initfrmTrabajo();
            vista.dispose();
            /*
            System.err.println("se dio clic");
            try {
                Vista.frmTrabajo.initfrmTrabajo();
                vista.dispose();
            } catch (Exception ex) {
                ex.printStackTrace(); // Muestra el error en la consola
                JOptionPane.showMessageDialog(null, "Error al abrir frmTrabajo: " + ex.getMessage());
            }*/
        }

        if (e.getSource() == vista.BtnVolver) {
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
