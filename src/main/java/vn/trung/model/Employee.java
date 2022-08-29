package vn.trung.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "my_generator")
	@GenericGenerator(name = "my_generator", strategy = "vn.trung.Generator.MyGenerator")
	private String id;
	
	@Column(nullable = false)
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee() {
		super();
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
