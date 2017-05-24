package ua.lviv.cinema;

public enum Genre {
	/**
	 * List of states for the state drop down.
	 * 
	 * @author Ryan Cuprak
	 */

	fiction("фантастика"), 
	thriller("бойовик");

	/**
	 * State abbreviation
	 */
	private String abbreviation;

	/**
	 * Constructs a new state
	 * 
	 * @param abbreviation
	 *            - abbreviation
	 */
	private Genre(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return abbreviation;
	}

}
