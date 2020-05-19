package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders {

	private Connection conn;
	private Statement stmt;

	public Orders() throws SQLException {
		conn = DriverManager.getConnection(JDBCDriver.DB_URL, JDBCDriver.USER, JDBCDriver.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createOrders(int OID, int fk_PID, int fk_CID, double total) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO orders (OID, fk_PID, fk_CID, total) VALUES (" + OID + ", \"" + fk_PID + "\", \""
				+ fk_CID + "\", \"" + total + "\")";
		stmt.executeUpdate(sql);
	}

	public void printOrders() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
		while (rs.next()) {
			String name = rs.getInt("OID") + " " + rs.getInt("fk_PID") + " " + rs.getInt("fk_CID") + " "
					+ rs.getDouble("total");
			System.out.println(name);
		}
	}

//	public void updateOrders(String fName, String lName, int cid) throws SQLException {
//		stmt.executeUpdate(
//				"UPDATE customer SET first_name = '" + fName + "', last_name = '" + lName + "' WHERE cid = " + cid);
//	}

	public void updateOrders(int OID, int fk_PID, int fk_CID, double total) throws SQLException {

		String upt = "UPDATE orders SET fk_PID = '" + fk_PID + "'," + " fk_CID = '" + fk_CID + "'," + " total = '"
				+ total + "'" + "WHERE OID =  " + OID;
		stmt.executeUpdate(upt);
	}

	public void deleteOrders(int OID) throws SQLException {
		String delete = "DELETE FROM orders WHERE OID = " + OID + " ";
		stmt.executeUpdate(delete);
	}

}
