package visitorListInImmigrationDepartment;

/**
 * The class represents Linked List for Immigration department. The class
 * includes methods for insert, remove, view any candidate in he list, and the
 * complete list of candidates, also methods that allow to search, and remove
 * candidates by name and id
 * 
 *
 * @author Pedro Alberto Duenas Orozco
 * @author Roberto Alejandro Rivera Mejia
 */
public class LinkedList {
	public Candidate firstCandidate;
	public Candidate lastCandidate;
	public int size;

	public LinkedList() {
		this.firstCandidate = null;
		this.lastCandidate = null;
		size = 0;
	}

	/** isEmpty method check if the LinkedList is empty */
	public boolean isEmpty() {
		return firstCandidate == null && lastCandidate == null;
	}

	/**
	 * insertCandidate method create and insert a new candidate to the LinkedList
	 * WITHOUt specific position
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
	public Candidate insertCandidate(String candidateFirstName, String candidateLastName,
			String candidateArrivalDate, String candidatePassportNo, boolean kidLess3, boolean kidLess1) {
		Candidate newCandidate = new Candidate(candidateFirstName, candidateLastName, candidateArrivalDate, candidatePassportNo, kidLess3, kidLess1);
		if (firstCandidate == null && lastCandidate == null) {
			lastCandidate = newCandidate;
			firstCandidate = newCandidate;
			newCandidate.nextCandidate = null;
			newCandidate.pastCandidate = null;
		} else if (kidLess1 == true) {
			firstCandidate.pastCandidate = newCandidate;
			newCandidate.nextCandidate = firstCandidate;
			firstCandidate = newCandidate;
		} else if (kidLess3 == true && size > 2) {
			Candidate tempNextCandidate = firstCandidate;
			Candidate tempPastCandidate = firstCandidate;

			for (int i = 0; i <= (size / 2) - 1; i++) {
				tempPastCandidate = tempNextCandidate;
				tempNextCandidate = tempNextCandidate.nextCandidate;
			}

			newCandidate.nextCandidate = tempNextCandidate;
			newCandidate.pastCandidate = tempNextCandidate.pastCandidate;
			tempNextCandidate.pastCandidate = newCandidate;
			tempPastCandidate.nextCandidate = newCandidate;

		} else {
			lastCandidate.nextCandidate = newCandidate;
			newCandidate.pastCandidate = lastCandidate;
			lastCandidate = newCandidate;
		}
		size++;
		return newCandidate;
	}

	/**
	 * insertCandidate method create and insert a new candidate to the LinkedList
	 * WITH specific position
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
	 * @param position
	 *            Integer specific position in LinkedList to insert new candidate
	 * 
	 */
	public Candidate insertCandidate( String candidateFirstName, String candidateLastName,
			String candidateArrivalDate, String candidatePassportNo, boolean kidLess3, boolean kidLess1, int position) {
		Candidate newCandidate = new Candidate( candidateFirstName, candidateLastName,
				candidateArrivalDate, candidatePassportNo, kidLess3, kidLess1);
		if (firstCandidate == null && lastCandidate == null) {
			lastCandidate = newCandidate;
			firstCandidate = newCandidate;
			newCandidate.nextCandidate = null;
			newCandidate.pastCandidate = null;
		} else if (size >= position) {
			Candidate tempNextCandidate = firstCandidate;
			Candidate tempPastCandidate = firstCandidate;

			for (int i = 0; i < (position - 1); i++) {
				tempPastCandidate = tempNextCandidate;
				tempNextCandidate = tempNextCandidate.nextCandidate;
			}

			newCandidate.nextCandidate = tempNextCandidate;
			newCandidate.pastCandidate = tempNextCandidate.pastCandidate;
			tempNextCandidate.pastCandidate = newCandidate;
			tempPastCandidate.nextCandidate = newCandidate;
		} else {
			lastCandidate.nextCandidate = newCandidate;
			newCandidate.pastCandidate = lastCandidate;
			lastCandidate = newCandidate;
		}
		size++;
		return newCandidate;
	}

	/** removeFirstCandidate method remove the first candidate of the LinkedList */
	public void removeFirstCandidate() {

		//Candidate tempCandidate = firstCandidate;

		if (size == 1) {
			firstCandidate = null;
			lastCandidate = null;
			size = 0;
			System.out.println("\nFirst Candidates remove from the List");

		} else if (isEmpty() == false) {
			firstCandidate = firstCandidate.nextCandidate;
			firstCandidate.pastCandidate = null;
			size--;
			System.out.println("\nFirst Candidates remove from the List");
		} else {
			System.out.println("\nNo Candidates in the List");
		}

	}

	/**
	 * Display method Print on screen a list of all the candidates of the LinkedList
	 * with details
	 */
	public void display() {
		String vl = "\n_______________________________________________________________________________________________________________\n";

		int position = 1;
		System.out.print(vl + "Candidate Details and Total of Candidates in the list " + size + vl);
		System.out.printf("%9s | %-5s| %-15s| %-15s| %-15s| %-15s| %-10s| %-10s|", "Position", "ID", "FirstName",
				"LastName", "Arrival Date", "Passport Number", "Kid <3yo", "Kid <1yo");
		System.out.print(vl);
		Candidate tempCandidate = firstCandidate;
		while (tempCandidate != null) {
			System.out.println();
			tempCandidate.showDetails(position);
			tempCandidate = tempCandidate.nextCandidate;
			position++;
		}
		if (size == 0) {
			System.out.print("No candidates in the list.");
		}
		System.out.println(vl);

	}

	/**
	 * findByID method search on all the candidates of the LinkedList looking for a
	 * specific ID and returns the Candidate object with details
	 * 
	 * @param candidateNumber
	 *            Integer ID number of the Candidate to search for
	 */
	public Candidate findByID(int candidateNumber) {

		Candidate tempCandidate = firstCandidate;
		boolean found = false;
		int position = 1;

		if (isEmpty() == false) {

			while (tempCandidate != null && found == false) {
				if (tempCandidate.getCandidateNumber() == candidateNumber) {
					found = true;
					System.out.println("\n\nCandidate in position "+position);
					tempCandidate.showDetails();

				} else  {

					tempCandidate = tempCandidate.nextCandidate;
					position++;
				}

			}

		} else {
			System.out.println("No Candidate in the List");
		}

		if (tempCandidate == null && found == false) {
			System.out.println("\n\n\nNo Candidate found in the List with ID " +candidateNumber );

		}


		return tempCandidate;
	}
	/**
	 * findByIDBoolean method search on all the candidates of the LinkedList looking for a
	 * specific ID and returns the a boolean true if it is found.
	 * 
	 * @param candidateNumber
	 *            Integer ID number of the Candidate to search for
	 */
	public boolean findByIDBoolean(int candidateNumber) {

		Candidate tempCandidate = firstCandidate;
		boolean found = false;
		int position = 1;

		if (isEmpty() == false) {

			while (tempCandidate != null && found == false) {
				if (tempCandidate.getCandidateNumber() == candidateNumber) {
					found = true;

				} else {

					tempCandidate = tempCandidate.nextCandidate;
					position++;
				}

			}

		} else {
			System.out.println("No Candidate in the List");
		}

		return found;
	}
	/**
	 * findByName method search on all the candidates of the LinkedList looking for
	 * a specific name and returns the Candidate object with details
	 * 
	 * @param candidateName
	 *            String either first or last Name of the Candidate to search for
	 */
	public Candidate findByName(String candidateName) {

		Candidate tempCandidate = firstCandidate;
		boolean found = false;
		int position = 1;

		if (isEmpty() == false) {

			while (tempCandidate != null && found == false) {
				if (tempCandidate.getCandidateFirstName().contains(candidateName)
						|| tempCandidate.getCandidateLastName().contains(candidateName)) {
					found = true;
					System.out.println("\n\nCandidate in position "+position);
					tempCandidate.showDetails();

				} else {

					tempCandidate = tempCandidate.nextCandidate;
					position++;
				}

			}

		} else {
			System.out.println("\n No Candidate in the list with name :" + candidateName);
		}

		if (tempCandidate == null && found == false) {
			System.out.println("\n No Candidate in the list with name :" + candidateName);

		}
		return tempCandidate;
	}

	public Candidate removeCandidateByID(int candidateNumber) {

		Candidate currentCandidate = firstCandidate;
		Candidate previousCandidate = firstCandidate;
		while (currentCandidate.getCandidateNumber() != candidateNumber) {
			if (currentCandidate.nextCandidate == null) {
				return null;
			} else {
				previousCandidate = currentCandidate;
				currentCandidate = currentCandidate.nextCandidate;
			}
		}

		if (currentCandidate == firstCandidate) {
			firstCandidate = firstCandidate.nextCandidate;
		} else {
			System.out.println("Found");
			previousCandidate.nextCandidate = currentCandidate.nextCandidate;
			currentCandidate.pastCandidate = previousCandidate;
		}
		size--;
		System.out.println("Candidate removed. ");
		return currentCandidate;
	}

	/**
	 * removeCandidateByPosition method remove an specific candidate of the
	 * LinkedList by searching a specific position
	 * 
	 * @param position
	 *            Integer position of the candidate to be remove|
	 */
	public void removeCandidateByPosition(int position) {
		if (position > size || position <= 0) {
			System.out.println("No candidate at position " + position);
		} else {
			Candidate currentCandidate = firstCandidate;

			for (int i = 0; i < (position - 1); i++) {
				currentCandidate = currentCandidate.nextCandidate;
			}
			removeCandidateByID(currentCandidate.getCandidateNumber());

		}
	}

	/**
	 * cutoffCandidates method cut the list off backwards i.e. list size 4 type 2
	 * and will delete the last 2 candidates of the list
	 * 
	 * @param cutoff
	 *            Integer of number of the candidate to be remove from the list
	 *            backwards
	 */
	public void cutoffCandidates(int cutoff) {
		if (size > cutoff) {
			Candidate templastCandidate = lastCandidate;

			for (int i = 0; i <= (cutoff - 1); i++) {
				templastCandidate = templastCandidate.pastCandidate;
			}

			templastCandidate.nextCandidate = null;
			size = size - cutoff;
			System.out.println("Cut off of list completed");
		} else if (size == cutoff) {
			firstCandidate = null;
			lastCandidate = null;
			size = 0;
			System.out.println("Cut off of list completed");
		} else if (cutoff < 0 || size < cutoff) {
			System.out.println("Cut off needs number greater than 0 or smaller or equal to " + size);
			return;
		}
	}


}
