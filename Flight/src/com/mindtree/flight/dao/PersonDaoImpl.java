package com.mindtree.flight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.entity.Person;
import com.mindtree.flight.exceptions.DaoExceptioon;
import com.mindtree.flight.exceptions.UtilityException;
import com.mindtree.flight.utility.JdbcConnection;


public class PersonDaoImpl implements PersonDao{
	public boolean insertIntoDB(Person person) throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			int id=person.getPerson_id();
			String name=person.getPerson_name();
			double balance=person.getAcc_balance();
			PreparedStatement st = con.prepareStatement("insert into person(person_id,person_name,account_balance) values('"+id+"','"+name+"','"+balance+"')");
			st.executeUpdate();

			con.close();
            
			return true;
		} catch (SQLException e) {
			//System.out.println(e);
			System.out.println(" id already registered");
			return false;
		}}catch(UtilityException e) {
			throw new DaoExceptioon(e.getLocalizedMessage(),e);
		}
	}
	public List<Person> viewPersonDB() throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			List<Person> list=new ArrayList<Person>();
			Flight h=new Flight();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					"select*from person");
			while (rs1.next()) {
				Person person=new Person();
				person.setPerson_id(rs1.getInt("person_id"));
				person.setPerson_name(rs1.getString("person_name"));
				person.setAcc_balance(rs1.getDouble("account_balance"));
		        list.add(person);}
				st.close();
		con.close();
		return list;	
			}
			 catch (SQLException e) {
				System.out.println(e);
				System.out.println(" id already registered");
				return null;
			}}catch(UtilityException e) {
				throw new DaoExceptioon(e.getLocalizedMessage(),e);
			}	
	}
	public boolean linkPersonDB(int id,String fid,List<Person> p,List<Flight> f) throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			Person per1=new Person();
			int pid=0;
			double balance=0;
			for(Person per:p) {
				if(per.getPerson_id()==id)
					{ pid=id;
				balance=per.getAcc_balance();}
			}
			double ticket=0;
			for(Flight fly:f) {
				if(fly.getFlight_id().equalsIgnoreCase(fid)) {
					ticket=fly.getTicket_cost();
				}
			}
			double diff=balance-ticket;
			Statement st = con.createStatement();
			int rs1 = st.executeUpdate("update person set flight_id='"+fid+"',account_balance='"+diff+"'where person_id='"+id+"'");
		return true;
		}catch (SQLException e) {
			System.out.println(e);
			System.out.println(" id already registered");
			return false;
		}}catch(UtilityException e) {
			throw new DaoExceptioon(e.getLocalizedMessage(),e);
		}
	}
	public List<Person> accountBalanceGreaterThan5000() throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			List<Person> list=new ArrayList<Person>();
			Flight h=new Flight();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					" select*from person where account_balance>50000 ");
			while (rs1.next()) {
				Person person=new Person();
				person.setPerson_id(rs1.getInt("person_id"));
				person.setPerson_name(rs1.getString("person_name"));
				person.setAcc_balance(rs1.getDouble("account_balance"));
		        list.add(person);}
				st.close();
		con.close();
		return list;	
			}
			 catch (SQLException e) {
				System.out.println(e);
				System.out.println(" No such table");
				return null;
			}}catch(UtilityException e) {
				throw new DaoExceptioon(e.getLocalizedMessage(),e);
			}	

	}}
