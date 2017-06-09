package ua.lviv.cinema.entity;

public enum StatusTicket {
	/**
	 * List of states for the state drop down.
	 * @author Maryan Dorosh
	 */

	PROCESSED("PROCESSED"),
	    IMAX_3D("In process"),
	USED("used"),
	    FUTURE("future");


	    /**
	     * State abbreviation
	     */
	    private String abbreviation;

	    /**
	     * Constructs a new state
	     * @param abbreviation - abbreviation
	     */
	    private StatusTicket(String abbreviation) {
	        this.abbreviation = abbreviation;
	    }

	    @Override
	    public String toString() {
	        return abbreviation;
	    }

}
