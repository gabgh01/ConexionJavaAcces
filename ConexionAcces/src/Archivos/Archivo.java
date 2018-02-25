package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
	
	public String leerArchivo() {
		String resultado="Insert into Usuarios (Cedula, Nombres, Apellidos, Telefono, Direccion) values ";
		
		try {
			Scanner scaner = new Scanner( new File("./Usuarios.txt"));
			String[] campos;  
					 while(scaner.hasNextLine()) {
						 campos = formato(scaner.nextLine());
						 resultado+="('"+campos[0]+"','"+campos[1]+"','"+campos[2]+"','"+campos[3]+"','"+campos[4]+"')";
						 if(scaner.hasNextLine()) {
							 resultado+=",\n";
						 }
					 } 
					
					
					return resultado;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "naranjas";
		}
		}
	
	public String[] formato(String linea) {
		String[] campos = linea.split("\\|");
		return campos;
	}
	
	public boolean GuardarConsulta(String contenido) throws IOException {
		String ruta = "./datos.txt";
        File archivo = new File(ruta);
        BufferedWriter bw = null;
		try {
			
	       
	            bw = new BufferedWriter(new FileWriter(archivo));
	            bw.write(contenido);
	        
	        
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}finally {
			 bw.close();
		}
		
       
    
	}
	

}
