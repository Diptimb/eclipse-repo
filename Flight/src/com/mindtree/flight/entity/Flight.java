package com.mindtree.flight.entity;

public class Flight {
private String flight_id;
private String flight_name;
private double ticket_cost;

public Flight(String flight_id, String flight_name, double ticket_cost) {
	super();
	this.flight_id = flight_id;
	this.flight_name = flight_name;
	this.ticket_cost = ticket_cost;
}

public Flight() {
	super();
}

public String getFlight_id() {
	return flight_id;
}
public void setFlight_id(String flight_id) {
	this.flight_id = flight_id;
}
public String getFlight_name() {
	return flight_name;
}
public void setFlight_name(String flight_name) {
	this.flight_name = flight_name;
}
public double getTicket_cost() {
	return ticket_cost;
}
public void setTicket_cost(double ticket_cost) {
	this.ticket_cost = ticket_cost;
}

public void display() {
	System.out.println("flight id = "+flight_id+"\nflight name ="+flight_name+"\nticket cost= "+ticket_cost);
	System.out.println("------");
}

}
