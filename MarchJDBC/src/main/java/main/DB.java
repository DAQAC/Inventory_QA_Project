package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;
	private Statement stmt;

	public DB() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createCustomer(String fName, String lName) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO customer (`first_name`, `last_name`)" + " VALUES ('" + fName + "', '" + lName + "')");
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
	}

	public void updateCustomer(String fName, String lName, int cid) throws SQLException {
		stmt.executeUpdate(
				"UPDATE customer SET first_name = '" + fName + "', last_name = '" + lName + "' WHERE cid = " + cid);
	}

	public void deleteCustomer(int cid) throws SQLException {
		stmt.executeUpdate("DELETE FROM game WHERE CID = " + cid);
	}

	public void createCustomer(int cus_id, String fName, String lname) {
		// TODO Auto-generated method stub

	}

}
