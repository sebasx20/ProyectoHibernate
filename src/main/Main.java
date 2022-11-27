package main;

import java.util.Scanner;

import hibernateMysql.Consulta;

public class Main {
	public static void main(String[] args) {
		Consulta con = new Consulta();
		int opc = 0;
		String buscar = "";
		
		while (opc != 3) {
			opc = menu();
			System.out.println("opción elegida = " + opc);
			switch (opc) {
				case 1: {
					System.out.println(con.insertarDatos());
					break;
				}
				case 2: {
					System.out.println("\nIngresa la matricula: ");
					Scanner ma = new Scanner(System.in);
					buscar = ma.nextLine();
					
					con.mostrarDatos(buscar);
					break;
				}
			}
		}
		System.out.println("Aplicación terminada.");

	}

	public static int menu() {
		int sel = 0;
		boolean opc_ok = false;

		Scanner teclado = new Scanner(System.in);

		while (!opc_ok) {

			System.out.println("\nElige opción:");
			System.out.println("----------------------");
			System.out.println("1.	Insertar Datos" + "\n2.	Generar Listado" + "\n3.	Salir" + "\n>>>? ");
			sel = teclado.nextInt();
			if (sel != 0 && sel >= 1 && sel <= 3)
				opc_ok = true;
		}
		System.out.println();
		return sel;
	}
}
