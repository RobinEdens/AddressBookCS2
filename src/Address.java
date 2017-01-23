/**
 * Address object that stores a person's address, city, state, and zip code
 * @author Robin A.
 */
public class Address {
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public Address () {
		
	}
	
	public Address (String street, String city, String state, int zip) {
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
	}
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(" Address: %s, %s, %s %s, ", street, city, state, zip);
	}
}
