package ua.lviv.cinema.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private boolean freeSeat = true;
	private boolean reservedSeat = false;
	private int price;

	@ManyToOne
	private Seance seance;

	@Embedded
	private Coordinate �oordinate;

	public Seat() {
	}

	public Seat(int price, Coordinate �oordinate, Seance seance) {
		this.price = price;
		this.�oordinate = �oordinate;
		this.seance = seance;
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

	public Coordinate get�oordinate() {
		return �oordinate;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", freeSeat=" + freeSeat + ", reservedSeat=" + reservedSeat + ", price=" + price
				+ ", �oordinate=" + �oordinate + "]";
	}

}
