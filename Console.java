package visitorListInImmigrationDepartment;


import java.util.Scanner;


public class Console {
Scanner in = new Scanner(System.in);


public void optionSelection(){
	System.out.println("\t--- Department of Immigration ---\n");
	System.out.println("Select one of the following options:\n");
	System.out.println(" 1) Add a new person ");
	System.out.println(" 2) View person position in the queue.");
	System.out.println(" 3) Person with a kid under 1 year old.");
	System.out.println(" 4) Decrease row length.");
	System.out.println(" 5) Update person.\t");
	mainMenu(); 
	}


public int mainMenu(){
	int inNum = in.nextInt();
	switch (inNum){
	case 1:
		addPerson();
		break;
	case 2:
		System.out.println("View position");
		break;
	case 3:
		System.out.println("Person with a newborn");
		break;
	case 4:
		System.out.println("Decrease length");
		break;
	case 5:
		System.out.println("Upadate person data");
		break;
	default:
		System.out.println(inNum + ": Is not a valid selection");	
		break;

	}
		return inNum;
	
}
public void addPerson(){
		
		System.out.println(in.nextLine());
		System.out.println("Type first name:\t");
		String firstName =  in.nextLine();
		System.out.println("\nType last name:\t");
		String lastName =  in.nextLine();
		System.out.println("Type a date:\t");
		String date=  in.nextLine();
		System.out.println("Type passport number:\t");
		int passport =  in.nextInt();
		
	Person human = new Person(firstName,lastName,date,passport);
	System.out.println("You have registered the following person:\t");
	System.out.println("Id: "		 + human.getId() +
					   "\nName: "  	 + human.getFirstName() + 
					   "\nSurname: " + human.getLastName()+
					   "\nDate: "	 + human.getDate()+
					   "\nPassport: "+ human.getPassport()
					   );
	optionSelection();
}

}
