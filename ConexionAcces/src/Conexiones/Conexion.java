package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.lang.SystemUtils;

public class Conexion {
	
	private Connection conexion;
	private Statement estatement;
	private final String nombre_bd;
	private final String usuario_bd;
	private final String password_bd;
	
	private final String controlador;
	 
    public Conexion() {
		// TODO Auto-generated constructor stub
    	this.controlador="sun.jdbc.odbc.JdbcOdbcDriver";
    	 
        this.nombre_bd="C:\\Users\\Gabriel\\Documents\\Database1.accdb";
 
        this.usuario_bd="";
 
        this.password_bd="";
    	
	}
 
	
		
	public boolean EstablecerConexion() throws SQLException{
		 
        try{
 
            conexion=DriverManager.getConnection("jdbc:ucanaccess://"+this.nombre_bd,this.usuario_bd,this.password_bd);
 
        }catch (SQLException e){
 
             JOptionPane.showMessageDialog(null,"Error al realizar la conexion "+e);
 
             return false;
 
        }
 
        
 
        try {
 
            this.estatement=this.conexion.createStatement(
 
            ResultSet.TYPE_SCROLL_INSENSITIVE,
 
                    ResultSet.CONCUR_READ_ONLY);
 
        }
 
        catch (SQLException e) {
 
            JOptionPane.showMessageDialog(null,"Error al crear el objeto sentencia "+e);
 
            return false;
 
        }
 
        
 
        return true;
 
        
 
    }
	
	public String ConsultarUsuarios(String sql) throws SQLException {
		ResultSet rs;
		String resultado="";
		rs=this.estatement.executeQuery(sql);
		
		while(rs.next()) {
			resultado+=rs.getString(0);
		}
		return resultado;
	}
	
	public boolean insertarRegistros(String sql)  {
		try {
			this.estatement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String ConsultarRegistros() {
		try {
			String datos="";
			String sql="select Cedula, Nombres, Apellidos, Telefono, Direccion from Usuarios";
			
			ResultSet rs = this.estatement.executeQuery(sql);
			int cont=0;
			
			while(rs.next()) {
				
				datos+=rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+"\r\n";
				
			}
			return datos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "naranjas";
		}
		
	}

}
