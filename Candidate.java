package visitorListInImmigrationDepartment;

/**
 * The class represents a Candidate for Link List for Immigration department.
 * The class includes constructor that requires the data to create the object
 * and methods to show details of the Candidate
 * 
 *
 * @author Pedro Alberto Duenas Orozco
 * @author Roberto Alejandro Rivera Mejia
 */

public class Candidate {

	private int candidateNumber; // Candidate number
	private static int lastId; 
	private String candidateFirstName; // Candidate firstName
	private String candidateLastName; // Candidate last Name
	private String candidateArrivalDate; // Candidate date
	private String candidatePassportNo; // Candidate passport name
	private boolean kidLess3; // if candidate has a kid less than 3 years
	private boolean kidLess1; // if candidate has a kid less than 1 year
	public Candidate nextCandidate; // next Candidate on the list
	public Candidate pastCandidate; // next Candidate on the list

	/**
	 * Candidate constructor create and insert a new candidate to the LinkedList
	 * 
	 * @param candidateNumber
	 *            integer ID of user
	 * @param candidateFirstName
	 *            String candidate first name
	 * @param candidateLastName
	 *            String candidate last name
	 * @param candidateArrivalDate
	 *            String arrival date of the candidate to the country
	 * @param candidatePassportNo
	 *            String passport number or code of the candidate
	 * @param kidLess3
	 *            boolean true if candidate has a kid less than 3 years old
	 * @param KidLess1
	 *            boolean true if candidate has a kid less than 1 years old
	 * 
	 */
	// constructor to initialize the candidate class
	public Candidate(String candidateFirstName, String candidateLastName,
			String candidateArrivalDate, String candidatePassportNo, boolean kidLess3, boolean kidLess1) {
		this.candidateNumber = 100 + lastId++;
		this.candidateFirstName = candidateFirstName;
		this.candidateLastName = candidateLastName;
		this.candidateArrivalDate = candidateArrivalDate;
		this.candidatePassportNo = candidatePassportNo;
		this.kidLess3 = kidLess3;
		this.kidLess1 = kidLess1;
	}

	/**
	 * showDetails method Print on screen a all the candidate details for a list
	 * view
	 * 
	 * @param position
	 *            position of the candidate in the list to be print as list
	 */
	public void showDetails(int position) {

		System.out.printf("%9s | %-5s| %-15s| %-15s| %-15s| %-15s| %-10s| %-10s|", position, candidateNumber,
				candidateFirstName, candidateLastName, candidateArrivalDate, candidatePassportNo, kidLess3, kidLess1);
	}

	/**
	 * showDetails method Print on screen a all the candidate details for a simple
	 * view
	 */
	public void showDetails() {

		System.out.printf("\nID number : " + candidateNumber + "\nfirst name : " + candidateFirstName + "\nlast name : "
				+ candidateLastName + "\n arrival date : " + candidateArrivalDate + "\npassport number : "
				+ candidatePassportNo + "\n Kid less than 3 yo : " + kidLess3 + "\n Kid less than 1 yo : " + kidLess1);
	}

	public String getCandidateFirstName() {
		return candidateFirstName;
	}

	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}

	public String getCandidateLastName() {
		return candidateLastName;
	}

	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}

	public String getCandidateArrivalDate() {
		return candidateArrivalDate;
	}

	public void setCandidateArrivalDate(String candidateArrivalDate) {
		this.candidateArrivalDate = candidateArrivalDate;
	}

	public String getCandidatePassportNo() {
		return candidatePassportNo;
	}

	public void setCandidatePassportNo(String candidatePassportNo) {
		this.candidatePassportNo = candidatePassportNo;
	}

	public int getCandidateNumber() {
		return candidateNumber;
	}

	
	
}
