package com.example.mockserver.Mockserver;

public class Address {

	private Contact contact;
	private String address;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [contact=" + contact + ", address=" + address + "]";
	}

}
