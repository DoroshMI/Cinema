package ua.lviv.cinema.entity;

public enum Language {
	/**
	 * List of states for the state drop down.
	 * @author Ryan Cuprak
	 */
	
		Ukrainian("Ukrainian"),
		English("English");
	    

	    /**
	     * State abbreviation
	     */
	    private String abbreviation;

	    /**
	     * Constructs a new state
	     * @param abbreviation - abbreviation
	     */
	    private Language(String abbreviation) {
	        this.abbreviation = abbreviation;
	    }

	    @Override
	    public String toString() {
	        return abbreviation;
	    }

}
