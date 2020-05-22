package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Categories {

	private Connection conn;
	private Statement stmt;

	public Categories() throws SQLException {
		conn = DriverManager.getConnection(JDBCDriver.DB_URL, JDBCDriver.USER, JDBCDriver.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createCategories(int ID, String name) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO categories (ID, name) VALUES (" + ID + ", \"" + name + "\")";
		stmt.executeUpdate(sql);
	}

	public void readCategories() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM categories");

		System.out.println("ID / name / created_at / updated_at");

		while (rs.next()) {
			String name = rs.getInt("ID") + " " + rs.getString("name") + " " + rs.getTimestamp("created_at") + " "
					+ rs.getTimestamp("updated_at");
			System.out.println(name);

		}
	}

	public void updateCategories(int ID, String name) throws SQLException {

		String upt = "UPDATE categories SET name = '" + name + "'" + "WHERE ID =  " + ID;
		stmt.executeUpdate(upt);

	}

	public void deleteCategories(int ID) throws SQLException {
		String delete = "DELETE FROM categories WHERE ID = " + ID + " ";
		stmt.executeUpdate(delete);
	}

}
