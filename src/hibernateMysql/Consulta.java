package hibernateMysql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
// Import de Querys
import org.hibernate.query.Query;

import generarDatos.LlenarListaEmpleado;
import reverse.Listaempleados;
import reverse.ListaempleadosId;

public class Consulta {

	private static SessionFactory hbsf;

	Listaempleados liemp;
	LlenarListaEmpleado llenar = new LlenarListaEmpleado();
	ArrayList<ListaempleadosId> liEmpID = llenar.generarListadoEmpleados();

	public String insertarDatos() {
		hbsf = HibernateUtil.getSessionFactory(); // Recupera la session
		Session hbse = hbsf.openSession(); // Crear la session para ejecutar
		Transaction hbtr = hbse.beginTransaction(); // Crear la transaccion

		try {
			/*
			 * Itera sobre listaempleadoId y crea nuevas liestaempleados a partir de las
			 * listaempleadosId pasados.
			 */
			for (ListaempleadosId listaId : liEmpID) {
				liemp = new Listaempleados(listaId);
				hbse.save(liemp);
			}
			hbtr.commit();
			hbse.close(); // Se cierra la session

			return "Datos ingresados";
		} catch (Exception e) {
			// devuelve el error si llega a suceder
			return e.toString();
		}
	}

	public void mostrarDatos(String matricula) {
		hbsf = HibernateUtil.getSessionFactory(); // Recupera la session
		Session hbse = hbsf.openSession(); // Crear la session para ejecutar

		liemp = new Listaempleados();
		String ssql = "FROM Listaempleados";

		Query q1 = hbse.createQuery(ssql);
		List rs = q1.list();

		Iterator<Listaempleados> it = rs.iterator();

		while (it.hasNext()) {
			liemp = it.next();
			if (liemp.getId().getMatricula().equals(matricula)) {
				System.out.println("MATRICULA" + "\tDEPARTAMENTO" + "\t    APENOM" + "\t" + "\t" + 
						"\tTOTGASTOS" + 
						"\tTOTVENTAS" + "\t    FECHA");
				System.out.println(liemp.getId().getMatricula() + "\t" + 
				liemp.getId().getDepartamento() + "\t"+  "\t"+ 
				liemp.getId().getApenom() + "\t" +
				liemp.getId().getTotgastos() + "\t" + "\t" +
				liemp.getId().getTotventas() + "\t" + "\t" +
				liemp.getId().getFecha());
			}
		}
	}
}
