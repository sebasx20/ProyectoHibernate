package obtenerDatos;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import paths.DatConnection;
import template.Contabilidad;

public class DatContabilidad {
	
	public ArrayList<Contabilidad> generarContabilidad() {
		DatConnection datC = new DatConnection(); 
		ArrayList<Contabilidad> contabilidad = new ArrayList<>();
		String PATH = datC.getDatFile();
		
		try (DataInputStream dat = new DataInputStream(new FileInputStream(PATH))) {
			while (true) {
				contabilidad.add(new Contabilidad(dat.readUTF(), dat.readDouble(), dat.readDouble()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Mostrar los datos por Consola
//		Contabilidad con = new Contabilidad();
//		con.mostrarContabilidad(contabilidad);

		return contabilidad;
	}
}
