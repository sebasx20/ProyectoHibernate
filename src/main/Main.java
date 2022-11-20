package main;

public class Main {
	public static void main(String[] args) {
		Rhhventas ventas = new Rhhventas();
		ventas.generarRhhventas();
//		System.out.println("***********************************************************");
//		DatContabilidad con = new DatContabilidad();
//		con.generarContabilidad();
		
		LlenarListaEmpleado un = new LlenarListaEmpleado();
		un.general();
	}
}
