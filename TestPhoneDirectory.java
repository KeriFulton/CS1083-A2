import java.util.Scanner;
/**
This class is a driver for the Phone Directory.
@author Keri Fulton 3616473
*/
public class TestPhoneDirectory{
	public static void main(String[]args){
		//ADDING PHONES INTO THE PHONE DIRECTORY THROUGH CONSTRUCTOR
		Scanner scan = new Scanner(System.in);
		PhoneDirectory directory = new PhoneDirectory(scan);
		directory.sortDirectory(true);
		System.out.println("Phone Directory sorted in ASCENDING order:\n");
		String print = directory.printDirectory();
		System.out.println(print);
		boolean found = true;
		String temp = scan.nextLine();
		//SEARCHING BY NAME TEST
		System.out.println("Searching Phone Directory by name:\n");
		while(found){
			String name = temp;
			String print2 = directory.searchByName(name);
			System.out.println(print2);
			temp = scan.nextLine();
			if(temp.equalsIgnoreCase("searchbynumber")){
				found = false;
			}
		}
		//SEARCHING BY NUMBER TEST
		String temp2 = scan.nextLine();
		System.out.println("Searching Phone Directory by number:\n");
		boolean found2 = true;
		while(found2){
			String num = temp2;
			String print3 = directory.searchByNumber(num);
			System.out.println(print3);
			temp2 = scan.nextLine();
			if(temp2.equalsIgnoreCase("addphone")){
				found2 = false;
			}
		}
		//ADDING PHONE TEST 
		System.out.println("Adding a new Phone to the Phone Directory:\n");
		boolean found3 = true;
		String temp3 = scan.nextLine();
		while(found3 && scan.hasNext()){
			Scanner scan2 = new Scanner(temp3);
			scan2.useDelimiter(",");
			String name2 = scan2.next();
			String phoneNumber = scan2.next();
			Phone obj2 = new Phone(name2, phoneNumber);
			String print4 = directory.addPhone(obj2);
			System.out.println(print4);
			temp3 = scan.nextLine();
			if(temp3.equalsIgnoreCase("removephone")){
				found3 = false;
			}
		}
		//SORTING THE NEW DIRECTORY AND PRINTING NEW DIRECTORY
		String print5 = directory.printDirectory();
		System.out.println(print5);
		//REMOVING PHONE TEST
		boolean found4 = true;
		String temp4 = scan.nextLine();
		while(found4){
			String num2 = temp4;
			String print6 = directory.removePhone(num2);
			System.out.println(print6);
			if(!scan.hasNextLine()){
				found4 = false;
			}
			else{
			temp4 = scan.nextLine();
			}
		}
		//SORTING NEW DIRECTORY AND PRINTING NEW DIRECTORY
		directory.sortDirectory(true);
		String print7 = directory.printDirectory();
		System.out.println(print7);
		//SORTING DIRECTORY IN DESCENDING ORDER	
		directory.sortDirectory(false);
		System.out.println("Phone Directory sorted in DESCENDING order:\n");
		String print8 = directory.printDirectory();
		System.out.println(print8);
		

	}
}
