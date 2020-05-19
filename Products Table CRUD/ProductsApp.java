package main;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsApp {
	private static Scanner scan = new Scanner(System.in);

	public void ProductsRunner() throws SQLException {
		Products dbproducts = new Products();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create":

					System.out.println("Enter PID:");
					int PID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter name of products: ");
					String name = scan.nextLine();

					System.out.println("Enter the product's age rating: ");
					int age_rating = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter the product's release_date:");
					String release_date = scan.nextLine();

					System.out.println("Enter the price: ");
					double price = scan.nextDouble();
					scan.nextLine();

					System.out.println("What is the quantity of this product: ");
					int stock = scan.nextInt();
					scan.nextLine();

					System.out.println("Is there a new volume released? (YES/NO): ");
					String new_volume_released = scan.nextLine();

					dbproducts.createProducts(PID, name, age_rating, release_date, price, stock, new_volume_released);
					break;

				case "print":
					dbproducts.readProducts();
					break;

				case "update":

					System.out.println("Enter PID ");
					int upPID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter Updated  Name: ");
					String upname = scan.nextLine();

					System.out.println("Enter Updated Age Rating: ");
					int upage_rating = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter Updated release_date: ");
					String uprelease_date = scan.nextLine();

					System.out.println("Enter Updated Price: ");
					double upprice = scan.nextDouble();
					scan.nextLine();

					System.out.println("Enter Updated Stock Quantity: ");
					int upstock = scan.nextInt();
					scan.nextLine();

					System.out.println("Has there been a new volume released?: ");
					String upnew_volume_released = scan.nextLine();

					dbproducts.updateProducts(upPID, upname, upage_rating, uprelease_date, upprice, upstock,
							upnew_volume_released);
					System.out.println("Update Succesful!");
					break;

				case "delete":
					System.out.println("Enter the PID:");
					int delPID = Integer.parseInt(scan.nextLine());
					dbproducts.deleteProducts(delPID);
					System.out.println("Information has been deleted");
					break;

				default:
					System.out.println("No matching case");

				}

				action = getAction();

			} while (!action.equals("quit"));
			System.out.println("Program has Ended");

		} finally {

			scan.close();
			dbproducts.close();
		}
	}

	private static String getAction() {
		System.out.println("Welcome to the Customer Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'quit' to QUIT.");
		return scan.nextLine().toLowerCase();
	}

}
