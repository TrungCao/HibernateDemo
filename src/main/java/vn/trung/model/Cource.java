package vn.trung.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name = "Course_Name", unique = true)
	private String name;

//	@Transient  			// không lưu column này vào database
	@Temporal(TemporalType.DATE) // format cho date trong db
	private Date date;

	
	
//	@Embedded			//Không tạo table mới trong DB
//	private Syllabus syllabus;

	
//	public Syllabus getSyllabus() {
//		return syllabus;
//	}
//
//	public void setSyllabus(Syllabus syllabus) {
//		this.syllabus = syllabus;
//	}

	@ElementCollection(fetch = FetchType.EAGER)		//Tạo table mới trong DB
	private List<Syllabus> syllabuses;
	
	
	public List<Syllabus> getSyllabuss() {
		return syllabuses;
	}

	public void setSyllabuss(List<Syllabus> syllabuss) {
		this.syllabuses = syllabuss;
		
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name;
	}

	public Cource() {
		super();
	}

	public Cource(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	public Cource(String name, Date date, List<Syllabus> syllabuss) {
		super();
		this.name = name;
		this.date = date;
		this.syllabuses = syllabuss;
	}

	public Cource(String name) {
		super();
		this.name = name;
	}

	
	

}
