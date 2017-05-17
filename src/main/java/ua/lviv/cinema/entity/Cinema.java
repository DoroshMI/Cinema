package ua.lviv.cinema.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	
	private double money;

	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	//@OneToOne(fetch = FetchType.EAGER)
	private Address address;

	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	private List<Moviehall> moviehalls;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cinema_movie",
	joinColumns = @JoinColumn(name = "cinema_id"),
	inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies;

	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	private List<User> customers;

	@OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
	private List<User> administrators;

	public Cinema() {
	}

	public Cinema(String name, Address address) {
		this.name = name;
		//this.address = address;

		moviehalls = new ArrayList<>();
		movies = new ArrayList<>();
		customers = new ArrayList<>();
		administrators = new ArrayList<>();
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

	public void setName(String name) {
		this.name = name;
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Moviehall> getMoviehalls() {
		return moviehalls;
	}

	public void setMoviehalls(List<Moviehall> moviehalls) {
		this.moviehalls = moviehalls;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<User> getCustomers() {
		return customers;
	}

	public void setCustomers(List<User> customers) {
		this.customers = customers;
	}

	public List<User> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<User> administrators) {
		this.administrators = administrators;
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
		movie.getCinemas().add(this);
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

//	public Moviehall getHall(String nameMovieHall) {
//		return this.moviehalls.stream().filter(hall -> hall.getName().equalsIgnoreCase(nameMovieHall)).findFirst()
//				.orElse(null);
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cinema other = (Cinema) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
