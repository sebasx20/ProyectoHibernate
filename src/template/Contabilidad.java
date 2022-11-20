package template;
import java.util.ArrayList;

public class Contabilidad {
	
	String matricula;
	double salario;
	double gastos;
	
	public Contabilidad() {};
	
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
	
	public void mostrarContabilidad(ArrayList<Contabilidad> Contabilidad) {
		// Mostrar empleados por consola
		for (Contabilidad empleado : Contabilidad) {
			System.out.println(empleado.toString());
		}
	}

	@Override
	public String toString() {
		return "Contabilidad [matricula=" + matricula + ", salario=" + salario + ", gastos=" + gastos + "]";
	}
	
	
}
