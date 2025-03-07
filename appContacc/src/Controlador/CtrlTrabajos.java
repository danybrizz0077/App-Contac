package Controlador;

import Modelo.Cliente;
import Modelo.Trabajos;
import Modelo.UsuarioVendedor;
import Vista.frmTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.EstadoTrabajo;

public class CtrlTrabajos  {

    private frmTrabajo vista;
    private Trabajos modeloTrabajos;
    private EstadoTrabajo modeloEstadoTrabajo;
    private UsuarioVendedor modeloUsuarioVendedor;
    private Cliente modeloCliente;

    public CtrlTrabajos(frmTrabajo vista, Trabajos modeloTrabajos, EstadoTrabajo modeloEstadoTrabajo, UsuarioVendedor modeloUsuarioVendedor, Cliente modeloCliente) {
        this.vista = vista;
        this.modeloTrabajos = modeloTrabajos;
        this.modeloEstadoTrabajo = modeloEstadoTrabajo;
        this.modeloUsuarioVendedor = modeloUsuarioVendedor;
        this.modeloCliente = modeloCliente;
        
        vista.IdTrabajo.setVisible(false);
        
        // Restricciones en las fechas (solo números, "/" y "-")
        vista.txtFechaFinalizacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo números, "/", "-"
                if (!(Character.isDigit(c) || c == '/' || c == '-')) {
                    e.consume(); // Evitar que el evento se procese
                }
            }
        });
        
        vista.txtFechaInicio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo números, "/", "-"
                if (!(Character.isDigit(c) || c == '/' || c == '-')) {
                    e.consume(); // Evitar que el evento se procese
                }
            }
        });

        // Restricción en la máquina (solo letras, máximo 4 caracteres)
        vista.txtMaquina.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo letras
                if (!Character.isLetter(c)) {
                    e.consume(); // Evitar que el evento se procese
                }
                // Limitar a 4 caracteres
                if (vista.txtMaquina.getText().length() >= 4) {
                    e.consume(); // Evitar que se agreguen más caracteres
                }
            }
        });

        // Restricción en la cantidad (solo números)
        vista.txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo números
                if (!Character.isDigit(c)) {
                    e.consume(); // Evitar que el evento se procese
                }
            }
        });

        modeloTrabajos.CargarComboClientes("Cliente", "Nombre_Clie", vista.cbxCliente);
        modeloTrabajos.CargarComboVendedor("UsuarioVendedor", "Nombre_Ven", vista.cbxVendedor);
        modeloTrabajos.CargarComboEstado("EstadoTrabajo", "Estado", vista.cbxEstado);
        
        modeloTrabajos.Mostrar(vista.tbTrabajos);
        // Configurar eventos
        configurarEventos();
        vista.cbxVendedor.addActionListener(e -> {
        // Verifica que la fuente del evento sea el JComboBox
        if (e.getSource() == vista.cbxVendedor) {
            // Obtén el elemento seleccionado y asegúrate de que no sea nulo
            Trabajos selectedItem = (Trabajos) vista.cbxVendedor.getSelectedItem();
            if(selectedItem.equals("Seleccionar Vendedor"))
            {JOptionPane.showMessageDialog(vista, "Debes seleccionar una opcion valida", "Error", JOptionPane.ERROR_MESSAGE); }
            else{
                if (selectedItem != null) {
                    int id = selectedItem.getID_UsuarioVendedor();
                    modeloTrabajos.setID_UsuarioVendedor(id);
                    System.out.println(id);
                }
            } 
        }
        });
        
        vista.cbxCliente.addActionListener(e -> {
        // Verifica que la fuente del evento sea el JComboBox
        if (e.getSource() == vista.cbxCliente) {
            // Obtén el elemento seleccionado y asegúrate de que no sea nulo
            Trabajos selectedItem = (Trabajos) vista.cbxCliente.getSelectedItem();
            if(selectedItem.equals("Seleccionar Cliente"))
            {JOptionPane.showMessageDialog(vista, "Debes seleccionar una opcion valida", "Error", JOptionPane.ERROR_MESSAGE); }
            else{
                if (selectedItem != null) {
                    int id = selectedItem.getID_Cliente();
                    modeloTrabajos.setID_Cliente(id);
                    System.out.println(id);
                }
            } 
        }
        });
        
        vista.cbxEstado.addActionListener(e -> {
        // Verifica que la fuente del evento sea el JComboBox
        if (e.getSource() == vista.cbxEstado) {
            // Obtén el elemento seleccionado y asegúrate de que no sea nulo
            Trabajos selectedItem = (Trabajos) vista.cbxEstado.getSelectedItem();
            if(selectedItem.equals("Seleccionar Estado"))
            {JOptionPane.showMessageDialog(vista, "Debes seleccionar una opcion valida", "Error", JOptionPane.ERROR_MESSAGE); }
            else{
                if (selectedItem != null) {
                    int id = selectedItem.getID_Estado();
                    modeloTrabajos.setID_Estado(id);
                    System.out.println(id);
                }
            } 
        }
        });
    }

    public void configurarEventos() {
    // Botón Agregar
    vista.btnAgregar.addActionListener(e -> guardarTrabajo());

    // Botón Eliminar
    vista.btnEliminar.addActionListener(e -> eliminarTrabajo());

    // Botón Actualizar
    vista.btnActualizar1.addActionListener(e -> actualizarTrabajo());

    // Botón Limpiar
    vista.btnLimpiar.addActionListener(e -> limpiarFormulario());

    // Selección de fila en la tabla
    vista.tbTrabajos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            modeloTrabajos.cargarDatosTabla(vista);
        }
    });

    // Botón Inicio
    vista.btnInicio.addActionListener(e -> {
        Vista.frmPrincipalProduccion.initfrmPrincipalProduccion();
        vista.dispose();
    });
    
    vista.btnClientes.addActionListener(e -> {
        Vista.frmClientes.initfrmClientes();
        vista.dispose();
    });
    
    vista.btnNuevoCliente.addActionListener(e -> {
        Vista.frmClientes.initfrmClientes();
        vista.dispose();
    });
    
    vista.btnNuevoVendedor.addActionListener(e -> {
        Vista.frmRegistro.initFrmRegistro();
        vista.dispose();
    });
}

/**
 * Guarda un nuevo trabajo en la base de datos.
 */
private void guardarTrabajo() {
    if (vista.txtFechaInicio.getText().isEmpty() || 
        vista.txtMaquina.getText().isEmpty() || 
        vista.txtCantidad.getText().isEmpty() || 
        vista.txtProducto.getText().isEmpty() || 
        vista.txtFechaFinalizacion.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        modeloTrabajos.setFechaInicio(vista.txtFechaInicio.getText());
        modeloTrabajos.setMaquina(vista.txtMaquina.getText());
        modeloTrabajos.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
        modeloTrabajos.setProducto(vista.txtProducto.getText());
        modeloTrabajos.setFechaFinalizado(vista.txtFechaFinalizacion.getText());

        modeloTrabajos.Guardar();
        modeloTrabajos.Mostrar(vista.tbTrabajos);

        JOptionPane.showMessageDialog(vista, "Trabajo registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/**
 * Elimina el trabajo seleccionado de la base de datos.
 */
private void eliminarTrabajo() {
    int fila = vista.tbTrabajos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(vista, "Seleccione un registro para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int idTrabajo = Integer.parseInt(vista.tbTrabajos.getValueAt(fila, 0).toString());
    modeloTrabajos.Eliminar(idTrabajo);
    modeloTrabajos.Mostrar(vista.tbTrabajos);

    JOptionPane.showMessageDialog(vista, "Trabajo eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
}

/**
 * Actualiza los datos de un trabajo existente.
 */
private void actualizarTrabajo() {
    int fila = vista.tbTrabajos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(vista, "Seleccione un registro para actualizar.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        modeloTrabajos.setID_Trabajo(Integer.parseInt(vista.tbTrabajos.getValueAt(fila, 0).toString()));
        modeloTrabajos.setFechaInicio(vista.txtFechaInicio.getText());
        modeloTrabajos.setMaquina(vista.txtMaquina.getText());
        modeloTrabajos.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
        modeloTrabajos.setProducto(vista.txtProducto.getText());
        modeloTrabajos.setFechaFinalizado(vista.txtFechaFinalizacion.getText());

        modeloTrabajos.Actualizar(vista);
        limpiarFormulario();
        modeloTrabajos.Mostrar(vista.tbTrabajos);

        JOptionPane.showMessageDialog(vista, "Trabajo actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vista, "Ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/**
 * Limpia todos los campos del formulario.
 */
private void limpiarFormulario() {
    vista.txtFechaInicio.setText("");
    vista.txtMaquina.setText("");
    vista.txtCantidad.setText("");
    vista.txtProducto.setText("");
    vista.cbxCliente.setSelectedIndex(0);
    vista.cbxVendedor.setSelectedIndex(0);
    vista.cbxEstado.setSelectedIndex(0);
    vista.txtFechaFinalizacion.setText("");

    JOptionPane.showMessageDialog(vista, "Formulario limpiado.", "Información", JOptionPane.INFORMATION_MESSAGE);
}
}
