package com.mindtree.flight.dao;

import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.entity.Person;
import com.mindtree.flight.exceptions.DaoExceptioon;

public interface PersonDao {
	public boolean insertIntoDB(Person person) throws DaoExceptioon;
	public List<Person> viewPersonDB() throws DaoExceptioon ;
	public boolean linkPersonDB(int id,String fid,List<Person> p,List<Flight> f) throws DaoExceptioon;
	public List<Person> accountBalanceGreaterThan5000() throws DaoExceptioon;
}
