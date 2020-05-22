package main;

import java.sql.SQLException;
import java.util.Scanner;

public class OrdersApp {

	private static Scanner scan = new Scanner(System.in);

	public OrdersApp() {

	}

	private static String getAction() {
		System.out.println(
				"Welcome to the Orders Table \n" + "================================ \n" + "Type 'create' to CREATE \n"
						+ "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n" + "Type 'delete' to DELETE \n"
						+ "Type 'total' to get the PRICE TOTAL of an ORDER. \n" + "Or 'menu' to go back to MAIN MENU");
		return scan.nextLine().toLowerCase();
	}

	public void OrdersRunner() throws SQLException {
		Orders dborders = new Orders();

		String action = "";
		action = getAction();

		String input = "";

		do {

			switch (action) {

			case "create":

				System.out.println("Enter OID:");
				int OID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter the Product ID (PID): ");
				int fk_PID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter the Customer ID (CID): ");
				int fk_CID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter the Quantity:");
				int quantity = scan.nextInt();
				scan.nextLine();

				dborders.createOrders(OID, fk_PID, fk_CID, quantity);
				System.out.println("Order information was added to the table.");
				break;

			case "print":
				dborders.printOrders();
				break;

			case "update":

				System.out.println("Enter OID ");
				int upOID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Updated (fk)PID: ");
				int upfk_PID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Updated (fk)CID: ");
				int upfk_CID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Updated Quantity: ");
				int upquantity = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter the Total_Price: ");
				double uptotalprice = scan.nextDouble();
				scan.nextLine();

				dborders.updateOrders(upOID, upfk_PID, upfk_CID, upquantity, uptotalprice);
				System.out.println("Update Succesful!");
				break;

			case "delete":
				System.out.println("Enter the OID:");
				int delOID = Integer.parseInt(scan.nextLine());
				dborders.deleteOrders(delOID);
				System.out.println("Information has been deleted");
				break;

			case "total":
				System.out.println("which order do you want to calculate? (Enter OID)");
				int totOID = scan.nextInt();
				scan.nextLine();
				dborders.totalOrders(totOID);
				break;

			default:
				System.out.println("No matching case");

			}

			System.out.println(
					"Type 'menu' to go back to the MAIN MENU \n" + "Type 'table' to go back to the TABLE MENU");
			input = scan.nextLine();
			if (input.equals("menu")) {
				action = "back";
				break;
			} else if (input.equals("table")) {
				action = getAction();

			}

		} while (!action.equals("back"));

	}
}
