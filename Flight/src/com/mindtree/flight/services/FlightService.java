package com.mindtree.flight.services;

import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.exceptions.ServiceException;

public interface FlightService {
	public boolean triggerinsertIntoDB(Flight fly) throws ServiceException;
	public List<Flight> triggerViewFlight() throws ServiceException;
}
