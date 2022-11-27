package generarDatos;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import paths.DatConnection;

public class Contabilidad {

	String matricula;
	double salario;
	double gastos;

	public Contabilidad() {
	};

	public Contabilidad(String matricula, double salario, double gastos) {
		this.matricula = matricula;
		this.salario = salario;
		this.gastos = gastos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

//	public void mostrarContabilidad(ArrayList<Contabilidad> Contabilidad) {
//		// Mostrar empleados por consola
//		for (Contabilidad empleado : Contabilidad) {
//			System.out.println(empleado.toString());
//		}
//	}

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
		return contabilidad;
	}

	@Override
	public String toString() {
		return "Contabilidad [matricula=" + matricula + ", salario=" + salario + ", gastos=" + gastos + "]";
	}

}
