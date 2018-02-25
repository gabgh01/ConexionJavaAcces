package Run;

import Archivos.Archivo;
import Conexiones.Conexion;

public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		Archivo Archi = new Archivo();
		try {
			System.out.println(conexion.EstablecerConexion());
			//System.out.println(Archi.leerArchivo());
			//System.out.println(conexion.insertarRegistros(Archi.leerArchivo()));
			//System.out.println(conexion.ConsultarRegistros());
			System.out.println(conexion.ConsultarRegistros());
			Archi.GuardarConsulta(conexion.ConsultarRegistros());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//conexion.EstablecerConexion();
	}

}
