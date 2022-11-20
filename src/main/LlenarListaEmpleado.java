package main;

import java.util.*;

import template.Contabilidad;
import template.Empleado;
import template.ListaEmpleado;

public class LlenarListaEmpleado {

	Rhhventas v = new Rhhventas();
	DatContabilidad c = new DatContabilidad();
	Empleado e = new Empleado();
	ListaEmpleado le = new ListaEmpleado();

	ArrayList<Empleado> empleado = v.generarRhhventas();
	ArrayList<Contabilidad> contabilidad = c.generarContabilidad();
	ArrayList<ListaEmpleado> liEmp = new ArrayList<>();
	private double suma;
	private double antes;
	private int indice = 0;
	
	public void general() {
		rellenar();
		totalVentas();
		totalGastos();
		le.mostrarLista(liEmp);
	}

	public void totalGastos() {

		for (Contabilidad cont : contabilidad) {
			suma = cont.getSalario() + cont.getGastos();
			if (existe(cont.getMatricula())) {
				indice = getIndex(cont.getMatricula());
				liEmp.get(indice).settGastosMes((Math.round(suma * 100.0) / 100.0));

			}
		}
	}

	public void totalVentas() {
		for (Empleado emp : empleado) {
			antes = 0;
			for (Empleado list : empleado) {
				suma = list.getVentas();
				if (emp.getMatricula().equalsIgnoreCase(list.getMatricula())) {
					antes = suma + antes;
					if (existe(emp.getMatricula())) {

						indice = getIndex(emp.getMatricula());
						liEmp.get(indice).settVentasMes(Math.round(antes * 100.0) / 100.0);

						// Opcion b
//						liEmp.get(liEmp.size()-1).settVentasMes(Math.round(antes * 100.0) / 100.0);
//						System.out.println(liEmp.get(indice));
					}
				}
			}
		}
	}
	
	public void rellenar() {
		for (Empleado em : empleado) {
			
			if (existe(em.getMatricula())) {
				continue;
			} else {
				liEmp.add(new ListaEmpleado(em.getMatricula(), em.getDepartamento(), 0, 0));
			}

		}
	}

	public boolean existe(String e) {
		for (ListaEmpleado liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return true;
			}
		}
		return false;

	}

	public int getIndex(String e) {
		for (ListaEmpleado liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return liEmp.indexOf(liemp);
			}
		}
		return 0;
	}
}
