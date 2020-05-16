package main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		db.readCustomer();
	}

//	DB db2 = new DB();
//	try
//	{
	String action = "";action=

	getAction();do

	{
		switch (action) {
		case "create":
			System.out.println("Enter first name:");
			String fName = scan.nextLine();
			System.out.println("Enter last name: ");
			String lname = scan.nextLine();
			db.createCustomer(fName, lname);
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
	}while(!action.equals("quit"));System.out.println("bye");
//	}finally
//	{
	scan.close();db.close();
	}

	private static String getAction() {
		System.out.println("Type 'create' to create, 'print' to print, 'delete' to delete or 'quit' to quit.");
		return scan.nextLine().toLowerCase();
	}
}}