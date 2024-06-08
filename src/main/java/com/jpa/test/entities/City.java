package com.jpa.test.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int cityId;
	private String pincode;
	private String cityName;
	
	@OneToOne(mappedBy = "city")
	@JsonBackReference
	private User user;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", pincode=" + pincode + ", cityName=" + cityName + "]";
	}
	
	

}
