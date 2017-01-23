/**
 * Person object that stores someone's name
 * @author Robin A.
 *
 */
public class Person {
	private String fName;
	private String lName;
	
	public Person () {
		
	}
	
	public Person(String fName, String lName) {
		setfName(fName);
		setlName(lName);
	}
	
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Name: %s %s, ", fName, lName);
	}
}
