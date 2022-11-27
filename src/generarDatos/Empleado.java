package generarDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import paths.DbConnection;

public class Empleado {

	String matricula;
	String apenom;
	String departamento;
	Date semana;
	double ventas;

	//
	public Empleado() {
	}

	public Empleado(String matricula, String apenom, String departamento, double ventas, Date semana) {
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
//	public void mostrarEmpleados(ArrayList<Empleado> Empleados) {
//		// Mostrar empleados por consola
//		for (Empleado empleado : Empleados) {
//			System.out.println(empleado.toString());
//		}
//	}

	public ArrayList<Empleado> generarRhhventas() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		DbConnection db1eva = new DbConnection();

		// Obtiene los datos sumados
		String query = "SELECT matricula,apenom, departamento,  ROUND(SUM(ventas),5) AS ventas, semana FROM rrhhventas GROUP BY matricula";
//		String query = "SELECT * FROM rrhhventas"; // obtiene todos los datos sin procesar

		try {
			Connection db = DriverManager.getConnection(db1eva.getDb(), db1eva.getUser(), db1eva.getPassword());
			Statement sta = db.createStatement();
			ResultSet rs;
			rs = sta.executeQuery(query);

			while (rs.next()) {
				empleados.add(new Empleado(rs.getString("MATRICULA"), rs.getString("APENOM"),
						rs.getString("DEPARTAMENTO"), rs.getDouble("VENTAS"), rs.getDate("semana")));
			}
			rs.close();
			sta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public String toString() {
		return "Empleado [matricula=" + matricula + ", apenom=" + apenom + ", departamento=" + departamento
				+ ", semana=" + semana + ", ventas=" + ventas + "]";
	}

}