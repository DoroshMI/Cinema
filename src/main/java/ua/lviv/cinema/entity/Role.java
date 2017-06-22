package ua.lviv.cinema.entity;

/**
 * Created by admin on 6/3/2017.
 */
public enum Role {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_ANONYMOUS("ANONYMOUS");

    /**
     * State abbreviation
     */
    private String role;

    /**
     * Constructs a new state
     * @param role - abbreviation
     */
    private Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}