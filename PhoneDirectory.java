import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
This class represents a phone directory.
@author Keri Fulton 3616473
*/
public class PhoneDirectory{
	
	ArrayList<Phone> phoneDirectory = new ArrayList<>();

	
	public PhoneDirectory(Scanner scan){
		while(scan.hasNext()){
			String line = scan.nextLine();
			Scanner scan2 = new Scanner(line);
			scan2.useDelimiter(",");
			String name = scan2.next();
			if(name.equalsIgnoreCase("searchbyname")){
				break;
			}
			String phoneNumber = scan2.next();
			Phone obj = new Phone(name, phoneNumber);
			boolean found = false;
			for(int i = 0; i< phoneDirectory.size() ; i++){
				if(obj.getNumber().compareTo(phoneDirectory.get(i).getNumber()) == 0){
					System.out.println("\n" + phoneNumber + " already exists in the phone directory!\n");
					found = true;
				}
			}
			if(found == false){
				phoneDirectory.add(obj);
			}
			
			

		 }
	}
	
	public void sortDirectory(boolean value){
		SortClass sortObj = new SortClass();
		sortObj.sort(phoneDirectory, value);
	
		
	}
	public String searchByNumber(String number){
		boolean found = false;
		String result = "Searching for " + number + "\n";

		for(int i =0; i< phoneDirectory.size(); i++){
			int compared = number.compareTo(phoneDirectory.get(i).getNumber());
			if(compared == 0){
				result += "Name                             Phone Number\n";
				result += "----------------------------------------------\n";
				Phone phone3 = phoneDirectory.get(i);
				String num = phone3.getNumber();
				String phoneNum = num.substring(0,3) + '-' + num.substring(3,6) + '-' + num.substring(6,10);
				result += phoneDirectory.get(i).getName() + "\t\t\t " + phoneNum + "\n\n";
				found = true;
			}
		}
		if(found == true){
			result += number + " has been found in the phone directory!\n";
		}
		else{
		        result += number + " doesn't exist in the phone directory!\n";
		}
		return result;
	}
				
		
	public String searchByName(String name){
		String result = "Searching for " + name + "\n";
		boolean found = false;
		int count = 0;

		for(int i =0; i< phoneDirectory.size(); i++){
			int compared = name.compareToIgnoreCase(phoneDirectory.get(i).getName());
			if(compared == 0){
				count++;
				if(count == 1){
				result += "Name                             Phone Number\n";
				result += "----------------------------------------------\n";
				}
				Phone phone1 = phoneDirectory.get(i);
				String num = phone1.getNumber();
				String phoneNum = num.substring(0,3) + '-' + num.substring(3,6) + '-' + num.substring(6,10);
				result += phoneDirectory.get(i).getName() + "\t\t\t " + phoneNum + "\n\n";
				found = true;
			}
		}
		if(found == true){
			result += name + " has been found in the phone directory!\n";
		}
		else{
		        result += name + " doesn't exist in the phone directory!\n";
		}
		return result;
			
	
	}
	
	public String addPhone(Phone phone){
		String result = "Adding a new phone with name: " + phone.getName() + " and number " + phone.getNumber() + "\n";
		for(int i =0; i< phoneDirectory.size(); i++){
			if(phone.getNumber().compareTo(phoneDirectory.get(i).getNumber()) == 0){
				result += phone.getNumber() + " already exists in the phone directory!\n";
				return result;
			}
		}
		phoneDirectory.add(phone);
		sortDirectory(true);
		result += "New phone is inserted in the sorted directory.";
		return result;
		
	}
		
	public  String removePhone(String number) {
		String result = "Trying to remove (" + number + ") from the directory.\n";
		for (int i = 0; i < phoneDirectory.size(); i++) {
			if (phoneDirectory.get(i).getNumber().equalsIgnoreCase(number)){
				phoneDirectory.remove(i);
				return result += "Phone is removed from the directory.";
			}
		}
		result += "The number " +  number + " doesn't exist in the phone directory.";
		return result;
	}
	public String printDirectory(){
		String directory2 = "Name                            Phone Number\n";
		directory2 += "---------------------------------------------\n";
		Iterator<Phone> itr = phoneDirectory.iterator();
		while (itr.hasNext()){
				Phone phone = itr.next();
				String num = phone.getNumber();
				String phoneNum = num.substring(0,3) + '-' + num.substring(3,6) + '-' + num.substring(6,10);
				directory2 += phone.getName() +"\t\t\t" + phoneNum + "\n";
				
		}
		return directory2;
	}
}	
	
		
