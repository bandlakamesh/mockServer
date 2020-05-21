package com.example.mockserver.Mockserver;

public class TestPojo {

	private String fName;
	private String lName;
	private Address address;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "TestPojo [fName=" + fName + ", lName=" + lName + ", address=" + address + "]";
	}

}
