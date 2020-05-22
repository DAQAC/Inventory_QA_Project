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

import main.Customer;

public class Customer_Test {

	@Mock
	Statement mockstatement;

	@Mock
	Connection connection;

	@InjectMocks
	Customer customer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateCustomer() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int CID = 1;
		String first_name = "Darleen";
		String last_name = "Davison";
		int age = 45;
		String address = "36 Longside Lane";
		String email = "DDavison@QATest.com";
		String city = "Newcastle";
		String post_code = "NE34-2OK";

		customer.createCustomer(CID, first_name, last_name, age, address, email, city, post_code);

		String test = "INSERT INTO customer (CID, first_name, last_name, age, address, email, city, post_code) VALUES ("
				+ CID + ", \"" + first_name + "\", \"" + last_name + "\", \"" + age + "\", \"" + address + "\", \""
				+ email + "\", \"" + city + "\", \"" + post_code + "\")";

		verify(mockstatement).executeUpdate(test);
	}

	@Test
	public void testUpdateCustomer() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int CID = 1;
		String first_name = "Kristin";
		String last_name = "Alcala";
		int age = 32;
		String address = "38 Farwood Road";
		String email = "Kalacala@QATest.com";
		String city = "Leeds";
		String post_code = "LS32-2OK";

		customer.updateCustomer(CID, first_name, last_name, age, address, email, city, post_code);

		String test = "UPDATE customer SET first_name = '" + first_name + "'," + " last_name = '" + last_name + "',"
				+ " age = '" + age + "'," + " address = '" + address + "'," + " email = '" + email + "'," + " city = '"
				+ city + "'," + " post_code = '" + post_code + "'" + "WHERE CID =  " + CID;

		verify(mockstatement).executeUpdate(test);

	}
}