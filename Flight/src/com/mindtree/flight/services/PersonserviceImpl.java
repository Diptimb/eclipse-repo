package com.mindtree.flight.services;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.flight.dao.PersonDao;
import com.mindtree.flight.dao.PersonDaoImpl;
import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.entity.Person;
import com.mindtree.flight.exceptions.DaoExceptioon;
import com.mindtree.flight.exceptions.ServiceException;
import com.mindtree.flight.exceptions.UtilityException;

public class PersonserviceImpl implements PersonService {
	PersonDao p=new PersonDaoImpl();
	public boolean triggerinsertIntoDB(Person person) throws ServiceException {
		try{boolean val= p.insertIntoDB(person);
if(val==true) {
	System.out.println("person registered successfully");
	return true;}
else {
	System.out.println("person not registered");
	return false;}}
		catch(DaoExceptioon e) {
				throw new ServiceException(e.getLocalizedMessage(),e);
		}
	}		
	public List<Person> triggerViewPersonDB() throws ServiceException {
		List<Person> per=new ArrayList<Person>();
			try{per=p.viewPersonDB();
	if(per!=null) {
		
		return per;}
	else {
		System.out.println("No such table");
		return null;}}
			catch(DaoExceptioon e) {
					throw new ServiceException(e.getLocalizedMessage(),e);
			}
		}
	public boolean triggerLinking(int id,String fid,List<Person> person,List<Flight> f)throws ServiceException{
		Person per=new Person();
		try {
		boolean val=p.linkPersonDB(id, fid, person, f);
		return val;
		}catch(DaoExceptioon e) {
			throw new ServiceException(e.getLocalizedMessage(),e);
	}
	}
	public List<Person> triggerViewPersonAccount() throws ServiceException {
		List<Person> per=new ArrayList<Person>();
			try{per=p.accountBalanceGreaterThan5000();
	if(per!=null) {
		
		return per;}
	else {
		System.out.println("No such table");
		return null;}}
			catch(DaoExceptioon e) {
					throw new ServiceException(e.getLocalizedMessage(),e);
			}
		}
}
