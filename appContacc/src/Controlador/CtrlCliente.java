package Controlador;

import Modelo.Cliente;
import Vista.frmClientes;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CtrlCliente implements ActionListener {

    private Cliente modelo;
    private frmClientes vista;

    public CtrlCliente(frmClientes vista) {
        this.modelo = new Cliente(); // Inicialización del objeto modelo
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnActualizar1.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnTrabajos.addActionListener(this);

        // Cargar los clientes cuando se inicie la vista
        modelo.Mostrar(vista.tbCliente); // Esto llena la tabla con los datos

        // Evento para seleccionar datos desde la tabla
        this.vista.tbCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelo.cargarDatosTabla(vista); // Carga los datos seleccionados en los campos de texto
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Guardar
        if (e.getSource() == vista.btnAgregar) {
            if (validarCampos()) {
                modelo.setNombre_Clie(vista.txtNombreCliente.getText());
                modelo.Guardar();
                modelo.Mostrar(vista.tbCliente);  // Actualiza la tabla después de guardar
                limpiarCampos();
            }
        }

        // Eliminar
        if (e.getSource() == vista.btnEliminar) {
            modelo.Eliminar(vista.tbCliente);
            modelo.Mostrar(vista.tbCliente);  // Actualiza la tabla después de eliminar
            limpiarCampos();  // Limpiar el texto en el campo
        }

        // Actualizar
        if (e.getSource() == vista.btnActualizar1) {
    if (validarCampos()) {
        String nuevoNombre = vista.txtNombreCliente.getText();
        modelo.Actualizar(vista.tbCliente, nuevoNombre);
        modelo.Mostrar(vista.tbCliente);  // Refrescar la tabla
        limpiarCampos();
    }
}


        // Limpiar
        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
        
        if (e.getSource() == vista.btnTrabajos) {
            Vista.frmTrabajo.initfrmTrabajo();
            vista.dispose();
        }
    }

    // Método para validar los campos del formulario
    private boolean validarCampos() {
        if (vista.txtNombreCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            return false;
        }
        return true;
    }

    // Limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtNombreCliente.setText("");
    }
}
