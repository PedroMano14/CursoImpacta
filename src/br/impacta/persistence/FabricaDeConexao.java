package br.impacta.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {

	private static String USERNAME = "root";
	private static String PASSWORD = "root";

	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/programadores?useTimezone=true&serverTimezone=UTC";

	public static Connection criaConexaoComMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}
}