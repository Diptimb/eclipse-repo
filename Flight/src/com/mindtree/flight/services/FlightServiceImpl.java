package com.mindtree.flight.services;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.flight.dao.FlightDao;
import com.mindtree.flight.dao.FlightDaoImpl;
import com.mindtree.flight.dao.PersonDao;
import com.mindtree.flight.dao.PersonDaoImpl;
import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.exceptions.DaoExceptioon;
import com.mindtree.flight.exceptions.ServiceException;

public class FlightServiceImpl implements FlightService{
FlightDao flight=new FlightDaoImpl();
public boolean triggerinsertIntoDB(Flight fly) throws ServiceException {
	try{boolean val= flight.insertIntoDB(fly);
if(val==true) {
System.out.println("flight registered successfully");
return true;}
else {
System.out.println("flight not registered");
return false;}}
	catch(DaoExceptioon e) {
			throw new ServiceException(e.getLocalizedMessage(),e);
	}
}
public List<Flight> triggerViewFlight() throws ServiceException{
	try{List<Flight> fly=flight.viewFlightDB();
	
	return fly;}
	catch(DaoExceptioon e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
		}
}
}