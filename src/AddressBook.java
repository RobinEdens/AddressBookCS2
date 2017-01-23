/**
 * AddressBook to store and manipulate objects of the ExtPerson type in the format of an address book. Allows search, grabbing info
 * printing all info, printing by birthday, and printing by status
 * @author Robin A.
 */
import java.util.Scanner;
public class AddressBook {
	private ExtPerson[] peopleList = new ExtPerson[10];
	private int filledArray;
	
	/**
	 * Default constructor
	 */
	public AddressBook() {
		
	}
	
	/**
	 * Overload constructor to set array
	 * @param addressBook
	 */
	public AddressBook(ExtPerson[] addressBook) {
		setPeopleList(addressBook);
	}
	
	/**
	 * @return the peopleList array
	 */
	public ExtPerson[] getPeopleList() {
		return peopleList;
	}

	/**
	 * Sets the ExtPerson array in Address Book with the values passed to it; might have had confusion with the "can store 10 values but only set 7" part, so apologies
	 * if this is not what you meant
	 * @param list
	 */
	public void setPeopleList(ExtPerson [] list) {
		for (int i = 0; i < list.length; i++) {
			if (i < peopleList.length) {
					peopleList[i] = list[i];
					filledArray = i + 1;
			} else {
				System.out.println("Only room for 10 entries in address book. Stopping at 10th entry");
				return;
			}
		}	
	}

	/**
	 * Prints the menu to show/remind users of valid choices
	 */
	public void showMenu() {
		  System.out.println("\nWelcome to the address book program."
		  		+ "\nChoose among the following options:"
		  		+ "\n1: To see if a person is in the address book"
		  		+ "\n2: Print the information of a person"
		  		+ "\n3: Print the names of person having birthday in a particular month"
		  		+ "\n4: Print the names of persons having a particular status"
		  		+ "\n5: Print the address book"
		  		+ "\n9: Terminate the program\n"
		  		);
	}
	
	/**
	 * Searches through the ExtPerson array to find any objects with proper first/last name fields; returns a null object if none are found. Doing it this way made it
	 * easier for code reuse with the getPersonInfo method
	 * @param fName - first name to search
	 * @param lName - last name to search
	 */
	public ExtPerson searchAddressBook (String fName, String lName) {
		for (int i = 0; i < filledArray; i++) {
			if (fName.toLowerCase().equals(peopleList[i].getfName().toLowerCase()) && lName.toLowerCase().equals(peopleList[i].getlName().toLowerCase())) {
				return peopleList[i];
			}
		}
		return null;
	}
	
	/**
	 * Prints toString method for a valid ExtPerson object passed from called searchAddressBook method
	 * @param fName - first name to search
	 * @param lName - last name to search
	 */
	public void getPersonInfo(String fName, String lName) {
		ExtPerson getPerson = searchAddressBook(fName, lName);
		if (getPerson != null) {
			System.out.println(getPerson);
		} else {
			System.out.println("Person not found in address book. Try again with a vaild entry");
		}
	}
	
	/**
	 * Prints toString method of any ExtPerson object that has the same month stored as passed month
	 * @param month - passed month
	 */
	public void printBirthdayList(int month) {
		boolean oneBirth = false;
		for (int i = 0; i < filledArray; i++) {
			if (peopleList[i].getBday().getMonth() == month) {
				System.out.println(peopleList[i]);
				oneBirth = true;
			}
		}
		if (!oneBirth) {
			System.out.println("No one with a birthdate for that month");
		}
	}
	
	/**
	 * Prints toString method of any ExtPerson object that has the same status as passed status
	 * @param status - Status of person in Address book; valid ones could be F for family, f for friend, B for business, E for enemy
	 */
	public void printStatusList(char status) {
		boolean isStatus = false;
		for (int i = 0; i < filledArray; i++) {
			if (peopleList[i].getStatus() == status) {
				System.out.println(peopleList[i]);
				isStatus = true;
			}
		}
		if(!isStatus) {
			System.out.println("No one matching that particular status");
		}
	}
	
	/**
	 * Prints the toString method of every item stored in address book
	 */
	public void printAll() {
		for (ExtPerson s: peopleList) {
			if (s != null) {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * Main method. Instead of calling items directly from itself, it instantiates itself to be used throughout, as to make AddressBook dynamic and allow to be used as a
	 * standalone ADT
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		// Might have misinterpreted the instructions, but it mentioned having the ability to process 10 entries but only have 7 for the example, so the private
		// ExtPerson array above allows up to 10, while the temp array here is to pass along the 7 values in a quick manner. Assuming this is what you meant but too late to ask
		ExtPerson[] filledList = {
					new ExtPerson("John", "Carmack", 8, 20, 1970, "None", new Address("3819 Town Crossing", "Mesquite", "TX", 75150), 'B'),
					new ExtPerson("John", "Romero", 10, 28, 1967, "None", new Address("3819 Town Crossing", "Mesquite", "TX", 75150), 'B'),
					new ExtPerson("American", "McGee", 12, 13, 1972, "None", new Address("1146 YanAn West Road", "Shanghai", "China", 200050), 'E'), 
					new ExtPerson("Tom", "Hall", 9, 2, 1964, "None", new Address("3819 Town Crossing", "Mesquite", "TX", 75150),'B'),
					new ExtPerson("Warren", "Spector", 10, 2, 1955, "None", new Address("1717 W 6th St Ste 210", "Austin", "TX", 78703), 'f'),
					new ExtPerson("Cliff", "Bleszinski", 2, 12, 1975, "None", new Address("620 Crossroads Blvd", "Cary", "NC", 27518), 'f'),
					new ExtPerson("Robin", "Walker", 2, 1, 1976, "None", new Address("PO Box 1688", "Bellevue", "WA", 98009), 'F') 
					};
		AddressBook address = new AddressBook(filledList);
		int menuOption = 0; 
		while (menuOption != 9) {
			address.showMenu();
			menuOption = userInput.nextInt();
			switch (menuOption) {
			case 1:
				System.out.println("Please enter the first and last name of the person you are searching:");
				ExtPerson checkName = address.searchAddressBook(userInput.next(), userInput.next());
				if (checkName != null) {
					System.out.format("%s %s is in the address book!\n", checkName.getfName(), checkName.getlName());
				} else {
					System.out.println("Not found in address book");
				}
				break;
			case 2:
				System.out.println("Who's information would you like? Enter their first name and last name");
				address.getPersonInfo(userInput.next(), userInput.next());
				break;
			case 3:
				int birthSearch = 0;
				while (birthSearch == 0) {
					System.out.println("Which birth month would you like to search for? Enter as a number.");
					birthSearch = (userInput.hasNextInt()) ? userInput.nextInt(): 0;
					if (birthSearch < 1 || birthSearch > 12) {
						System.out.println("Please enter a valid birth month as a number");
						birthSearch = 0;
					}
				}
				address.printBirthdayList(birthSearch);
				break;
			case 4:
				System.out.println("Which status would you like to search?");
				address.printStatusList(userInput.next().charAt(0));
				break;
			case 5:
				address.printAll();
				break;
			case 9:
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid selection. Please try again");				
			}
			userInput.nextLine();
		}
		userInput.close();
	}
}