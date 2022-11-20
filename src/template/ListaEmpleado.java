package template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListaEmpleado {
	String matricula;
	String departamento;
	double tVentasMes;
	double tGastosMes;
	
	public ListaEmpleado() {};
	
	public ListaEmpleado(String matricula, String departamento) {
		this.matricula = matricula;
		this.departamento = departamento;
	};
	
	public ListaEmpleado(String matricula, String departamento, double tVentasMes, double tGastosMes) {
		this.matricula = matricula;
		this.departamento = departamento;
		this.tGastosMes = tVentasMes;
		this.tGastosMes = tGastosMes;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double gettVentasMes() {
		return tVentasMes;
	}

	public void settVentasMes(double tVentasMes) {
		this.tVentasMes = tVentasMes;
	}

	public double gettGastosMes() {
		return tGastosMes;
	}

	public void settGastosMes(double tGastosMes) {
		this.tGastosMes = tGastosMes;
	}
	
//	public void llenar(ArrayList<Empleado> emp,HashSet<ListaEmpleado> lista) {
//		for(Empleado c : emp) {
//			if(c.getMatricula().equals(c))
//			lista.add(new ListaEmpleado(c.getMatricula(),c.getDepartamento()));
//		}
//	}
	public void mostrarLista(ArrayList<ListaEmpleado> liEmp) {
		// Mostrar empleados por consola
		for (ListaEmpleado li : liEmp) {
			System.out.println(li.toString());
		}
	}

	@Override
	public String toString() {
		return "ListaEmpleado [matricula=" + matricula + ", departamento=" + departamento + ", tVentasMes=" + tVentasMes
				+ ", tGastosMes=" + tGastosMes + "]";
	}
	
	
}
