package day04;

import java.io.Serializable;

public class Member extends User implements Serializable {
	private String email;

	public Member() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
