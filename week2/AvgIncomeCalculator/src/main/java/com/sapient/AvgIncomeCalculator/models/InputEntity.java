package com.sapient.AvgIncomeCalculator.models;

public class InputEntity {

	private Currency currency;
	private Gender gender;
	private String city;
	private String country;
	private double amount;

	public InputEntity(String city, String country, Gender gender, Currency currency, double amount) {

		this.currency = currency;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.amount = amount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
