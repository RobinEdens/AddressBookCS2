/**
 * Date class that stores a birthday
 * @author Robin A.
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;
	
	/**
	 * Default constructor
	 */
	public Date() {
		
	}
	
	/**
	 * Overloaded constructor
	 * @param month
	 * @param day
	 * @param year
	 */
	public Date(int month, int day, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DOB: %s/%s/%s, ", month, day, year);
	}
}
