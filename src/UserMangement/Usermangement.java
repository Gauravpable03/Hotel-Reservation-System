package UserMangement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Usermangement {
	static ArrayList<User> AL = new ArrayList();
	static {
		try {
			MemoryReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Usermangement() throws IOException {
		Scanner s = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while (CanIKeepRunningTheProgram) {
			System.out.println("....Welcome to UserMangement....");
			System.out.println("1.Add User");
			System.out.println("2.Edit User");
			System.out.println("3.Delete User");
			System.out.println("4.Search User");
			System.out.println("5.Exit\n");

			int OptionBySelectByUser = s.nextInt();
			if (OptionBySelectByUser == UserOptions.Adduser) {
				AddUser();
			} else if (OptionBySelectByUser == UserOptions.Edit) {
				System.out.println("Enter the UserName to Edit");
				s.nextLine();
				String UN = s.nextLine();
				EditUser(UN);
			} else if (OptionBySelectByUser == UserOptions.Delete) {
				System.out.println("Enter the UserName to Delete");
				s.nextLine();
				String UND = s.nextLine();
				DeleteUser(UND);
			} else if (OptionBySelectByUser == UserOptions.Search) {
				System.out.println("Enter the UserName to Search");
				s.nextLine();
				String UNS = s.nextLine();
				SearchUser(UNS);
			} else if (OptionBySelectByUser == UserOptions.Exit) {
				File F = new File(
						"C:\\Users\\Admin\\eclipse-workspace\\HotelReservationSyatem\\src\\UserMangement\\UserMangement.txt");

				FileWriter FW = new FileWriter(F, false);

				BufferedWriter BW = new BufferedWriter(FW);

				for (User U : AL) {
					BW.write(
							U.Name + "," + U.Login + "," + U.Password + "," + U.Gmail_ID + "," + U.Adharcard_No + "\n");
				}

				BW.close();
				FW.close();
				F = null;

				System.out.println(">>... Program Closed ! ...<<");
				CanIKeepRunningTheProgram = false;
			}

		}

	}

	public static void AddUser() {
		Scanner s = new Scanner(System.in);
		User UserObject = new User();
		System.out.println("Full_Name :");
		UserObject.Name = s.nextLine();
		System.out.println("Login:");
		UserObject.Login = s.nextLine();
		System.out.println("Password");
		UserObject.Password = s.nextLine();
		System.out.println("Gmail_ID");
		UserObject.Gmail_ID = s.nextLine();
		System.out.println("\n");

		AL.add(UserObject);
	}

	public static void EditUser(String Name) {
		Scanner s = new Scanner(System.in);
		for (User U : AL)
			if (U.Name.equalsIgnoreCase(Name)) {
				System.out.println("Full_Name :");
				U.Name = s.nextLine();
				System.out.println("Login:");
				U.Login = s.nextLine();
				System.out.println("Password");
				U.Password = s.nextLine();
				System.out.println("Gmail_ID");
				U.Gmail_ID = s.nextLine();
				System.out.println("\n");
				return;
			}

	}

	public static void DeleteUser(String Name) {
		Iterator<User> IU = AL.iterator();
		while (IU.hasNext()) {
			User U = IU.next();
			if (U.Name.equalsIgnoreCase(Name)) {
				IU.remove();
				System.out.println(U.Name+" has been deleted");
			}
		}
	}

	public static void SearchUser(String Name) {
		for (User U : AL) 
			if (U.Name.equalsIgnoreCase(Name)) {
				System.out.println("Name : " + U.Name);
				System.out.println("Login :" + U.Login);
				System.out.println("Password :" + U.Password);
				System.out.println("Gamil_ID : " + U.Gmail_ID);
			
                
			} 
		}
	

	public static void MemoryReader() throws IOException {
		File F = new File(
				"C:\\Users\\Admin\\eclipse-workspace\\HotelReservationSyatem\\src\\UserMangement\\UserMangement.txt");

		FileReader FR = new FileReader(F);

		BufferedReader BR = new BufferedReader(FR);

		String Line;

		while ((Line = BR.readLine()) != null) {
			User u = new User();

			String[] arraylist = Line.split(",");
			if (arraylist.length > 3) {
				u.Name = arraylist[0];
				u.Login = arraylist[1];
				u.Password = arraylist[2];
				u.Gmail_ID = arraylist[3];
				
				AL.add(u);
			}
		}
	}

	public static boolean LoginProcess(String Login, String Password) {
		Iterator<User> IU = AL.iterator();
		while (IU.hasNext()) {
			User u = IU.next();
			if (u.Login.equalsIgnoreCase(Login) && u.Password.equalsIgnoreCase(Password)) {
				return true;
			}
		}
		return false;
	}
}
