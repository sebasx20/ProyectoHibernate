package template;

import java.sql.Date;
import java.util.ArrayList;

public class Empleado {
	
	String matricula;
	String apenom; 
	String departamento;
	Date semana;
	double ventas;
	
	// 
	public Empleado() {}

	public Empleado(String matricula, String apenom, String departamento,
			double ventas, Date semana) {
		this.matricula = matricula;
		this.apenom = apenom;
		this.departamento = departamento;
		this.ventas = ventas;
		this.semana = semana;
	}
	
	// Getters y Setters
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getApenom() {
		return apenom;
	}
	public void setApenom(String apenom) {
		this.apenom = apenom;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Date getSemana() {
		return semana;
	}
	public void setSemana(Date semana) {
		this.semana = semana;
	}
	public double getVentas() {
		return ventas;
	}
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	
	// Iterar sobre los empleados
	public void mostrarEmpleados(ArrayList<Empleado> Empleados) {
		// Mostrar empleados por consola
		for (Empleado empleado : Empleados) {
			System.out.println(empleado.toString());
		}
	}
	
	@Override
	public String toString() {
		return "Empleado [matricula=" + matricula + ", apenom=" + apenom + ", departamento=" + departamento
				+ ", semana=" + semana + ", ventas=" + ventas + "]";
	}


	
}