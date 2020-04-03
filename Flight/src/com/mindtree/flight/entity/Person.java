package com.mindtree.flight.entity;

public class Person {
	private int person_id;
	private String person_name;
	private double acc_balance;
	private Flight flight;

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public double getAcc_balance() {
		return acc_balance;
	}

	public Person() {
		super();
	}

	public Person(int person_id, String person_name, double acc_balance) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
		this.acc_balance = acc_balance;
	}

	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
