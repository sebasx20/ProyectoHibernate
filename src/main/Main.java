package main;

import hibernateMysql.Consulta;
import obtenerDatos.*;

public class Main {
	public static void main(String[] args) {
		RhhVentas ventas = new RhhVentas();
		ventas.generarRhhventas();
//		System.out.println("***********************************************************");
//		DatContabilidad dat = new DatContabilidad();
//		dat.generarContabilidad();
		
		Consulta con = new Consulta();
//		System.out.println(con.insertarDatos());
		
		
		
//		LlenarListaEmpleado un = new LlenarListaEmpleado();
//		un.general();
	}
}
