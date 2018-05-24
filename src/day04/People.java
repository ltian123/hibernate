package day04;

import java.io.Serializable;

public class People implements Serializable {
	private Integer id;
	private Name name;
	public People() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
}
