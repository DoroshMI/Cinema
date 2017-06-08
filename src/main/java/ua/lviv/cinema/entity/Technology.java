package ua.lviv.cinema.entity;

public enum Technology {
	/**
	 * List of states for the state drop down.
	 * @author Ryan Cuprak
	 */
	
	    IMAX_2D("IMAX_2D"),
	    IMAX_3D("IMAX_3D"),
	    CINETECH_2D("CINETECH_2D"),
	    CINETECH_3D("CINETECH_3D");
	    

	    /**
	     * State abbreviation
	     */
	    private String abbreviation;

	    /**
	     * Constructs a new state
	     * @param abbreviation - abbreviation
	     */
	    private Technology(String abbreviation) {
	        this.abbreviation = abbreviation;
	    }

	    @Override
	    public String toString() {
	        return abbreviation;
	    }

}
