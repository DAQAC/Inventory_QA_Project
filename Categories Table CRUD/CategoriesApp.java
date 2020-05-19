package main;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoriesApp {
	private static Scanner scan = new Scanner(System.in);

	public void CategoriesRunner() throws SQLException {
		Categories dbcategories = new Categories();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create":
					System.out.println("Enter ID:");
					int ID = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter Category Name: ");
					String name = scan.nextLine();

					dbcategories.createCategories(ID, name);
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

				action = getAction();

			} while (!action.equals("quit"));
			System.out.println("Program has Ended");

		} finally {

			scan.close();
			dbcategories.close();
		}
	}

	private static String getAction() {
		System.out.println("Welcome to the Categories Table \n" + "================================ \n"
				+ "Type 'create' to CREATE \n" + "Type 'print' to PRINT \n" + "Type 'update' to UPDATE \n"
				+ "Type 'delete' to DELETE \n" + "Or 'quit' to QUIT.");
		return scan.nextLine().toLowerCase();
	}

}
