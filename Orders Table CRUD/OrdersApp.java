package main;

import java.sql.SQLException;
import java.util.Scanner;

public class OrdersApp {
	private static Scanner scan = new Scanner(System.in);

	public void OrdersRunner() throws SQLException {
		Orders dborders = new Orders();

		try {
			String action = "";
			action = getAction();

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

					System.out.println("Enter the total of the order:");
					double total = scan.nextDouble();
					scan.nextLine();

					dborders.createOrders(OID, fk_PID, fk_CID, total);
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

					System.out.println("Enter Updated Total Price: ");
					double uptotal = scan.nextDouble();
					scan.nextLine();

					dborders.updateOrders(upOID, upfk_PID, upfk_CID, uptotal);
					System.out.println("Update Succesful!");
					break;

				case "delete":
					System.out.println("Enter the OID:");
					int delOID = Integer.parseInt(scan.nextLine());
					dborders.deleteOrders(delOID);
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
			dborders.close();
		}
	}

	private static String getAction() {
		System.out.println("Welcome to the Orders Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'quit' to QUIT.");
		return scan.nextLine().toLowerCase();
	}

}
