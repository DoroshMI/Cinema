package ua.lviv.cinema.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Seance implements Comparable<Seance> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Movie movie;
	private LocalDateTime startTime;
	@Transient
	private LocalDateTime endTime;
	@ManyToOne
	private Schedule schedule;
	private int price;
	@OneToMany(mappedBy = "seance", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	List<Seat> seats;

	public final static long BREAK_BETWEEN_MOVIES_MINUTES = 10;

	public Seance() {
	}

	public Seance(Movie movie, LocalDateTime startTime, int price, Schedule schedule) {
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = startTime.plusMinutes(movie.getMinutes());
		this.price = price;
		this.schedule = schedule;
		this.seats = new ArrayList<>();

		for (int i = 0; i < schedule.getMoviehall().getRows(); i++) {
			for (int j = 0; j < schedule.getMoviehall().getColumns(); j++) {
				seats.add(new Seat(price, new Coordinate(i, j), this));
			}
		}
	}

	@Override
	public int compareTo(Seance o) {
		if (this.getSchedule().getMoviehall().getName()
				.compareToIgnoreCase(o.getSchedule().getMoviehall().getName()) > 0) {
			return 1;
		} else if (this.getSchedule().getMoviehall().getName()
				.compareToIgnoreCase(o.getSchedule().getMoviehall().getName()) < 0) {
			return -1;
		}

		if (this.getEndTime().plusMinutes(BREAK_BETWEEN_MOVIES_MINUTES).compareTo(o.startTime) <= 0) {

			return -1;

		} else {
			if (this.startTime.compareTo(o.getEndTime().plusMinutes(BREAK_BETWEEN_MOVIES_MINUTES)) >= 0) {

				return 1;
			}
		}

		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		this.endTime = startTime.plusMinutes(movie.getMinutes());
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	
	
	public Seat getSeat(Coordinate coordinate) {
		
		return seats.get(coordinate.getRow() * this.schedule.getMoviehall().getColumns() + coordinate.getColumn());
	}
	

	@Override
	public String toString() {
		return "Seance [id=" + id + ", movie=" + movie + ", startTime=" + startTime + ", endTime=" + getEndTime()
				+ ", price=" + price + "---" + schedule.getMoviehall().getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

}
