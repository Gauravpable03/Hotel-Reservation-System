package HotelMangement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Hotelmangement {
	static int Roomavailable = 20;
	static List<Hotel> AL = new ArrayList();

	public static void HotelMAngement() throws IOException {
		MemoryReaders();
		Scanner s = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while (CanIKeepRunningTheProgram) {
			System.out.println("....Welcome to Hotel Tajmhal...." + "\n");
			System.out.println("1.Display Room");
			System.out.println("2.Add Booking");
			System.out.println("3.Delete Booking");
			System.out.println("4.Search Resrvation");
			System.out.println("5.Edit Booking");
			System.out.println("6.Exit\n");
			int OptionBySelectByUser = s.nextInt();
			if (OptionBySelectByUser == Hoteloptions.DisplayRoom) {
				DisplayRoom();
			} else if (OptionBySelectByUser == Hoteloptions.AddBooking) {

				AddBooking();
			} else if (OptionBySelectByUser == Hoteloptions.DeleteBooking) {
				System.out.println("....Welcome to Hotel Tajmhal...." + "\n");
				System.out.println("Enter the Name to DeleteBooking");
				s.nextLine();
				String UND = s.nextLine();
				DeleteBooking(UND);
			} else if (OptionBySelectByUser == Hoteloptions.SearchReservation) {
				System.out.println("....Welcome to Hotel Tajmhal...." + "\n");
				System.out.println("Enter the Name to SearchBooking");
				s.nextLine();
				String UNS = s.nextLine();
				SearchReservation(UNS);
			} else if (OptionBySelectByUser == Hoteloptions.EditBooking) {
				System.out.println("....Welcome to Hotel Tajmhal...." + "\n");
				System.out.println("Enter the Name ");
				s.nextLine();
				String UN = s.nextLine();
				EditBooking(UN);
			} else if (OptionBySelectByUser == Hoteloptions.Exit) {

				File F = new File(
						"C:\\Users\\Admin\\eclipse-workspace\\HotelReservationSyatem\\src\\HotelMangement\\HotelData.txt");

				FileWriter FW = new FileWriter(F, false);

				BufferedWriter BW = new BufferedWriter(FW);

				for (Hotel h : AL) {
					BW.write(h.Name + "," + h.Room_Size + "," + h.Parsons + "," + h.Days + "," + h.Adhar_NO + "\n");
				}

				BW.close();
				FW.close();
				F = null;

				System.out.println(">>... Program Closed ! ...<<");
				CanIKeepRunningTheProgram = false;
			}

		}
	}

	public static void EditBooking(String Name) {
		Scanner S = new Scanner(System.in);
		for (Hotel H : AL)
			if (H.Name.equalsIgnoreCase(Name)) {
				System.out.println(">>>....WLCOME TO Hotel....<<< " + "\n");
				System.out.println("Enter the Name :");

				H.Name = S.nextLine();
				System.out.println("Enter the Room Size" + "\n" + "1.Single Room" + "\n" + "2.Double Room" + "\n"
						+ "3.Family Room");
				H.Room_Size = S.nextLine();
				System.out.println("Enter the how many parson");
				H.Parsons = S.nextLine();
				System.out.println("Enter the no. of Days");
				H.Days = S.nextLine();
				System.out.println("Enter the Adhar_No :");
				H.Adhar_NO = S.nextLine();
				int optionselectbyuser = S.nextInt();
				RoomOptions RC = new RoomOptions();
				if (optionselectbyuser == RoomOptions.SingleRoom) {
					System.out.println("Price of Rooom = 1000");

				} else if (optionselectbyuser == RoomOptions.DoubleRoom) {
					System.out.println("Price of Room  = 2000");

				} else if (optionselectbyuser == RoomOptions.FamilyRoom) {
					System.out.println("Price of Room  = 3500");

				}
				System.out.println("Your room has been booked...\n");

				return;
			}
	}

	public static void SearchReservation(String Name) {

		for (Hotel H : AL)
			if (H.Name.equalsIgnoreCase(Name)) {
				System.out.println("Name" + H.Name);
				System.out.println("Room_Size" + H.Room_Size);
				System.out.println("Parsons" + H.Parsons);
				System.out.println("Days" + H.Days);
				System.out.println("Adhar_No" + H.Adhar_NO);

				System.out.println("\n");
			}

	}

	public static void DeleteBooking(String Name) {
		Iterator<Hotel> IU = AL.iterator();
		while (IU.hasNext()) {
			Hotel H = IU.next();
			if (H.Name.equalsIgnoreCase(Name)) {
				IU.remove();
				System.out.println(H.Name + " has been deleted");
				Roomavailable++;
			}
		}

	}

	public static void AddBooking() {
		int i;
		Scanner S = new Scanner(System.in);
		Hotel H = new Hotel();
		System.out.println(">>>....WLCOME TO Hotel....<<< " + "\n");
		System.out.println("Enter the Name :");

		H.Name = S.nextLine();
		System.out.println(
				"Enter the Room Size :" + "\n" + "1.Single Room" + "\n" + "2.Double Room" + "\n" + "3.Family Room");
		int optionselectbyuser = S.nextInt();
		if (optionselectbyuser == RoomOptions.SingleRoom) {
			System.out.println("Price of Rooom = 1000");

		} else if (optionselectbyuser == RoomOptions.DoubleRoom) {
			System.out.println("Price of Room  = 2000");

		} else if (optionselectbyuser == RoomOptions.FamilyRoom) {
			System.out.println("Price of Room  = 3500");
		}
		
		System.out.println("Enter the how many parson :");
		S.nextLine();
		H.Parsons = S.nextLine();
		System.out.println("Enter the no. of Days :");
		H.Days = S.nextLine();
		System.out.println("Enter the Adhar_No :");
		H.Adhar_NO = S.nextLine();

		System.out.println("Your room has been booked...\n");

		Roomavailable--;
		AL.add(H);

	}

	public static void DisplayRoom() {
		System.out.println(">>>....WLCOME TO Hotel....<<< ");
		System.out.println("Current Rooms are available =" + Roomavailable);
	}

	public static void MemoryReaders() throws IOException {
		File F = new File(
				"C:\\Users\\Admin\\eclipse-workspace\\HotelReservationSyatem\\src\\HotelMangement\\HotelData.txt");

		FileReader FR = new FileReader(F);

		BufferedReader BR = new BufferedReader(FR);

		String Line;

		while ((Line = BR.readLine()) != null) {
			Hotel H = new Hotel();

			String[] arraylist = Line.split(",");
			if (arraylist.length > 4) {
				H.Name = arraylist[0];
				H.Room_Size = arraylist[1];
				H.Parsons = arraylist[2];
				H.Days = arraylist[3];
				H.Adhar_NO = arraylist[4];
               
				AL.add(H);
			}
		}
	}
}
