package ua.lviv.cinema.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie implements Comparable<Movie> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;
	private int minutes;

	@Enumerated(EnumType.STRING)
	private Country country;

	@Enumerated(EnumType.STRING)
	private Language languageOriginal;

	@Enumerated(EnumType.STRING)
	private Language languageDubbing;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Genre")
	private List<String> genres = new ArrayList<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Starring")
	private List<String> starring = new ArrayList<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "director")
	private List<String> directors = new ArrayList<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Scenario")
	private List<String> scenarios = new ArrayList<>();

	private int ageRestriction;

	private LocalDate showFromDate;
	private LocalDate showToDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private Theater theater;

	private String pathImage;

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinTable(name = "cinema_movie", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "cinema_id"))
	private List<Cinema> cinemas = new ArrayList<>();

	public Movie() {
	}

	

	public Movie(String title, int minutes, Country country, Language languageOriginal, Language languageDubbing,
			List<String> genres, List<String> starring, List<String> directors, List<String> scenarios,
			int ageRestriction, LocalDate showFromDate, LocalDate showToDate, Theater theater) {
		super();
		this.title = title;
		this.minutes = minutes;
		this.country = country;
		this.languageOriginal = languageOriginal;
		this.languageDubbing = languageDubbing;
		this.genres = genres;
		this.starring = starring;
		this.directors = directors;
		this.scenarios = scenarios;
		this.ageRestriction = ageRestriction;
		this.showFromDate = showFromDate;
		this.showToDate = showToDate;
		this.theater = theater;
	}



	public Movie(String title, int minutes, Country country, LocalDate showFromDate, Theater theater) {
		super();
		this.title = title;
		this.minutes = minutes;
		this.country = country;
		this.showFromDate = showFromDate;
		this.theater = theater;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Language getLanguageOriginal() {
		return languageOriginal;
	}

	public void setLanguageOriginal(Language languageOriginal) {
		this.languageOriginal = languageOriginal;
	}

	public Language getLanguageDubbing() {
		return languageDubbing;
	}

	public void setLanguageDubbing(Language languageDubbing) {
		this.languageDubbing = languageDubbing;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getStarring() {
		return starring;
	}

	public void setStarring(List<String> starring) {
		this.starring = starring;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<String> scenarios) {
		this.scenarios = scenarios;
	}

	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public LocalDate getShowFromDate() {
		return showFromDate;
	}

	public void setShowFromDate(LocalDate showFromDate) {
		this.showFromDate = showFromDate;
	}

	public LocalDate getShowToDate() {
		return showToDate;
	}

	public void setShowToDate(LocalDate showToDate) {
		this.showToDate = showToDate;
	}

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	@Override
	public int compareTo(Movie o) {
		if(this.getShowFromDate().compareTo(o.getShowFromDate())!=0) {
			return this.getShowFromDate().compareTo(o.getShowFromDate());
		}else {
			return this.getTitle().compareToIgnoreCase(o.getTitle());
		}
	}

	public void addCinema(Cinema cinema) {
		this.cinemas.add(cinema);
		cinema.getMovies().add(this);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", minutes=" + minutes + ", country=" + country
				+ ", releaseDateFrom=" + showFromDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
