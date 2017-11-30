package visitorListInImmigrationDepartment;

public class Person {
	private int id;
	private static int lastId;
	private String firstName;
	private String lastName;
	private String date;
	private int passport;
	
	public Person(String firstName, String lastName, String date, int passport) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.passport = passport;
		id = 150 + lastId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public static int getLastId() {
		return lastId;
	}

	public static void setLastId(int lastId) {
		Person.lastId = lastId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPassport() {
		return passport;
	}

	public void setPassport(int passport) {
		this.passport = passport;
	}

}
