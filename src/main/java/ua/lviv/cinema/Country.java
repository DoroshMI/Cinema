package ua.lviv.cinema;

public enum Country {
	/**
	 * List of states for the state drop down.
	 * @author Ryan Cuprak
	 */
	
	    Ukrain("UK"),
	    USA("USA");
	    

	    /**
	     * State abbreviation
	     */
	    private String abbreviation;

	    /**
	     * Constructs a new state
	     * @param abbreviation - abbreviation
	     */
	    private Country(String abbreviation) {
	        this.abbreviation = abbreviation;
	    }

	    @Override
	    public String toString() {
	        return abbreviation;
	    }

}
