package Modelo;


import Vista.frmTrabajo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Trabajos {

    private int ID_Trabajo;
    private String maquina;
    private int cantidad;
    private String producto;
    private int ID_Cliente;
    private int ID_UsuarioVendedor;
    private int ID_Estado;
    private String fechaInicio;
    private String fechaFinalizado;
    private String NombreCliente;
    private String NombreVendedor;
    private String Estado;

    public int getID_Trabajo() {
        return ID_Trabajo;
    }

    public void setID_Trabajo(int ID_Trabajo) {
        this.ID_Trabajo = ID_Trabajo;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_UsuarioVendedor() {
        return ID_UsuarioVendedor;
    }

    public void setID_UsuarioVendedor(int ID_UsuarioVendedor) {
        this.ID_UsuarioVendedor = ID_UsuarioVendedor;
    }

    public int getID_Estado() {
        return ID_Estado;
    }

    public void setID_Estado(int ID_Estado) {
        this.ID_Estado = ID_Estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizado() {
        return fechaFinalizado;
    }

    public void setFechaFinalizado(String fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getNombreVendedor() {
        return NombreVendedor;
    }

    public void setNombreVendedor(String NombreVendedor) {
        this.NombreVendedor = NombreVendedor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

   

    @Override
    public String toString() {
        if (NombreCliente != null) {
            return NombreCliente; // Mostrar el nombre del cliente si está definido
        } else if (NombreVendedor != null) {
            return NombreVendedor; // Mostrar el nombre del vendedor si está definido
        } else if (Estado != null) {
            return Estado; // Mostrar el estado si está definido
        }
        return "Sin información"; // Por defecto si no hay datos disponibles
    }
    
    // Métodos CRUD
    public void Guardar() {
                try {
                    String sql = "INSERT INTO Trabajos (ID_Trabajos, FechaInicio, Maquina, Cantidad, Producto, ID_Cliente, ID_UsuarioVendedor, ID_Estado, FechaFinalizado) " +
                     "VALUES (seq_trabajo.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection conexion = ClaseConexion.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, getFechaInicio());
            pstmt.setString(2, getMaquina());
            pstmt.setInt(3, getCantidad());
            pstmt.setString(4, getProducto());
            pstmt.setInt(5, getID_Cliente());
            pstmt.setInt(6, getID_UsuarioVendedor());
            pstmt.setInt(7, getID_Estado());
            pstmt.setString(8, getFechaFinalizado());
            System.out.println("esta es la fecha de inicio" + getFechaInicio() + getMaquina() + getCantidad() + getProducto() + getID_Cliente() + getID_UsuarioVendedor() + getID_Estado() + getFechaFinalizado());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Trabajo guardado exitosamente."+ fechaInicio);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar trabajo: " + ex.getMessage());
            ex.printStackTrace();
                    System.out.println(ex);
        }
    }

    public void Mostrar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID_Trabajo", "Fecha Inicio", "Maquina", "Cantidad", "Producto","ID_Cliente", "ID_Vendedor", "ID_Estado", "Cliente", "Vendedor", "Estado", "Fecha Finalizado"});

        String query = "SELECT t.ID_Trabajos, t.FechaInicio, t.Maquina, t.Cantidad, t.Producto, t.ID_cliente, t.ID_UsuarioVendedor, t.ID_Estado, " +
                     "c.Nombre_Clie AS Cliente, uv.Nombre_Ven AS Vendedor, et.Estado AS Estado, t.FechaFinalizado " +
                     "FROM Trabajos t " +
                     "INNER JOIN Cliente c ON t.ID_Cliente = c.ID_Cliente " +
                     "INNER JOIN UsuarioVendedor uv ON t.ID_UsuarioVendedor = uv.ID_UsuarioVendedor " +
                     "INNER JOIN EstadoTrabajo et ON t.ID_Estado = et.ID_Estado";
        try (Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("ID_Trabajos"),
                    rs.getString("FechaInicio"),
                    rs.getString("Maquina"),
                    rs.getInt("Cantidad"),
                    rs.getString("Producto"),
                    rs.getInt("ID_Cliente"),
                    rs.getInt("ID_UsuarioVendedor"),
                    rs.getInt("ID_Estado"),
                    rs.getString("Cliente"),
                    rs.getString("Vendedor"),
                    rs.getString("Estado"),
                    rs.getString("FechaFinalizado")
                });
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setWidth(0);
            tabla.getColumnModel().getColumn(7).setMinWidth(0);
            tabla.getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setWidth(0);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar trabajos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Trabajos(){
        
    }
    
    public Trabajos(int id, String cliente){
        this.ID_Cliente = id;
        this.NombreCliente = cliente;
    }
    
    public Trabajos(String vendedor, int id){
        this.NombreVendedor = vendedor;
        this.ID_UsuarioVendedor = id;
    }
    
    public  Trabajos(int id, String estado, boolean esEstado){
        if(esEstado){
            this.ID_Estado = id;
            this.Estado = estado;
        }
    }
    
    public void CargarComboClientes(String tabla, String valor, JComboBox<Trabajos> c){
        Connection conexion = ClaseConexion.getConexion();
        ArrayList<Trabajos> listaClientes = new ArrayList<>();
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from " + tabla);
            
            listaClientes.add(new Trabajos(0, "Seleccionar Cliente"));
            while(rs.next()){
                int id = rs.getInt(1);
                String cliente = rs.getString(2);
                
                listaClientes.add(new Trabajos(id, cliente));
                DefaultComboBoxModel<Trabajos> combo = new DefaultComboBoxModel<>(listaClientes.toArray(new Trabajos[0]));
                c.setModel(combo);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    
    }
    
    public void CargarComboVendedor(String tabla, String valor, JComboBox<Trabajos> c){
        Connection conexion = ClaseConexion.getConexion();
        ArrayList<Trabajos> listaClientes = new ArrayList<>();
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from " + tabla);
            
            listaClientes.add(new Trabajos("Seleccionar Vendedor", 0));
            while(rs.next()){
                int id = rs.getInt(1);
                String vendedor = rs.getString(2);
                
                listaClientes.add(new Trabajos(vendedor, id));
                DefaultComboBoxModel<Trabajos> combo = new DefaultComboBoxModel<>(listaClientes.toArray(new Trabajos[0]));
                c.setModel(combo);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    
    }
    
    public void CargarComboEstado(String tabla, String valor, JComboBox<Trabajos> c){
        Connection conexion = ClaseConexion.getConexion();
        ArrayList<Trabajos> listaClientes = new ArrayList<>();
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from " + tabla);
            
            listaClientes.add(new Trabajos(0, "Seleccionar Estado", true));
            while(rs.next()){
                int id = rs.getInt(1);
                String estado = rs.getString(2);
                
                listaClientes.add(new Trabajos(id, estado, true));
                DefaultComboBoxModel<Trabajos> combo = new DefaultComboBoxModel<>(listaClientes.toArray(new Trabajos[0]));
                c.setModel(combo);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    
    }
    
    public void MostrarTabajos(JTable tabla){
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID Trabajo", "Fecha de Inicio", "Maquina", "Cantidad", "Producto", "Cliente","Usuario", " Estado","Fecha Finalizado"});
        
        try
        {
            String query = "select * from trabajos" ;
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{
                    rs.getInt(1), //ID
                    rs.getString(2), //Marca
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getString(9)
                    }
                );
                
            }
            
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            
        }
        
    }
    
//        public void MostrarClientes(JTable tabla) {
//            Connection conexion = ClaseConexion.getConexion();
//            DefaultTableModel modelo = new DefaultTableModel();
//            modelo.setColumnIdentifiers(new Object[]{"ID_Cliente", "Fecha Inicio", "Maquina", "Cantidad", "Producto", "Cliente", "Vendedor", "Estado", "Fecha Finalizado"});
//
//            String query = "SELECT * FROM Trabajos";
//            try (Statement statement = conexion.createStatement();
//                 ResultSet rs = statement.executeQuery(query)) {
//
//                while (rs.next()) {
//                    modelo.addRow(new Object[]{
//                        rs.getInt("ID_Trabajos"),
//                        rs.getDate("FechaInicio"),
//                        rs.getString("Maquina"),
//                        rs.getInt("Cantidad"),
//                        rs.getString("Producto"),
//                        rs.getInt("ID_Cliente"),
//                        rs.getInt("ID_UsuarioVendedor"),
//                        rs.getInt("ID_Estado"),
//                        rs.getDate("FechaFinalizado")
//                    });
//                }
//                tabla.setModel(modelo);
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error al mostrar trabajos: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }

    public void Eliminar(int idTrabajo) {
        String sql = "DELETE FROM Trabajos WHERE ID_Trabajos = ?";
        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idTrabajo);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Trabajo eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar trabajo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Actualizar(frmTrabajo vista) {
        
        String sql = "UPDATE Trabajos SET FechaInicio = ?, Maquina = ?, Cantidad = ?, Producto = ?, ID_Cliente = ?, ID_UsuarioVendedor = ?, ID_Estado = ?, FechaFinalizado = ? WHERE ID_Trabajos = ?";
        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            System.out.println("idTrabajo"+vista.IdTrabajo.getText());
            pstmt.setString(1, vista.txtFechaInicio.getText());
            pstmt.setString(2, vista.txtMaquina.getText());
            pstmt.setInt(3,Integer.parseInt(vista.txtCantidad.getText()));
            pstmt.setString(4, vista.txtProducto.getText());
            pstmt.setInt(5,(int)getID_Cliente());
            pstmt.setInt(6,(int)getID_UsuarioVendedor());
            pstmt.setInt(7,(int)getID_Estado());
            pstmt.setString(8,vista.txtFechaFinalizacion.getText());
            pstmt.setInt(9,Integer.parseInt(vista.IdTrabajo.getText()));
            pstmt.executeUpdate();
                        System.out.println("esta es el" + getFechaInicio() + getMaquina() + getCantidad() + getProducto() + getID_Cliente() + getID_UsuarioVendedor() + getID_Estado() + getFechaFinalizado());

            //JOptionPane.showMessageDialog(null, "Trabajo actualizado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar trabajo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void cargarDatosTabla(frmTrabajo vista) {
    int filaSeleccionada = vista.tbTrabajos.getSelectedRow(); // Selecciona la fila en la tabla
    if (filaSeleccionada != -1) { // Verifica si se seleccionó una fila
        // Carga los datos en los campos correspondientes
        vista.IdTrabajo.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 0).toString());
        vista.txtFechaInicio.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 1).toString());
        vista.txtMaquina.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 2).toString());
        vista.txtCantidad.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 3).toString());
        vista.txtProducto.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 4).toString());
        vista.txtFechaFinalizacion.setText(vista.tbTrabajos.getValueAt(filaSeleccionada, 11).toString());
        
        int idCliente = (int) vista.tbTrabajos.getValueAt(filaSeleccionada, 5);
        int idVendedor = (int) vista.tbTrabajos.getValueAt(filaSeleccionada, 6);
        int idEstado = (int) vista.tbTrabajos.getValueAt(filaSeleccionada, 7);
        
        for (int i = 0; i < vista.cbxCliente.getItemCount(); i++) {
                Trabajos item = (Trabajos) vista.cbxCliente.getItemAt(i);
                if (item.getID_Cliente()== idCliente) {
                    vista.cbxCliente.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < vista.cbxVendedor.getItemCount(); i++) {
                Trabajos item = (Trabajos) vista.cbxVendedor.getItemAt(i);
                if (item.getID_UsuarioVendedor()== idVendedor) {
                    vista.cbxVendedor.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < vista.cbxEstado.getItemCount(); i++) {
                Trabajos item = (Trabajos) vista.cbxEstado.getItemAt(i);
                if (item.getID_Estado()== idEstado) {
                    vista.cbxEstado.setSelectedIndex(i);
                    break;
                }
            }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro.");
    }
}

}