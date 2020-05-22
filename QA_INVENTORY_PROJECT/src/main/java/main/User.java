package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

	private Connection conn;
	private Statement stmt;

	public User() throws SQLException {
		conn = DriverManager.getConnection(JDBCDriver.DB_URL, JDBCDriver.USER, JDBCDriver.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void createUser(int UID, String first_name, String last_name, String mobile, String email, String username,
			String password) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO user (UID, first_name, last_name, mobile, email, username, password) VALUES (" + UID
				+ ", \"" + first_name + "\", \"" + last_name + "\", \"" + mobile + "\", \"" + email + "\", \""
				+ username + "\", \"" + password + "\")";
		stmt.executeUpdate(sql);
	}

	public void readUser() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM user");

		System.out.println("UID / First_Name / Last_Name / Mobile / Email / Username / Password");

		while (rs.next()) {
			String name = rs.getInt("UID") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + " "
					+ rs.getInt("Mobile") + " " + rs.getString("email") + " " + rs.getString("username") + " "
					+ rs.getString("password");
			System.out.println(name);

		}
	}

	public void updateUser(int UID, String first_name, String last_name, String mobile, String email, String username,
			String password) throws SQLException {

		String upt = "UPDATE user SET first_name = '" + first_name + "'," + " last_name = '" + last_name + "',"
				+ " mobile = '" + mobile + "'," + " email = '" + email + "'," + " username = '" + username + "',"
				+ " password = '" + password + "'" + "WHERE CID =  " + UID;
		stmt.executeUpdate(upt);

	}

	public void deleteUser(int UID) throws SQLException {
		String delete = "DELETE FROM user WHERE UID = " + UID + " ";
		stmt.executeUpdate(delete);
	}

}
