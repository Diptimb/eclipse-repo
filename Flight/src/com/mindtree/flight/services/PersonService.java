package com.mindtree.flight.services;

import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.entity.Person;
import com.mindtree.flight.exceptions.ServiceException;

public interface PersonService {
public boolean triggerinsertIntoDB(Person p) throws ServiceException;
public List<Person> triggerViewPersonDB() throws ServiceException ;
public boolean triggerLinking(int id,String fid,List<Person> person,List<Flight> f)throws ServiceException;
public List<Person> triggerViewPersonAccount() throws ServiceException;
}
