package apptarefa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	

	public Connection getConexao() {

		Connection con = null;

		try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dbtarefa?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "@slash";
		
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
