package vn.trung.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idA;
	private String city;
	private String country;

	public int getId() {
		return idA;
	}

	public void setId(int id) {
		this.idA = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	public Address() {
		super();
	}
	
	


	@Override
	public String toString() {
		return "Address [id=" + idA + ", city=" + city + ", country=" + country + "]";
	}

}
