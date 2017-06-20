package ua.lviv.cinema.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDateTime localDateTime;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "order")
//	@JoinTable(name = "order_ticket", joinColumns = @JoinColumn(name = "id_order"), inverseJoinColumns = @JoinColumn(name = "id_ticket"))
	private List<Seat> seats = new ArrayList<Seat>();

	private String nameMovie;
	
	private int countTickets;

	@Enumerated(EnumType.STRING)
	private StatusTicket statusTicket;
	
	@OneToOne
	private Seance seance;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDateTime localDateTime, Seance seance) {
		super();
		this.localDateTime = localDateTime;
		this.seance = seance;
	}

	
	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public String getNameMovie() {
		return nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	public int getCountTickets() {
		return countTickets;
	}

	public void setCountTickets(int countTickets) {
		this.countTickets = countTickets;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StatusTicket getStatusTicket() {
		return statusTicket;
	}

	public void setStatusTicket(StatusTicket statusTicket) {
		this.statusTicket = statusTicket;
	}

	//	public Set<Ticket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(Set<Ticket> tickets) {
//		this.tickets = tickets;
//	}
}
