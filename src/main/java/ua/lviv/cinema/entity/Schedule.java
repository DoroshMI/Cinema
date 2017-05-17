package ua.lviv.cinema.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Schedule implements Comparable<Schedule> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate date;

	// @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@ManyToOne
	private Moviehall moviehall;
	
	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
	private Set<Seance> seances = new TreeSet<>();

	public Schedule() {
	}

	public Schedule(LocalDate date, Moviehall moviehall) {
		this.date = date;
		this.moviehall = moviehall;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Moviehall getMoviehall() {
		return moviehall;
	}

	public void setMoviehall(Moviehall moviehall) {
		this.moviehall = moviehall;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public boolean addSeance(Seance seance) {

		for (Seance seance2 : seances) {
			if (seance.compareTo(seance2) == 0) {
				return false;
			}
		}
		return seances.add(seance);
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + "]";
	}

	@Override
	public int compareTo(Schedule o) {
		return this.getDate().compareTo(o.getDate());

	}

	// public String getNameMovieHall() {
	// return nameMovieHall;
	// }
	//
	// public void setNameMovieHall(String nameMovieHall) {
	// this.nameMovieHall = nameMovieHall;
	// }
	//
	// public int getRows() {
	// return rows;
	// }
	//
	// public void setRows(int rows) {
	// this.rows = rows;
	// }
	//
	// public int getColumns() {
	// return columns;
	// }
	//
	// public void setColumns(int columns) {
	// this.columns = columns;
	// }
	//
	// public void setOpen(Time open) {
	// this.open = open;
	// }
	//
	// public void setClose(Time close) {
	// this.close = close;
	// }
	//
	// private void putOpenAndClose() {
	// Seance[] seancesArray = seances.toArray(new Seance[seances.size()]);
	//
	// if (seancesArray.length == 0) {
	// open = null;
	// close = null;
	// return;
	// }
	//
	// Seance firstSeance = seancesArray[0];
	// Seance lastSeance = seancesArray[seances.size() - 1];
	// open = firstSeance.getStartTime();
	// close = lastSeance.getEndTime();
	// }
	//
	// public boolean addSeance(Seance seance) {
	// boolean result = seances.add(seance);
	// if (result) {
	// putOpenAndClose();
	// }
	//
	// return result;
	//
	// }
	//
	// /**
	// * @return null
	// */
	// private Time getTimeForAddMovie(Movie movie, Time startTime) {
	// Iterator<Seance> iterator = seances.iterator();
	// Time result = startTime;
	//
	// Seance seance;
	// while (iterator.hasNext()) {
	// seance = iterator.next();
	//
	// if
	// (result.addTime(movie.getDuration()).addTime(Seance.BREAK_BETWEEN_MOVIES)
	// .compareTo(seance.getStartTime()) <= 0) {
	// break;
	// } else {
	// result = seance.getEndTime();
	// }
	// }
	//
	// return result.compareTo(new Time(2, 0)) < 0 ? result : null;
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean addMovie(Movie movie, Time time, int price) {
	//
	// return addSeance(new Seance(movie, time, nameMovieHall, rows, columns,
	// price));
	//
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean addAllMovies(Movie movie, List<Time> times, int price) {
	// boolean result = false;
	// for (int i = 0; i < times.size(); i++) {
	// result |= addSeance(new Seance(movie, times.get(i), nameMovieHall, rows,
	// columns, price));
	// }
	// return result;
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean addAllMovies(Movie movie, Time startTime, Time endTime,
	// int price) {
	// boolean result = false;
	//
	// Time time;
	//
	// while (this.getTimeForAddMovie(movie, startTime) != null
	// && this.getTimeForAddMovie(movie, startTime).compareTo(endTime) <= 0) {
	//
	// time = this.getTimeForAddMovie(movie, startTime);
	// result |= this.addMovie(movie, time, price);
	// }
	//
	// return result;
	// }
	//
	// public boolean addAllMovies(Movie movie, int price) {
	// return addAllMovies(movie, new Time(9, 0), new Time(2, 0), price);
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean removeMovie(Movie movie, Time time) {
	// boolean result = false;
	//
	// for (Iterator<Seance> iterator = seances.iterator(); iterator.hasNext();)
	// {
	// Seance seance = iterator.next();
	// if (seance.getMovie().equals(movie) &&
	// seance.getStartTime().equals(time)) {
	// iterator.remove();
	// result = true;
	// putOpenAndClose();
	// break;
	// }
	// }
	//
	// return result;
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean removeAllMovies(Movie movie, List<Time> times) {
	// boolean result = false;
	//
	// for (Time time : times) {
	// result |= this.removeMovie(movie, time);
	// }
	//
	// return result;
	// }
	//
	// /**
	// * @return null
	// */
	// public boolean removeAllMovies(Movie movie, Time startTime, Time endTime)
	// {
	// boolean result = false;
	// for (Iterator<Seance> iterator = seances.iterator(); iterator.hasNext();)
	// {
	// Seance seance = iterator.next();
	// if (seance.getMovie().equals(movie)) {
	//
	// if (startTime.compareTo(seance.getStartTime()) <= 0) {
	// if (endTime.compareTo(seance.getStartTime()) >= 0) {
	// iterator.remove();
	// result = true;
	// } else {
	// break;
	// }
	// }
	//
	// }
	// }
	// // Задаємо нові межі open and close for schedule
	// putOpenAndClose();
	//
	// return result;
	// }
	//
	// public boolean removeAllMovies(Movie movie) {
	// boolean result = false;
	// for (Iterator<Seance> iterator = seances.iterator(); iterator.hasNext();)
	// {
	// Seance seance = iterator.next();
	// if (seance.getMovie().equals(movie)) {
	// iterator.remove();
	// result = true;
	// }
	// }
	// // Задаємо нові межі open and close for schedule
	// putOpenAndClose();
	//
	// return result;
	// }
	//
	// /**
	// * Повертає null якщо розклад пустий
	// */
	// public Time getOpen() {
	// return open;
	// }
	//
	// /**
	// * Повертає null якщо розклад пустий
	// */
	// public Time getClose() {
	// return close;
	// }
	//
	// public Set<Seance> getAllSeances() {
	// return seances;
	// }
	//
	//
	//
	// @Override
	// public String toString() {
	// return "Schedule [seances=" + seances + ", open=" + open + ", close=" +
	// close + ", nameMovieHall="
	// + nameMovieHall + ", rows=" + rows + ", columns=" + columns + "]";
	// }

}
