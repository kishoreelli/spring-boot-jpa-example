package com.asap.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
	
	public Address() {
		super();
	}

	public Address(String houseNo, String street, String city) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
	}

	private String houseNo;

    private String street;

    private String city;

    // getters and setters
}

