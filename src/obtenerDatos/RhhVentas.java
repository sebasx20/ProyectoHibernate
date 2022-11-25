package obtenerDatos;

import java.sql.*;
import java.util.ArrayList;
import paths.DbConnection;
import template.Empleado;

public class RhhVentas {
	
	public ArrayList<Empleado> generarRhhventas() {
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		DbConnection db1eva = new DbConnection(); // Establece la conexión con la BBDD de MariaDB
		String query = "select * from rrhhventas";
		
		try {
			Connection db  = DriverManager.getConnection(db1eva.getDb(),db1eva.getUser(),db1eva.getPassword());
			Statement sta = db.createStatement();
			ResultSet rs;
			rs = sta.executeQuery(query);
			
			while(rs.next()){
				empleados.add(
						new Empleado(
								rs.getString("MATRICULA"),
								rs.getString("APENOM"),
								rs.getString("DEPARTAMENTO"),
								rs.getDouble("VENTAS"),
								rs.getDate("semana")
								)
						);
	        }
			rs.close();
			sta.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Mostrar los datos por consola
//		Empleado emp = new Empleado();
//		emp.mostrarEmpleados(empleados);
		
		return empleados;
	}
	
}
