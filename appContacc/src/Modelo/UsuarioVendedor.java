package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;


public class UsuarioVendedor {
    
    private int ID_UsuarioVendedor;
    private String Nombre_Ven;
    private String Correo_Ven;
    private String Contrasena;

    public void setID_UsuarioVendedor(int ID_UsuarioVendedor) {
        this.ID_UsuarioVendedor = ID_UsuarioVendedor;
    }

    public void setNombre_Ven(String Nombre_Ven) {
        this.Nombre_Ven = Nombre_Ven;
    }

    public void setCorreo_Ven(String Correo_Ven) {
        this.Correo_Ven = Correo_Ven;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getID_UsuarioVendedor() {
        return ID_UsuarioVendedor;
    }

    public String getNombre_Ven() {
        return Nombre_Ven;
    }

    public String getCorreo_Ven() {
        return Correo_Ven;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    //3-Metodos
       public void GuardarUsuario() {
    Connection conexion = ClaseConexion.getConexion();
    try {
        PreparedStatement addUser = conexion.prepareStatement(
            "INSERT INTO UsuarioVendedor(ID_UsuarioVendedor, Nombre_Ven, Correo_Ven, Contrasena) " +
            "VALUES (SEQ_USUARIO_VENDEDOR.NEXTVAL, ?, ?, ?)"
        );
        // Establecer valores restantes de la consulta SQL
        addUser.setString(1, getNombre_Ven());
        addUser.setString(2, getCorreo_Ven());
        addUser.setString(3, getContrasena());
        // Ejecutar la consulta
        addUser.executeUpdate();
        System.out.println("Usuario guardado exitosamente.");

    } catch (SQLException ex) {
        System.out.println("Error en el modelo: método guardar " + ex);
    }
}
       
         //El método devuelve un valor booleano (verdadero o falso)
       //Verdadero si existe el usuario y Falso si no existe
       public boolean iniciarSesion() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM UsuarioVendedor WHERE Correo_Ven = ? AND Contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_Ven());
            statement.setString(2, getContrasena());

            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
       
       public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
}
         public UsuarioVendedor() {
    }
    

    public UsuarioVendedor(int ID_UsuarioVendedor, String Nombre_Ven) {
        this.ID_UsuarioVendedor = ID_UsuarioVendedor;
        this.Nombre_Ven = Nombre_Ven;
        
    }
    @Override
    public String toString(){
        return Nombre_Ven ; // Muestra el nombre del estado en el ComboBox
    }
    
      // Método para cargar los valores en el ComboBox
    public void cargarComboCliente(JComboBox<UsuarioVendedor> comboBox) {
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems(); // Limpia el ComboBox antes de cargar los datos
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente"); // Consulta SQL
            while (rs.next()) {
                int IDVen = rs.getInt("ID_UsuarioVendedor");
                String NombreVendedor = rs.getString("Nombre_Ven");
                comboBox.addItem(new UsuarioVendedor(IDVen, NombreVendedor)); // Añade elementos al ComboBox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      
}
