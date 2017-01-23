/**
 * Child class of Person that stores a birthday object, an address object, notes about them, and their status (for an address book)
 * @author Robin A.
 *
 */
public class ExtPerson extends Person {
	
	private Date bday;
	private String notes;
	private Address addr;
	private char status;
	
	public ExtPerson() {
		super();
	}
	
	public ExtPerson(String fName, String lName, int m, int d, int y, String notes, Address addr, char status) {
		super(fName, lName);
		setAddr(addr);
		bday = new Date (m,d,y);
		setStatus(status);
	}
	
	/**
	 * @return the bday
	 */
	public Date getBday() {
		return bday;
	}
	/**
	 * @param bday the bday to set
	 */
	public void setBday(Date bday) {
		this.bday = bday;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the addr
	 */
	public Address getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + String.format(bday + "Notes: " + notes + addr + "Status: " + status);
	}
}
