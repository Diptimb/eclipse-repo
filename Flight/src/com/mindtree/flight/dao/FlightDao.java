package com.mindtree.flight.dao;

import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.exceptions.DaoExceptioon;
import com.mindtree.flight.exceptions.UtilityException;

public interface FlightDao {
	public boolean insertIntoDB(Flight flight) throws DaoExceptioon ;
	public List<Flight> viewFlightDB() throws DaoExceptioon ;
}
