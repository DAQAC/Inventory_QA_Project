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

import main.Products;

public class Products_Test {

	@Mock
	Statement mockstatement;

	@Mock
	Connection connection;

	@InjectMocks
	Products products;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateProducts() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int PID = 1;
		String name = "HunterxHunter";
		int age_rating = 16;
		String release_date = "19-05-1998";
		double price = 12.00;
		int stock = 100;
		String new_volume_released = "YES";

		products.createProducts(PID, name, age_rating, release_date, price, stock, new_volume_released);

		String test = "INSERT INTO products (PID, name, age_rating, release_date, price, stock, new_volume_released) VALUES ("
				+ PID + ", \"" + name + "\", \"" + age_rating + "\", \"" + release_date + "\", \"" + price + "\", \""
				+ stock + "\", \"" + new_volume_released + "\")";
		verify(mockstatement).executeUpdate(test);
	}

	@Test
	public void testUpdateProducts() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int PID = 1;
		String name = "DGray:Man";
		int age_rating = 15;
		String release_date = "Alcala";
		double price = 12.00;
		int stock = 100;
		String new_volume_released = "YES";

		products.updateProducts(PID, name, age_rating, release_date, price, stock, new_volume_released);
		String test = "UPDATE products SET name = '" + name + "'," + " age_rating = '" + age_rating + "',"
				+ " release_date = '" + release_date + "'," + " price = '" + price + "'," + " stock = '" + stock + "',"
				+ " new_volume_released = '" + new_volume_released + "'" + "WHERE PID =  " + PID;

		verify(mockstatement).executeUpdate(test);

	}

}
