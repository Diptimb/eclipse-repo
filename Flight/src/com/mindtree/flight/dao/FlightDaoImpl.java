package com.mindtree.flight.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.exceptions.DaoExceptioon;
import com.mindtree.flight.exceptions.UtilityException;
import com.mindtree.flight.utility.JdbcConnection;

public class FlightDaoImpl implements FlightDao{
	public boolean insertIntoDB(Flight flight) throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			String id=flight.getFlight_id();
			String name=flight.getFlight_name();
			double cost=flight.getTicket_cost();
			CallableStatement st=con.prepareCall("{call insertFlight(?,?,?)}");
			st.setString(1, id);
			st.setString(2, name);
			st.setDouble(3, cost);
			st.execute();
             st.close();
			con.close();
            
			return true;
		} catch (SQLException e) {
			//return false;
			throw new DaoExceptioon(e.getLocalizedMessage(),e);
		}}catch(UtilityException e) {
			throw new DaoExceptioon(e.getLocalizedMessage(),e);
		}
}
	public List<Flight> viewFlightDB() throws DaoExceptioon {
		try{Connection con = JdbcConnection.getConnection();
		try {
			List<Flight> list=new ArrayList<Flight>();
			Flight h=new Flight();
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(
					"select*from flight");
			while (rs1.next()) {
				Flight fly=new Flight();
				//p.setName(rs1.getString("person_name"));
				fly.setFlight_id(rs1.getString("flight_id"));
				fly.setFlight_name(rs1.getString("flight_name"));
				fly.setTicket_cost(rs1.getDouble("ticket_cost"));
		        list.add(fly);}
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
			
		
	}}
