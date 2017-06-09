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

	@ManyToMany
	@JoinTable(name = "order_ticket", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDateTime localDateTime) {
		super();
		this.localDateTime = localDateTime;
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

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
