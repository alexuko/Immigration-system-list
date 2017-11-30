package visitorListInImmigrationDepartment;

public class Person {
	private int id;
	private static int lastId;
	private String firstName;
	private String lastName;
	private String dateOfArrival;
	private int passport;
	
	
	public Person(String firstName, String lastName, String dateOfArrival, int passport) {
		this.id = 100 + lastId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfArrival = dateOfArrival;
		this.passport = passport;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDateOfArrival() {
		return dateOfArrival;
	}


	public void setDateOfArrival(String dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}


	public int getPassport() {
		return passport;
	}


	public void setPassport(int passport) {
		this.passport = passport;
	}


	public int getId() {
		return id;
	}
}

