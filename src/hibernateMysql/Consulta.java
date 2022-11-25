package hibernateMysql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
// Import de Querys
import org.hibernate.query.Query;

import obtenerDatos.LlenarListaEmpleado;
import reverse.Listaempleados;
import reverse.ListaempleadosId;

public class Consulta {

	private static SessionFactory hbsf;
	Listaempleados liemp;
	ArrayList<ListaempleadosId> liEmpID = new LlenarListaEmpleado().general();

	public String insertarDatos() {
		hbsf = HibernateUtil.getSessionFactory(); // Recupera la session
		Session hbse = hbsf.openSession(); // Crear la session para ejecutar
		Transaction hbtr = hbse.beginTransaction(); // Crear la transaccion

		try {
			for (ListaempleadosId listaId : liEmpID) {
				liemp = new Listaempleados(listaId);
				hbse.save(liemp);
			}
			hbtr.commit();

			hbse.close(); // Se cierra la session
			return "Datos ingresados";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return e.toString();
		}
	}

	public void mostrarDatos() {
//		hbsf = HibernateUtil.getSessionFactory(); // Recupera la session
		Session hbse = hbsf.openSession(); // Crear la session para ejecutar
		
		liemp = new Listaempleados();
		String ssql = "FROM LISTAEMPLEADOS L WHERE L.ID";
		
		Query q1 = hbse.createQuery(ssql);
		
		List rs = q1.list();
		Iterator<Listaempleados> it = rs.iterator();
		
		while(it.hasNext()) {
			liemp = it.next();
			System.out.println("ID : " + liemp.getId());
			System.out.println("NOmbre : ");
		}
		
	}
}
