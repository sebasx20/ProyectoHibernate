package obtenerDatos;

import java.util.*;

import reverse.ListaempleadosId;
import template.Contabilidad;
import template.Empleado;

public class LlenarListaEmpleado {

	RhhVentas v = new RhhVentas();
	DatContabilidad c = new DatContabilidad();
	Empleado e = new Empleado();
	ListaempleadosId le = new ListaempleadosId();

	ArrayList<Empleado> empleado = v.generarRhhventas();
	ArrayList<Contabilidad> contabilidad = c.generarContabilidad();
	ArrayList<ListaempleadosId> liEmp = new ArrayList<>();
	
	private double suma;
	private double antes;
	private int indice = 0;
	
	public ArrayList<ListaempleadosId> general() {
		rellenar();
		totalVentas();
		totalGastos();
//		for(ListaempleadosId l:liEmp) {
//			System.out.println(l.getMatricula());
//		}
		return liEmp;
	}

	public void totalGastos() {
		// Calcula el total de gatos
		for (Contabilidad cont : contabilidad) {
			suma = cont.getSalario() + cont.getGastos();
			if (existe(cont.getMatricula())) {
				indice = getIndex(cont.getMatricula());
				liEmp.get(indice).setTotgastos((Math.round(suma * 100.0) / 100.0));
			}
		}
	}

	public void totalVentas() {
		// Calcula el total de Ventas
		for (Empleado emp : empleado) {
			antes = 0;
			for (Empleado list : empleado) {
				suma = list.getVentas();
				if (emp.getMatricula().equalsIgnoreCase(list.getMatricula())) {
					antes = suma + antes;
					if (existe(emp.getMatricula())) {
						indice = getIndex(emp.getMatricula());
						liEmp.get(indice).setTotventas(Math.round(antes * 100.0) / 100.0);
					}
				}
			}
		}
	}
	
	public void rellenar() {
		// Agrega el elemento al Array
		for (Empleado em : empleado) {
			if (existe(em.getMatricula())) {
				continue;
			} else {
				liEmp.add(new ListaempleadosId(em.getApenom(),em.getDepartamento(),em.getSemana(),em.getMatricula(),0.0,0.0));
			}

		}
	}
	
	public boolean existe(String e) {
		// Comprueba si el elemento existe en la lista
		for (ListaempleadosId liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return true;
			}
		}
		return false;

	}
	
	public int getIndex(String e) {
		// Obtiene el indice del elemento en la lista
		for (ListaempleadosId liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return liEmp.indexOf(liemp);
			}
		}
		return 0;
	}
}
