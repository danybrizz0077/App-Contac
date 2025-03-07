package Modelo;

import Vista.frmClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cliente {
    private int ID_Cliente;
    private String Nombre_Clie;

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public void setNombre_Clie(String Nombre_Clie) {
        this.Nombre_Clie = Nombre_Clie;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public String getNombre_Clie() {
        return Nombre_Clie;
    }

    ////////////////////////3- Métodos
    public void Guardar() {
        String sql = "INSERT INTO Cliente(ID_Cliente, Nombre_Clie) VALUES (seq_cliente.NEXTVAL, ?)";
        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, getNombre_Clie());
            pstmt.executeUpdate();
            System.out.println("Cliente guardado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método guardar " + ex.getMessage());
            ex.printStackTrace(); // Imprime el detalle completo de la excepción
        }
    }

    public void Mostrar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID_Cliente", "Nombre del Cliente"});

        String query = "SELECT ID_Cliente, Nombre_Clie FROM Cliente";
        try (Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("ID_Cliente"),
                    rs.getString("Nombre_Clie")
                });
            }
            tabla.setModel(modelo);
            ocultarColumnaID(tabla);

        } catch (SQLException e) {
            System.out.println("Error en el modelo: método mostrar " + e.getMessage());
            e.printStackTrace(); // Imprime el detalle completo de la excepción
        }
    }

    private void ocultarColumnaID(JTable tabla) {
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
    }

    public void Eliminar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();

        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila para eliminar.");
            return;
        }

        try {
            int idCliente = Integer.parseInt(tabla.getModel().getValueAt(filaSeleccionada, 0).toString());
            String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
            PreparedStatement deleteCliente = conexion.prepareStatement(sql);
            deleteCliente.setInt(1, idCliente);
            int filasAfectadas = deleteCliente.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro.");
            }
        } catch (SQLException e) {
            System.out.println("Error en el método eliminar: " + e.getMessage());
            e.printStackTrace(); // Imprime el detalle completo de la excepción
        } catch (NumberFormatException ex) {
            System.out.println("Error al obtener el ID: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del cliente.");
        }
    }

 public void Actualizar(JTable tabla, String nuevoNombre) {
    Connection conexion = null; // Cambia a Connection
    try {
        conexion = ClaseConexion.getConexion(); // Asegúrate de que esto devuelva un Connection

        // Verificar si la conexión es válida
        if (conexion == null || conexion.isClosed()) {
            System.out.println("Error: La conexión es nula o está cerrada.");
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.");
            return;
        }

        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCliente = Integer.parseInt(tabla.getModel().getValueAt(filaSeleccionada, 0).toString());
            System.out.println("ID del Cliente: " + idCliente); // Debugging

            // Usar el nuevo nombre proporcionado como argumento
            System.out.println("Nuevo Nombre del Cliente: " + nuevoNombre); // Debugging

            if (nuevoNombre == null || nuevoNombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                return;
            }

            String sql = "UPDATE Cliente SET Nombre_Clie = ? WHERE ID_Cliente = ?";
            System.out.println("Ejecutando SQL: " + sql); // Debugging
            PreparedStatement updateCliente = conexion.prepareStatement(sql);
            updateCliente.setString(1, nuevoNombre);
            updateCliente.setInt(2, idCliente);
            int filasAfectadas = updateCliente.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas); // Debugging

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro. Verifique el ID.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila para actualizar.");
        }
    } catch (SQLException e) {
        System.out.println("Error en el método de actualizar: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar el registro.");
    } catch (NumberFormatException ex) {
        System.out.println("Error al obtener el ID del cliente: " + ex.getMessage());
        JOptionPane.showMessageDialog(null, "Error al obtener el ID del cliente.");
    } finally {
        // Cerrar la conexión si se abrió
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}






    public void limpiar(frmClientes vista) {
        vista.txtNombreCliente.setText("");
    }

    public void cargarDatosTabla(frmClientes vista) {
        int filaSeleccionada = vista.tbCliente.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreCliente = vista.tbCliente.getValueAt(filaSeleccionada, 1).toString();
            vista.txtNombreCliente.setText(nombreCliente);
        }
    }
    
     // Constructor vacío
    public Cliente() {
    }
    

    public Cliente(int ID_Cliente, String Nombre_Clie) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre_Clie = Nombre_Clie;
        
    }
    @Override
    public String toString(){
        return Nombre_Clie ; // Muestra el nombre del estado en el ComboBox
    }
    
      // Método para cargar los valores en el ComboBox
    public void cargarComboCliente(JComboBox<Cliente> comboBox) {
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems(); // Limpia el ComboBox antes de cargar los datos
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente"); // Consulta SQL
            while (rs.next()) {
                int IDCliente = rs.getInt("ID_Cliente");
                String NombreClie = rs.getString("Nombre_Clie");
                comboBox.addItem(new Cliente(IDCliente, NombreClie)); // Añade elementos al ComboBox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}