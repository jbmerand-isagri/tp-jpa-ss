package otg.ss.bank.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "STREET")
	private String street;
	@Column(name = "ZIP_CODE")
	private String zipCode;
	@Column(name = "CITY")
	private String city;

	public Address() {
	}

	public Address(String number, String street, String zipCode, String city) {
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Address{");
		sb.append("number='").append(number).append('\'');
		sb.append(", street='").append(street).append('\'');
		sb.append(", zipCode='").append(zipCode).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append('}');
		return sb.toString();
	}
}