package com.rahul.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="PIN")
	private long pin;
	
	public Address(){
	}
	
	public Address(String street,String city,int pin){
		this.street=street;
		this.city=city;
		this.pin=pin;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
}
