package generarDatos;
import java.util.*;

import reverse.Listaempleados;
import reverse.ListaempleadosId;

public class LlenarListaEmpleado {

//	RhhVentas v = new RhhVentas();
	
	Empleado empleado = new Empleado();
	Contabilidad contabilidad = new Contabilidad();

	ArrayList<Empleado> aEmp = empleado.generarRhhventas();
	ArrayList<Contabilidad> aConta = contabilidad.generarContabilidad();
	ArrayList<ListaempleadosId> liEmp = new ArrayList<>();
	ArrayList<Listaempleados> liEmpId = new ArrayList<>();
	
	
//	private double antes;
//	private int indice = 0;
	
	public ArrayList<ListaempleadosId> generarListadoEmpleados(){
// String apenom, String departamento, Date fecha, String matricula, Double totgastos, Double totventas
		double totGastos;
		for(Empleado e:aEmp) {
			totGastos = generarGastosTotales(e.getMatricula());
			liEmp.add(new ListaempleadosId(e.getApenom(),e.getDepartamento(),e.getSemana(),e.getMatricula(),
					totGastos,e.getVentas()));
		}
		return liEmp;
	}
	
	public double generarGastosTotales(String matricula){
		double suma=0;
		for(Contabilidad c:aConta) {
			if(c.getMatricula().equals(matricula)) {
				suma =(Math.round( (c.getSalario() + c.getGastos()) * 100.0) / 100.0);
				return suma;
			}
		}
		return suma;
	}
}
