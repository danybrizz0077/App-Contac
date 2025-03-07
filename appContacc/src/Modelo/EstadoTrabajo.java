package modelo;

import Modelo.ClaseConexion;
import java.sql.*;
import javax.swing.JComboBox;

public class EstadoTrabajo {
    
    // Variables actualizadas
    private int ID_Estado;
    private String Estado;

    // Getters y Setters
    public int getID_Estado() {
        return ID_Estado;
    }

    public void setID_Estado(int ID_Estado) {
        this.ID_Estado = ID_Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    // Constructor vacío
    public EstadoTrabajo() {
    }

    // Constructor con parámetros
    public EstadoTrabajo(int ID_Estado, String Estado) {
        this.ID_Estado = ID_Estado;
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return Estado; // Muestra el nombre del estado en el ComboBox
    }

    // Método para cargar los valores en el ComboBox
    public void cargarComboEstados(JComboBox<EstadoTrabajo> comboBox) {
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems(); // Limpia el ComboBox antes de cargar los datos
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM EstadoTrabajo"); // Consulta SQL
            while (rs.next()) {
                int idEstado = rs.getInt("ID_Estado");
                String nombreEstado = rs.getString("Estado");
                comboBox.addItem(new EstadoTrabajo(idEstado, nombreEstado)); // Añade elementos al ComboBox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
