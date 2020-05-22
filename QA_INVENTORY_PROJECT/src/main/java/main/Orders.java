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

	public void createOrders(int OID, int fk_PID, int fk_CID, int quantity) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO orders (OID, fk_PID, fk_CID, quantity) VALUES (" + OID + ", \"" + fk_PID + "\", \""
				+ fk_CID + "\", \"" + quantity + "\")";
		stmt.executeUpdate(sql);
	}

	public void printOrders() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

		System.out.println("OID / PID / CID / Quantity / TOTAL_PRICE");

		while (rs.next()) {
			String name = rs.getInt("OID") + " " + rs.getInt("fk_PID") + " " + rs.getInt("fk_CID") + " "
					+ rs.getInt("quantity") + " " + rs.getDouble("total_price");
			System.out.println(name);
		}
	}

	public void updateOrders(int OID, int fk_PID, int fk_CID, int quantity, double total_price) throws SQLException {

		String upt = "UPDATE orders SET fk_PID = '" + fk_PID + "'," + " fk_CID = '" + fk_CID + "'," + " quantity = '"
				+ quantity + "'," + " total_price = '" + total_price + "'" + "WHERE OID =  " + OID;
		stmt.executeUpdate(upt);
	}

	public void deleteOrders(int OID) throws SQLException {

		String delete = "DELETE FROM orders WHERE OID = " + OID + " ";
		stmt.executeUpdate(delete);
	}

	public void totalOrders(int OID) throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"select OID, fk_CID, name, (products.price * orders.quantity) AS order_total FROM products, orders WHERE products.PID = orders.fk_PID "
						+ "AND OID = " + OID);

		System.out.println("OID / CID / Name / Order_Total");

		while (rs.next()) {
			String total = rs.getInt("OID") + " " + rs.getInt("fk_CID") + " " + rs.getString("name") + " "
					+ rs.getDouble("order_total");
			System.out.println(total);
		}

	}

//	public void calcOrder() throws SQLException {
//		this.stmt = conn.createStatement();
//		System.out.println("how much ");
//		String sql = "SELECT price * quantity AS VALUE FROM products, orders WHERE PID=4 and OID=3;
//				+ ""
//				+ "INSERT INTO orders (OID, fk_PID, fk_CID, quantity) VALUES (" + OID + ", \"" + fk_PID + "\", \""
//				+ fk_CID + "\", \"" + quantity + "\")";
//		stmt.executeUpdate(sql);
//	}

	;
}
