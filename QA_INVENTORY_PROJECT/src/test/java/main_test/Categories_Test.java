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

import main.Categories;

public class Categories_Test {
	@Mock
	Statement mockstatement;

	@Mock
	Connection connection;

	@InjectMocks
	Categories categories;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateCategories() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int ID = 1;
		String name = "Horror";

		categories.createCategories(ID, name);
		String test = "INSERT INTO categories (ID, name) VALUES (" + ID + ", \"" + name + "\")";

		verify(mockstatement).executeUpdate(test);
	}

	@Test
	public void testUpdateCategories() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);

		int ID = 1;
		String name = "Comedy";

		categories.updateCategories(ID, name);
		String test = "UPDATE categories SET name = '" + name + "'" + "WHERE ID =  " + ID;

		verify(mockstatement).executeUpdate(test);

	}

}
