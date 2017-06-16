package ua.lviv.cinema.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 09.06.2017.
 */

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private StatusTicket status;
	
	

	@ManyToOne
	private Seance seance;

//	@Embedded
//	private Coordinate coordinate;

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinTable(name = "order_ticket", joinColumns = @JoinColumn(name = "id_ticket"), inverseJoinColumns = @JoinColumn(name = "id_order"))
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_ticket", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_ticket"))
	private User user;

	public Ticket() {
	}
	
	

	public Ticket(StatusTicket status, Seance seance) {
		super();
		this.status = status;
		
		this.seance = seance;
		
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



	public StatusTicket getStatus() {
		return status;
	}



	public void setStatus(StatusTicket status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", status=" + status + "]";
	}



	
	
	
}
