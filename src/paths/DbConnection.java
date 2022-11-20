package paths;

public class DbConnection {
	String db = "jdbc:mariadb://localhost:3306/db1eva";
	String user = "root";
	String password = "root";

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DbConnection [db=" + db + ", user=" + user + ", password=" + password + "]";
	}
	
}
