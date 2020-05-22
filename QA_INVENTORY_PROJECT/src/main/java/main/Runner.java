package main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	Runner run = new Runner();

	private static Scanner scan = new Scanner(System.in);

	private static String getAction() {
		System.out.println("______Daryl's Manga Shop______ \n" + "-----------------------------------");
		System.out.println(
				"Welcome, follow the instructions below to continue. \n" + "-----------------------------------");
		System.out.println("Type 'customer' for CUSTOMER Table: \n" + "Type 'products' for PRODUCTS Table: \n"
				+ "Type 'orders' for ORDERS Table: \n" + "Type 'categories' for CATEGORIES Table: \n"
				+ "Type 'user' for USER Table: \n" + "Type 'quit' to end the session.");
		return scan.nextLine().toLowerCase();
	}

	public static void main(String[] args) throws SQLException {

		try {
			String action = "";
			action = getAction();

			while (!action.equals("quit")) {

				switch (action) {

				case "customer":
					CustomerApp cus = new CustomerApp();
					cus.CustomerRunner();
					break;

				case "products":
					ProductsApp pro = new ProductsApp();
					pro.ProductsRunner();
					break;

				case "orders":
					OrdersApp ord = new OrdersApp();
					ord.OrdersRunner();
					break;

				case "categories":
					CategoriesApp cat = new CategoriesApp();
					cat.CategoriesRunner();
					break;

				case "user":
					UserApp use = new UserApp();
					use.UserRunner();
					break;

				}

				action = getAction();

			}
			System.out.println("Session has Ended");
		} finally {

			scan.close();

		}
	}
}
