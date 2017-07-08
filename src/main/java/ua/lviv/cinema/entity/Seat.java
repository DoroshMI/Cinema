package ua.lviv.cinema.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private boolean freeSeat = true;
	private boolean reservedSeat = false;
	private int price;
	
//	 @OneToOne(fetch = FetchType.EAGER)
//		private Ticket ticket;

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinTable(name = "order_ticket", joinColumns = @JoinColumn(name = "id_ticket"), inverseJoinColumns = @JoinColumn(name = "id_order"))
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "user_ticket", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_ticket"))
	private User user;
	
	@ManyToOne
	private Seance seance;

	@Embedded
	private Coordinate coordinate;

	public Seat() {
	}

	public Seat(int price, Coordinate coordinate, Seance seance) {
		this.price = price;
		this.coordinate = coordinate;
		this.seance = seance;
	}

//	public Ticket getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(Ticket ticket) {
//		this.ticket = ticket;
//	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public boolean isFreeSeat() {
		return freeSeat;
	}

	public void setFreeSeat(boolean freeSeat) {
		this.freeSeat = freeSeat;
	}

	public boolean isReservedSeat() {
		return reservedSeat;
	}

	public void setReservedSeat(boolean reservedSeat) {
		this.reservedSeat = reservedSeat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", freeSeat=" + freeSeat + ", reservedSeat=" + reservedSeat + ", price=" + price
				+ ", coordinate=" + coordinate + "seanceId " + seance.getId() + "]";
	}

}
