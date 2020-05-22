package main_test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.User;

public class User_Test {

	@Mock
	Statement mockstatement;

	@Mock
	Connection connection;

	@InjectMocks
	User user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateUser() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int UID = 1;
		String first_name = "Darleen";
		String last_name = "Davison";
		String mobile = "243448383";
		String email = "DDavison@QATest.com";
		String username = "Newcastle";
		String password = "NE34-2OK";

		user.createUser(UID, first_name, last_name, mobile, email, username, password);

		String test = "INSERT INTO user (UID, first_name, last_name, mobile, email, username, password) VALUES (" + UID
				+ ", \"" + first_name + "\", \"" + last_name + "\", \"" + mobile + "\", \"" + email + "\", \""
				+ username + "\", \"" + password + "\")";

		verify(mockstatement).executeUpdate(test);
	}

	@Test
	public void testUpdateUSer() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int UID = 1;
		String first_name = "Parleen";
		String last_name = "Grain";
		String mobile = "243448383";
		String email = "DDavison@QATest.com";
		String username = "Newcastle";
		String password = "NE34-2OK";

		user.updateUser(UID, first_name, last_name, mobile, email, username, password);

		String test = "UPDATE user SET first_name = '" + first_name + "'," + " last_name = '" + last_name + "',"
				+ " mobile = '" + mobile + "'," + " email = '" + email + "'," + " username = '" + username + "',"
				+ " password = '" + password + "'" + "WHERE CID =  " + UID;

		verify(mockstatement).executeUpdate(test);

	}

}
