
/**
This class represents a phone.
@author Keri Fulton 3616473
*/
public class Phone implements Comparable<Phone>{
	/**Instance variable for the name*/
	private String name;
	/*Instance variable for phone number*/
	private String phoneNumber;
	
	/**
	This constructor represents a phone object.
	@param name the owner of the phone number
	@param phoneNumber the phone number. 
	*/
	public Phone(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	/**
	This method returns the name of the phone number owner.
	@return the name of the phone number owner. 
	*/
	public String getName(){
		return name;
	}
	/**
	This method returns the phone number from the phone object.
	@return the phone number. 
	*/
	public String getNumber(){
		return phoneNumber;
	}
	/**
	This methods compares two phone objects and returns an integer, negative if the object name is less than the name in the parameter, 0 if the names are the same, and a postive number if the object name is more than the name in the parameter.
	@return a integer value based on comparison. 
	*/
	@Override
	public int compareTo(Phone other){
		int result = this.name.compareToIgnoreCase(other.name);
		if(result == 0){
			result = this.phoneNumber.compareTo(other.phoneNumber);
			if(result > 0){
				result = 1;
			}
			else if(result< 0){
				result = -1;
			}
			else{
				result = 0;
			}
		}	
		return result;
	}

	
}
