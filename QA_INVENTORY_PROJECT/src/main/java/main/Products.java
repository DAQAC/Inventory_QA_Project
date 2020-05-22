package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products {
	private Connection conn;
	private Statement stmt;

	public Products() throws SQLException {
		conn = DriverManager.getConnection(JDBCDriver.DB_URL, JDBCDriver.USER, JDBCDriver.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createProducts(int PID, String name, int age_rating, String release_date, double price, int stock,
			String new_volume_released) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO products (PID, name, age_rating, release_date, price, stock, new_volume_released) VALUES ("
				+ PID + ", \"" + name + "\", \"" + age_rating + "\", \"" + release_date + "\", \"" + price + "\", \""
				+ stock + "\", \"" + new_volume_released + "\")";
		stmt.executeUpdate(sql);
	}

	public void readProducts() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM products");

		System.out.println("PID / Name / Age_Rating / Release_Date / Price / Stock / New_Volume_Released");

		while (rs.next()) {
			String name = rs.getInt("PID") + " " + rs.getString("name") + " " + rs.getInt("age_rating") + " "
					+ rs.getString("release_date") + " " + rs.getDouble("price") + " " + rs.getInt("stock") + " "
					+ rs.getString("new_volume_released");
			System.out.println(name);
		}

	}

	public void updateProducts(int PID, String name, int age_rating, String release_date, double price, int stock,
			String new_volume_released) throws SQLException {

		String upt = "UPDATE products SET name = '" + name + "'," + " age_rating = '" + age_rating + "',"
				+ " release_date = '" + release_date + "'," + " price = '" + price + "'," + " stock = '" + stock + "',"
				+ " new_volume_released = '" + new_volume_released + "'" + "WHERE PID =  " + PID;
		stmt.executeUpdate(upt);

	}

	public void deleteProducts(int PID) throws SQLException {
		String delete = "DELETE FROM products WHERE PID = " + PID + " ";
		stmt.executeUpdate(delete);
	}

}
