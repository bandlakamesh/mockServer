package com.example.mockserver.Mockserver;

public class Contact {

	private String email;
	private String phn;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	@Override
	public String toString() {
		return "Contact [email=" + email + ", phn=" + phn + "]";
	}

}
