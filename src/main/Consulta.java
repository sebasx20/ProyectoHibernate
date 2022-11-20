package main;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import reverse.Listaempleados;
import reverse.ListaempleadosId;

public class Consulta {
	
	private static SessionFactory hbsf;
	
	public String crearUsuario() {
		Listaempleados liemp;
		ArrayList<ListaempleadosId> liEmpID = new LlenarListaEmpleado().general();
		
		
		hbsf = HibernateUtil.getSessionFactory();
		Session hbse = hbsf.openSession();
		Transaction hbtr = hbse.beginTransaction();

		try {

			for (ListaempleadosId listaId : liEmpID) {
				liemp = new Listaempleados(listaId);
				hbse.save(liemp);
				
			}
			hbtr.commit();
			
			hbse.close();
			return "Datos ingresados";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "verga";
		}
	}
}
