package ua.lviv.cinema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private double money;
	
	@OneToMany(mappedBy = "theater", cascade = CascadeType.REMOVE)
	private List<Movie> movies = new ArrayList<>();

	@OneToMany(mappedBy = "theater", cascade = CascadeType.REMOVE)
	private List<Cinema> cinemas = new ArrayList<>();
	
	public Theater() {
		
	}

	public Theater(String name, double money) {
		this.name = name;
		this.money = money;
	}

	public Theater(String name) {
		this.name = name;
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
