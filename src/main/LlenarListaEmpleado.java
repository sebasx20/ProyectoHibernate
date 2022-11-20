package main;

import java.util.*;

import reverse.ListaempleadosId;
import template.Contabilidad;
import template.Empleado;

public class LlenarListaEmpleado {

	Rhhventas v = new Rhhventas();
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

		for (Contabilidad cont : contabilidad) {
			suma = cont.getSalario() + cont.getGastos();
			if (existe(cont.getMatricula())) {
				indice = getIndex(cont.getMatricula());
				liEmp.get(indice).setTotgastos((Math.round(suma * 100.0) / 100.0));
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
						liEmp.get(indice).setTotventas(Math.round(antes * 100.0) / 100.0);
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
				liEmp.add(new ListaempleadosId(em.getApenom(),em.getDepartamento(),em.getSemana(),em.getMatricula(),0.0,0.0));
			}

		}
	}

	public boolean existe(String e) {
		for (ListaempleadosId liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return true;
			}
		}
		return false;

	}

	public int getIndex(String e) {
		for (ListaempleadosId liemp : liEmp) {
			if (liemp.getMatricula().equals(e)) {
				return liEmp.indexOf(liemp);
			}
		}
		return 0;
	}
}
