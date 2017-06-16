package ua.lviv.cinema.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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
	private Set<Seat> seats = new HashSet<Seat>();



	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDateTime localDateTime) {
		super();
		this.localDateTime = localDateTime;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
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
	
	

//	public Set<Ticket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(Set<Ticket> tickets) {
//		this.tickets = tickets;
//	}
}
