package main;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		CustomerDB db = new CustomerDB();
//			DB db2 = new DB();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create": // this works!!!!!

					System.out.println("Enter CID:");
					int CID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter first name: ");
					String first_name = scan.nextLine();

					System.out.println("Enter last name: ");
					String last_name = scan.nextLine();

					System.out.println("Enter age:");
					int age = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter address: ");
					String address = scan.nextLine();

					System.out.println("Enter email: ");
					String email = scan.nextLine();

					System.out.println("Enter city: ");
					String city = scan.nextLine();

					System.out.println("Enter post_code: ");
					String post_code = scan.nextLine();

					db.create(CID, first_name, last_name, age, address, email, city, post_code);
					break;

				case "print":
					db.readCustomer();
					break;

				case "delete":
					System.out.println("Enter the cid:");
					int cid = Integer.parseInt(scan.nextLine());
					db.deleteCustomer(cid);
					break;

				default:
					System.out.println("No matching case");

				}

				action = getAction();

			} while (!action.equals("quit"));
			System.out.println("bye");

		} finally {

			scan.close();
			db.close();
		}
	}

	private static String getAction() {
		System.out.println("Type 'create' to create, 'print' to print, 'delete' to delete or 'quit' to quit.");
		return scan.nextLine().toLowerCase();
	}

}
