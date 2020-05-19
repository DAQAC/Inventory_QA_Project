package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	private Connection conn;
	private Statement stmt;

	public Customer() throws SQLException {
		conn = DriverManager.getConnection(JDBCDriver.DB_URL, JDBCDriver.USER, JDBCDriver.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createCustomer(int CID, String first_name, String last_name, int age, String address, String email,
			String city, String post_code) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO customer (CID, first_name, last_name, age, address, email, city, post_code) VALUES ("
				+ CID + ", \"" + first_name + "\", \"" + last_name + "\", \"" + age + "\", \"" + address + "\", \""
				+ email + "\", \"" + city + "\", \"" + post_code + "\")";
		stmt.executeUpdate(sql);
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

		System.out.println("CID / First_Name / Last_Name / Age / Address / Email / City / Post_Code");

		while (rs.next()) {
			String name = rs.getInt("CID") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " "
					+ rs.getInt("age") + " " + rs.getString("address") + " " + rs.getString("email") + " "
					+ rs.getString("city") + " " + rs.getString("post_code");
			System.out.println(name);

		}
	}

	public void updateCustomer(int CID, String first_name, String last_name, int age, String address, String email,
			String city, String post_code) throws SQLException {

		String upt = "UPDATE customer SET first_name = '" + first_name + "'," + " last_name = '" + last_name + "',"
				+ " age = '" + age + "'," + " address = '" + address + "'," + " email = '" + email + "'," + " city = '"
				+ city + "'," + " post_code = '" + post_code + "'" + "WHERE CID =  " + CID;
		stmt.executeUpdate(upt);

	}

	public void deleteCustomer(int CID) throws SQLException {
		String delete = "DELETE FROM customer WHERE CID = " + CID + " ";
		stmt.executeUpdate(delete);
	}

}
