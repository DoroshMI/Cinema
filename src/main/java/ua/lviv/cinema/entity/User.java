package ua.lviv.cinema.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
public class User implements UserDetails {
    static Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private int accountOfScores;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Basic(fetch = FetchType.LAZY)
    private LocalDate dateOfBirth;

    @Basic(fetch = FetchType.LAZY)
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    private boolean enable = true;
    private String uuid;

    private boolean enablePhone;
    private boolean enableEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//	@JoinTable(name = "user_ticket",
//			joinColumns = @JoinColumn(name = "id_user"),
//			inverseJoinColumns = @JoinColumn(name = "id_ticket"))
    private List<Seat> seats = new ArrayList<>();

    @ManyToMany
    	@JoinTable(name = "user_movie",
			joinColumns = @JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private Set<Movie> movies = new HashSet<>();



    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public User() {
    }

    public User(String username, String password) {
        logger.info("user info");
        if (username.startsWith("+380")) {

            this.phone = username;
            this.password = password;
        } else if (username.contains("@")) {
            this.email = email;
            this.password = password;
        }

    }


    //    public boolean isEnable() {
//        return enable;
//    }




    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isEnablePhone() {
        return enablePhone;
    }

    public void setEnablePhone(boolean enablePhone) {
        this.enablePhone = enablePhone;
    }

    public boolean isEnableEmail() {
        return enableEmail;
    }

    public void setEnableEmail(boolean enableEmail) {
        this.enableEmail = enableEmail;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountOfScores() {
        return accountOfScores;
    }

    public void setAccountOfScores(int accountOfScores) {
        this.accountOfScores = accountOfScores;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    private String pathImage;

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }


//    public List<Ticket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(List<Ticket> tickets) {
//		this.tickets = tickets;
//	}




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", role=" + role + "]";
	}

	@Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
