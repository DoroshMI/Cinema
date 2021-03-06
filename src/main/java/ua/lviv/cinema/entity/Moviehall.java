/*
 *
 */

package ua.lviv.cinema.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Maryan Dorosh 31.03.17
 */
@Entity
public class Moviehall implements Comparable<Moviehall> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Technology technology;
	private String name;
	private int rows;
	private int columns;

	@OneToMany(mappedBy = "moviehall", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Schedule> schedules;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cinema cinema;

	public Moviehall() {
		this.schedules = new ArrayList<>();
		LocalDate currentTime = LocalDate.now();
		for (int i = 0; i < 31; i++) {
			schedules.add(new Schedule(LocalDate.ofYearDay(currentTime.getYear(), currentTime.getDayOfYear() + i), this));
		}
	}

	public Moviehall(String name, int rows, int columns, Technology technology, Cinema cinema) {
		this.name = name;
		this.rows = rows;
		this.columns = columns;		
		this.cinema = cinema;
		this.technology = technology;
		
		this.schedules = new ArrayList<>();
		LocalDate currentTime = LocalDate.now();
		for (int i = -1; i < 31; i++) {
			schedules.add(new Schedule(LocalDate.ofYearDay(currentTime.getYear(), currentTime.getDayOfYear() + i), this));
		}
		System.out.println(schedules);
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

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	@Override
	public int compareTo(Moviehall arg0) {	
		return this.getName().compareToIgnoreCase(arg0.getName());
	}

	
	@Override
	public String toString() {
		return "Moviehall [id=" + id + ", technology=" + technology + ", name=" + name + ", rows=" + rows + ", columns="
				+ columns + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columns;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rows;
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
		Moviehall other = (Moviehall) obj;
		if (columns != other.columns)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rows != other.rows)
			return false;
		return true;
	}

	
}
