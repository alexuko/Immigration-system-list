package visitorListInImmigrationDepartment;
import java.util.Scanner;

/**
 * The class represents a Console for Link List for Immigration department. It
 * display a simple and user-friendly console interface for manage the
 * candidates in a list
 *
 * @author Pedro Alberto Duenas Orozco
 * @author Roberto Alejandro Rivera Mejia
 */

public class Console {
	Scanner in = new Scanner(System.in);
	int candidateNumber = 101;
	LinkedList LinkedList = new LinkedList();

	public Console() {
		
		System.out.println("\n"
 + "\nooooo       o88               o8         o                            "
 +"\n888        oooo   oooooooo8  o888oo     888    ooooooooo  ooooooooo   "
 +"\n888         888  888ooooooo   888      8  88    888    888 888    888 "
 +"\n888         888          888  888     8oooo88   888    888 888    888 "
+"\no888ooooo88 o888o 88oooooo88   888o o88o  o888o 888ooo88   888ooo88   "
+"\n                                                o888       o888  ");
		
		LinkedList.insertCandidate("Alex".toUpperCase(), "Rivera".toUpperCase(), "14/14/13", "252536", false, false);
		LinkedList.insertCandidate("albert".toUpperCase(), "Orozco".toUpperCase(), "15/12/17", "252986", false, false);
		LinkedList.insertCandidate("Camila".toUpperCase(), "andrade".toUpperCase(), "14/14/14", "879478", false, false);
		LinkedList.insertCandidate("Pedro".toUpperCase(), "Duenad".toUpperCase(), "14/12/15", "481574", false, false);
		LinkedList.insertCandidate("Roberto".toUpperCase(), "Mejia".toUpperCase(), "01/11/16", "123456", false, false);
		LinkedList.insertCandidate("Jose".toUpperCase(), "Rivera".toUpperCase(), "14/14/13", "252536", false, false);
		LinkedList.insertCandidate("Silver".toUpperCase(), "Orozco".toUpperCase(), "15/12/17", "252986", false, false);
		LinkedList.insertCandidate("Kasia".toUpperCase(), "andrade".toUpperCase(), "14/14/14", "879478", false, false);
		LinkedList.insertCandidate("Juanito".toUpperCase(), "Duenas".toUpperCase(), "14/12/15", "481574", true, false);
		LinkedList.insertCandidate("marcelo".toUpperCase(), "Mejia".toUpperCase(), "01/11/16", "123456", false, true);
	
		mainMenu();
	}
	
	
	
	

	/**
	 * mainMenu method first access of the console to the menu by printing the
	 * available options in the System
	 */
	public void mainMenu() {
		System.out.println("\n--- Department of Immigration ---\n");
		System.out.println("Select one of the following options:\n");
		System.out.println(" 1) Add a new candidate to the last position");
		System.out.println(" 2) Remove first candidate of the list.");
		System.out.println(" 3) Add a new candidate by position.");
		System.out.println(" 4) View list of candidates.");
		System.out.println(" 5) View candidate position by name.");
		System.out.println(" 6) View candidate position by ID.");
		System.out.println(" 7) Remove candidate by ID.");
		System.out.println(" 8) Remove candidate by position.");
		System.out.println(" 9) Cut off list of candidates");
		System.out.println(" 10) Update candidate details.");
		String option = in.nextLine();
		while (option.matches("[0-9]|10") == false) {
			System.out.println(option + " is not a valid selection\n Try again");
			option = in.nextLine();
		}
		int inNum = Integer.parseInt(option);
		switch (inNum) {
		case 1:
			System.out.println("\n\n 1) Add a new candidate to the last position");
			addPerson(false);
			break;
		case 2:
			System.out.println("\n\n 2) Remove first candidate of the list.");
			LinkedList.removeFirstCandidate();
			backMainMenu();
			break;
		case 3:
			System.out.println("\n\n 3) Add a new candidate by position.");
			addPerson(true);
			break;
		case 4:
			System.out.println("\n\n 4) View List.");
			LinkedList.display();
			backMainMenu();
			break;
		case 5:
			System.out.println("\n\n 5) View candidate position by name.");
			System.out.println("\n\nType name of candidate to search.");
			String findName = in.nextLine();
			LinkedList.findByName(findName.toUpperCase());
			backMainMenu();
			break;
		case 6:
			System.out.println("\n\n 6) View candidate position by ID.");
			System.out.println("\nType ID of candidate to search.");
			String findID = in.nextLine();
			while (findID.matches("^\\d*[0-9]\\d*$") == false) {
				System.out.println(findID + " is not a valid ID\n Try again");
				findID = in.nextLine();
			}
			LinkedList.findByID(Integer.parseInt(findID));
			backMainMenu();
			break;
		case 7:
			System.out.println("\n\n 7) Remove candidate by ID.");
			LinkedList.display();
			System.out.println("\nType ID of candidate to remove.");
			String removeID = in.nextLine();
			while (removeID.matches("^\\d*[0-9]\\d*$") == false) {
				System.out.println(removeID + " is not a valid ID\n Try again");
				removeID = in.nextLine();
			}
			LinkedList.removeCandidateByID(Integer.parseInt(removeID));
			backMainMenu();
			break;
		case 8:
			System.out.println("\n\n 8) Remove candidate by position.");
			LinkedList.display();
			System.out.println("\n\nType position of candidate to remove. current size of list: " + LinkedList.size);
			String removePosition = in.nextLine();
			while (removePosition.matches("^\\d*[0-9]\\d*$") == false) {
				System.out.println(removePosition + " is not a valid ID\n Try again");
				removePosition = in.nextLine();
			}
			LinkedList.removeCandidateByPosition(Integer.parseInt(removePosition));
			backMainMenu();
			break;
		case 9:
			System.out.println("\n\n 9) Cut off list");
			LinkedList.display();
			System.out
					.println("\n\nType number of candidates to remove from the back of the list, current size of list: "
							+ LinkedList.size);
			String cutOffNum = in.nextLine();
			while (cutOffNum.matches("^\\d*[0-9]\\d*$") == false) {
				System.out.println(cutOffNum + " is not a valid ID\n Try again");
				cutOffNum = in.nextLine();
			}
			LinkedList.cutoffCandidates(Integer.parseInt(cutOffNum));
			backMainMenu();
			break;
		case 10:
			
			System.out.println("\n\n 10) Update Candidate ");
			//LinkedList.display();
			if(LinkedList.isEmpty()!=true){

			LinkedList.display();
			System.out.println("\n\nType id of candidate to update." );
			String idToUpdate = in.nextLine();
			while (idToUpdate.matches("^\\d*[0-9]\\d*$") == false||LinkedList.findByIDBoolean(Integer.parseInt(idToUpdate))==false) {
				
				System.out.println(idToUpdate + " is not a valid ID\n Try again");
				idToUpdate = in.nextLine();
			
			}
			updateAcandidate(Integer.parseInt(idToUpdate));
			}else{
				System.out.println("\n\nNo candidates on the list");
					
			}
			backMainMenu();
			break;
		default:
			System.out.println(inNum + ": Is not a valid selection");
			backMainMenu();
			break;

		}

	}
  
	/**
	 * addPerson method gather the data needed to create and insert a new person to
	 * the linked list
	 * 
	 * @param position
	 *            boolean when true the method display for input the position for
	 *            the new candidate
	 */
	public void addPerson(boolean position) {
		boolean kidLess1 = false;
		boolean kidLess3 = false;
		int positionList = 0;
		
		System.out.println("\nType first name:");
		String firstName = inputAnyData();
		System.out.println("\nType last name:");
		String lastName = inputAnyData();
		System.out.println("\nType a arrival date:");
		String date = inputAnyData();
		System.out.println("\nType passport number:");
		String passport = inputAnyData();
		System.out.println("\nDoes candidate have a kid lees than 1 year old?  Y / N");
		String kid1 = in.nextLine();
		while (kid1.matches("[yYnN]") == false) {
			System.out.println(kid1 + " is not a valid selection. Try again");
			kid1 = in.nextLine();
		}
		if (kid1.equals("y") || kid1.equals("Y")) {
			kidLess1 = true;
		} else if (kid1.equals("n") || kid1.equals("N")) {
			System.out.println("\nDoes candidate have a kid lees than 3 year old? Y / N");
			String kid3 = in.nextLine();
			while (kid3.matches("[yYnN]") == false) {
				System.out.println(kid1 + " is not a valid selection. Try again");
				kid3 = in.nextLine();
			}
			if (kid3.equals("y") || kid3.equals("Y")) {
				kidLess3 = true;
			}
		}
		if (position == true) {

			System.out.println("\nPosition in the list, current size of the list:" + LinkedList.size);
			String option = in.nextLine();
			while (option.matches("[1-9]") == false) {
				System.out.println(option + " is not a valid selection\n Try again");
				option = in.nextLine();

			}

			positionList = Integer.parseInt(option);
			Candidate newCandidate = LinkedList.insertCandidate( firstName.toUpperCase(), lastName.toUpperCase(), date, passport,
					kidLess3, kidLess1, positionList);
			System.out.println("\nYou have registered the following person:");
			newCandidate.showDetails();
			candidateNumber++;
			backMainMenu();
		}

		Candidate newCandidate = LinkedList.insertCandidate( firstName.toUpperCase(), lastName.toUpperCase(), date, passport,
				kidLess3, kidLess1);
		System.out.println("\nYou have registered the following person:");
		newCandidate.showDetails();
		candidateNumber++;
		backMainMenu();
	}
	/**
	 * updateAcandidate method gather the data needed to update an existing Candidate in  the linked list
	 * without affecting their position in the list
	 * 
	 * @param candidateNumber
	 *            takes this parameter to find the person ID within the linked list
	 *            gathering all of their data related with the ID selected and then 
	 *            updating the data
	 */
	public void updateAcandidate(int candidateNumber) {
		Candidate tempCandidate = LinkedList.findByID(candidateNumber);
		String tempValue;
		
		System.out.println("\n\nType in The new First name");
		tempValue = inputAnyData();	
		tempCandidate.setCandidateFirstName(tempValue.toUpperCase());
		
		System.out.println("\nType in The new Last name");
		tempValue = inputAnyData();	
		tempCandidate.setCandidateLastName(tempValue.toUpperCase());
		
		System.out.println("\nType in The new Arrival Date");
		tempValue = inputAnyData();	
		tempCandidate.setCandidateArrivalDate(tempValue);
		
		System.out.println("\nType in The new Passport");
		tempValue = inputAnyData();	
		tempCandidate.setCandidatePassportNo(tempValue);
		
		System.out.println("\nCandidate Succesfully updated.");

		
		}
	
	/**
	 * backMainMenu method return to the main menu  by typing any key.
	 * 
	 */
	public void backMainMenu() {
		System.out.println("\n\n\nPress ENTER key to go back to main menu");
		String any = in.nextLine();
		if (any != null) {
			//System.out.println("\n\n\n");
			for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("\f");
			mainMenu();
		}

	}
	
	
	/**
	 * inputAnyData method check that user input something and return a string.
	 * 
	 */
	public String inputAnyData(){
		
		String tempValue = in.nextLine();
		while (tempValue.equals("")) {
			System.out.println(" It is not a valid input, Type something, Please");
			tempValue = in.nextLine();
		}
		return tempValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubw
		new Console();
	}

}
