package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDB {

	private Connection conn;
	private Statement stmt;

	public CustomerDB() throws SQLException {
		conn = DriverManager.getConnection(ClassConfig.DB_URL, ClassConfig.USER, ClassConfig.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

//	public void createCustomer(String fName, String lName) throws SQLException {
//		stmt.executeUpdate(
//				"INSERT INTO customer (`first_name`, `last_name`)" + " VALUES ('" + fName + "', '" + lName + "')");
//	}

	public void create(int CID, String first_name, String last_name, int age, String address, String email, String city,
			String post_code) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO customer (CID, first_name, last_name, age, address, email, city, post_code) VALUES ("
				+ CID + ", \"" + first_name + "\", \"" + last_name + "\", \"" + age + "\", \"" + address + "\", \""
				+ email + "\", \"" + city + "\", \"" + post_code + "\")";
		stmt.executeUpdate(sql);
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("email");
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
