package main;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerApp {
	private static Scanner scan = new Scanner(System.in);

	public CustomerApp() {

	}

	public void CustomerRunner() throws SQLException {
		Customer db = new Customer();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create":
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

					db.createCustomer(CID, first_name, last_name, age, address, email, city, post_code);
					break;
//----------------------------------------------------------------------------------------
				case "print":
					db.readCustomer();
					break;
//----------------------------------------------------------------------------------------
				case "update":

					System.out.println("Enter CID ");
					int upCID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter Updated First Name: ");
					String upfirst_name = scan.nextLine();

					System.out.println("Enter Updated Last Name: ");
					String uplast_name = scan.nextLine();

					System.out.println("Enter Updated Age: ");
					int upage = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter Updated Address: ");
					String upaddress = scan.nextLine();

					System.out.println("Enter Updated Email: ");
					String upemail = scan.nextLine();

					System.out.println("Enter Updated City Location: ");
					String upcity = scan.nextLine();

					System.out.println("Enter Updated Post Code: ");
					String uppost_code = scan.nextLine();

					db.updateCustomer(upCID, upfirst_name, uplast_name, upage, upaddress, upemail, upcity, uppost_code);
					System.out.println("Update Succesful!");
					break;
//----------------------------------------------------------------------------------------
				case "delete":
					System.out.println("Enter the CID:");
					int delCID = Integer.parseInt(scan.nextLine());
					db.deleteCustomer(delCID);
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
			db.close();
		}
	}

	private static String getAction() {
		System.out.println("Welcome to the Customer Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'quit' to QUIT.");
		return scan.nextLine().toLowerCase();
	}

}
