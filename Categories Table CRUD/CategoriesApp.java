package main;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoriesApp {
	private static Scanner scan = new Scanner(System.in);

	public CategoriesApp() {
	}

	private static String getAction() {
		System.out.println("Welcome to the Customer Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'back' to Return to the main menu.");
		return scan.nextLine().toLowerCase();
	}

	public void CategoriesRunner() throws SQLException {
		Categories dbcategories = new Categories();

		String action = "";
		action = getAction();

		String input = "";

		do {

			switch (action) {

			case "create":
				System.out.println("Enter ID:");
				int ID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Category Name: ");
				String name = scan.nextLine();

				dbcategories.createCategories(ID, name);
				System.out.println("Category information was added to the table.");
				break;
//----------------------------------------------------------------------------------------
			case "print":
				dbcategories.readCategories();
				break;
//----------------------------------------------------------------------------------------
			case "update":

				System.out.println("Enter Updated ID ");
				int upID = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Updated Name: ");
				String upname = scan.nextLine();

				dbcategories.updateCategories(upID, upname);
				System.out.println("Update Succesful!");
				break;
////----------------------------------------------------------------------------------------
			case "delete":
				System.out.println("Enter the ID:");
				int delID = Integer.parseInt(scan.nextLine());
				dbcategories.deleteCategories(delID);
				System.out.println("Information has been deleted");
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
