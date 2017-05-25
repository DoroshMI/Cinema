package ua.lviv.cinema.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ua.lviv.cinema.Country;

//@Embeddable
@Entity
@Access(AccessType.FIELD)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String street;
	private String numberHouse;
	private String city;
	private String state;
	private String zipcode;
	
	@Enumerated(EnumType.STRING)
	private Country country;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String street, String numberHouse, String city, String state, String zipcode, Country country) {
		super();
		this.street = street;
		this.numberHouse = numberHouse;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumberHouse() {
		return numberHouse;
	}
	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", numberHouse=" + numberHouse + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + "]";
	}
	
	
	
	
}
