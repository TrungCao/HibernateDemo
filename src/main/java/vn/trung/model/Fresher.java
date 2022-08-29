package vn.trung.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fresher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Cource> cources;
	
	@ManyToMany
	private Set<Group> groups;
	
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public List<Cource> getCources() {
		return cources;
	}

	public void setCources(List<Cource> cources) {
		this.cources = cources;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public Fresher(String name) {
		super();
		this.name = name;
	}

	public Fresher() {
		super();
	}

	public Fresher(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	
	
	public Fresher(String name, List<Cource> cources) {
		super();
		this.name = name;
		this.cources = cources;
	}

	@Override
	public String toString() {
		return "Fresher [id=" + id + ", name=" + name + "]";
	}

}
