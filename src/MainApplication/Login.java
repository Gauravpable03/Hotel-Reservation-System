package MainApplication;
import java.io.IOException;
import java.util.Scanner;
import UserMangement.Usermangement;
import HotelMangement.Hotelmangement;
public class Login {
	public static void main (String args []) throws IOException{
		Scanner s = new Scanner (System.in);
		boolean CanIkeepRunningTheProgram = true ;
		System.out.println("Enter Your Login ID :");
		String Login = s.nextLine();
		System.out.println("Enter the Your Password");
		String Password = s.nextLine();
		if(!Usermangement.LoginProcess(Login, Password)) {
			System.out.println("Login Failed..! ");
			return;
		}
		while(CanIkeepRunningTheProgram) {
			System.out.println(">.>.>.>..WELCOME TO TAJMAHAL HOTEL..<.<.<.<");
			System.out.println("1.UserMangement");
			System.out.println("2.HotelMangement");
			System.out.println("3.Exit");
			
			int OptionSelectbyUser = s.nextInt();
			if(OptionSelectbyUser == 1) {
				Usermangement.Usermangement();			    
				
			}else if (OptionSelectbyUser==2) {
				Hotelmangement.HotelMAngement();
			}else if(OptionSelectbyUser==3) {
				System.out.println("\n"+">>... Program Closed ! ...<<");
				CanIkeepRunningTheProgram = false ;
			}
				
		}
		
		
	}

}
