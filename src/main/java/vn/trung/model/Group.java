package vn.trung.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQuery(name = "groupByname",query = "from Group where name like 'java%'")
@Entity
@Table(name = "groups")
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany
	private Set<Fresher> freshers;
	
	public Set<Fresher> getFreshers() {
		return freshers;
	}

	public void setFreshers(Set<Fresher> freshers) {
		this.freshers = freshers;
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

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name+ "]";
	}

}
