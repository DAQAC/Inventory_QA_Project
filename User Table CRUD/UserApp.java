package main;

import java.sql.SQLException;
import java.util.Scanner;

public class UserApp {
	private static Scanner scan = new Scanner(System.in);

	public void UserRunner() throws SQLException {
		User dbuser = new User();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create":
					System.out.println("Enter UID:");
					int UID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter first name: ");
					String first_name = scan.nextLine();

					System.out.println("Enter last name: ");
					String last_name = scan.nextLine();

					System.out.println("Enter Mobile Number:");
					String mobile = scan.nextLine();

					System.out.println("Enter Email: ");
					String email = scan.nextLine();

					System.out.println("Enter Username: ");
					String username = scan.nextLine();

					System.out.println("Enter Password: ");
					String password = scan.nextLine();

					dbuser.createUser(UID, first_name, last_name, mobile, email, username, password);
					break;
//----------------------------------------------------------------------------------------
				case "print":
					dbuser.readUser();
					break;
//----------------------------------------------------------------------------------------
				case "update":

					System.out.println("Enter UID:");
					int upUID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter first name: ");
					String upfirst_name = scan.nextLine();

					System.out.println("Enter last name: ");
					String uplast_name = scan.nextLine();

					System.out.println("Enter Mobile Number:");
					String upmobile = scan.nextLine();

					System.out.println("Enter Email: ");
					String upemail = scan.nextLine();

					System.out.println("Enter Username: ");
					String upusername = scan.nextLine();

					System.out.println("Enter Password: ");
					String uppassword = scan.nextLine();

					dbuser.updateUser(upUID, upfirst_name, uplast_name, upmobile, upemail, upusername, uppassword);
					System.out.println("Update Succesful!");
					break;
////----------------------------------------------------------------------------------------
				case "delete":
					System.out.println("Enter the UID:");
					int delUID = Integer.parseInt(scan.nextLine());
					dbuser.deleteUser(delUID);
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
			dbuser.close();
		}
	}

	private static String getAction() {
		System.out.println("Welcome to the User Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'quit' to QUIT.");
		return scan.nextLine().toLowerCase();
	}

}
