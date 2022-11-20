package main;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import template.Contabilidad;

public class DatContabilidad {
	
		ArrayList<Contabilidad> generarContabilidad() {
				
		ArrayList<Contabilidad> contabilidad = new ArrayList<>();
		
		String PATH = "C:\\Users\\aseba\\Documents\\Eva1Proyect\\proyect_files\\01102022.dat";
		try (DataInputStream dat = new DataInputStream(new FileInputStream(PATH))) {
			while(true) {
				contabilidad.add(
						new Contabilidad(
								dat.readUTF(),
								dat.readDouble(),
								dat.readDouble()
								)
						);
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
