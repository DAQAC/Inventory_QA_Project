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

import main.Orders;

public class Orders_Test {

	@Mock
	Statement mockstatement;

	@Mock
	Connection connection;

	@InjectMocks
	Orders orders;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateOrders() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int OID = 1;
		int fk_PID = 4;
		int fk_CID = 5;
		int quantity = 3;

		orders.createOrders(OID, fk_PID, fk_CID, quantity);
		String test = "INSERT INTO orders (OID, fk_PID, fk_CID, quantity) VALUES (" + OID + ", \"" + fk_PID + "\", \""
				+ fk_CID + "\", \"" + quantity + "\")";

		verify(mockstatement).executeUpdate(test);
	}

	@Test
	public void testUpdateOrders() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int OID = 1;
		int fk_PID = 1;
		int fk_CID = 1;
		int quantity = 1;
		double total_price = 9.99;

		orders.updateOrders(OID, fk_PID, fk_CID, quantity, total_price);
		String test = "UPDATE orders SET fk_PID = '" + fk_PID + "'," + " fk_CID = '" + fk_CID + "'," + " quantity = '"
				+ quantity + "'," + " total_price = '" + total_price + "'" + "WHERE OID =  " + OID;
		verify(mockstatement).executeUpdate(test);

	}

}
