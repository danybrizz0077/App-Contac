
package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioProduccion {
    
    private int ID_UsuarioProduccion;
    private String Nombre_pro;
    private String Correo_pro;
    private String Contrasena;

    public void setID_UsuarioProduccion(int ID_UsuarioProduccion) {
        this.ID_UsuarioProduccion = ID_UsuarioProduccion;
    }

    public void setNombre_pro(String Nombre_pro) {
        this.Nombre_pro = Nombre_pro;
    }

    public void setCorreo_pro(String Correo_pro) {
        this.Correo_pro = Correo_pro;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getID_UsuarioProduccion() {
        return ID_UsuarioProduccion;
    }

    public String getNombre_pro() {
        return Nombre_pro;
    }

    public String getCorreo_pro() {
        return Correo_pro;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    //3-Metodos
     public void GuardarUsuarioProduccion() {
    Connection conexion = ClaseConexion.getConexion();
    try {
        PreparedStatement addUser = conexion.prepareStatement(
            "INSERT INTO UsuarioProduccion(ID_UsuarioProduccion, Nombre_pro, Correo_pro, Contrasena) " +
            "VALUES (seq_usuario_produccion.NEXTVAL, ?, ?, ?)"
        );
        addUser.setString(1, getNombre_pro());
        addUser.setString(2, getCorreo_pro());
        addUser.setString(3, getContrasena());
        
        addUser.executeUpdate();
        System.out.println("UsuarioProduccion guardado exitosamente.");
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
            String sql = "SELECT * FROM UsuarioProduccion WHERE Correo_pro = ? AND Contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_pro());
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
    
    
}


