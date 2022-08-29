package vn.trung.model;

import javax.persistence.Embeddable;

@Embeddable
public class Syllabus {
	private String content;
	private int during;

	public String getName() {
		return content;
	}

	public void setName(String name) {
		this.content = name;
	}

	public int getDuring() {
		return during;
	}

	public void setDuring(int during) {
		this.during = during;
	}

	public Syllabus(String name, int during) {
		super();
		this.content = name;
		this.during = during;
	}

	public Syllabus() {
		super();
	}

	@Override
	public String toString() {
		return "Syllabus [content=" + content + ", during=" + during + "]";
	}
	

}
