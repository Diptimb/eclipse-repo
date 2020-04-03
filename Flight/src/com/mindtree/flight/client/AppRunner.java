package com.mindtree.flight.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import com.mindtree.flight.entity.Flight;
import com.mindtree.flight.entity.Person;
import com.mindtree.flight.exceptions.ApplicationException;
import com.mindtree.flight.exceptions.ServiceException;
import com.mindtree.flight.services.FlightService;
import com.mindtree.flight.services.FlightServiceImpl;
import com.mindtree.flight.services.PersonService;
import com.mindtree.flight.services.PersonserviceImpl;
import com.mindtree.flight.utility.KeyboardUtils;

public class AppRunner {
	public static void displayAccount(List<Person> person) {
		for(Person p:person) {
			System.out.println(p.getPerson_id());
			System.out.println(p.getPerson_name());
			System.out.println(p.getAcc_balance());
		}
	}
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	List<Person> person=new ArrayList<Person>();
	KeyboardUtils key=new KeyboardUtils();
	PersonService per=new PersonserviceImpl();
	FlightService flight=new FlightServiceImpl();
	List<Flight> fly2=new ArrayList<Flight>();
	int flag=1;
	do {
		System.out.println("enter one choice");
		System.out.println("1.Add person\n2.Add flight\n3.Display All flights\n4.Assign flight to a person\n5.personwhose balance>5000");
        int choice=	key.readInteger();
        switch(choice) {
        case 1:
        	System.out.println("enter person id");
        	int id=key.readInteger();
        	if(id!=-999) {
        	System.out.println("enter person name");
        	String name=key.readString();
        	System.out.println("enter account balance");
        	double balance=key.readDouble();
        	if(balance!=-999) {
        	Person p=new Person(id,name,balance);
        	try{per.triggerinsertIntoDB(p);}
        	catch(ServiceException e1) {
        		try {
        			throw new ApplicationException(e1.getLocalizedMessage(),e1);
        		}catch(ApplicationException e2) {
        			System.out.println(e2.getMessage());
        		}
        	}}
        	else {
        		System.out.println("Inavlid balance");
        	}}
        	else {
        		System.out.println("invalid id type");
        	}
        	//in.nextLine();
        	break;
        case 2:
        	System.out.println("enter flight id");
        	String fid=key.readString();
        	System.out.println("enter flight name");
        	String fname=key.readString();
        	System.out.println("enter ticket cost");
        	double ticket=key.readDouble();
         if(ticket!=-999) { Flight fly=new Flight(fid,fname,ticket);
          System.out.println(fly.getFlight_id());
        	try{flight.triggerinsertIntoDB(fly);}
        	catch(ServiceException e1) {
        		try {
        			throw new ApplicationException(e1.getLocalizedMessage(),e1);
        		}catch(ApplicationException e2) {
        			System.out.println(e2.getMessage());
        		}
        	}}
        	else
        		System.out.println("Invalid ticket cost");
        	break;
        case 3:
        	try{List<Flight> fly1=flight.triggerViewFlight();
        	if(fly1!=null) {
        		for(Flight f:fly1) {
            		f.display();}
        		System.out.println("Successfully showed flight details !!!!!");
        	
        	}
        	else {
        		System.out.println("No flights to show");}
        	}        	
        	catch(ServiceException e1) {
        		try {
        			throw new ApplicationException(e1.getLocalizedMessage(),e1);
        		}catch(ApplicationException e2) {
        			System.out.println(e2.getMessage());
        		}
        	
        }
        	break;
        case 4:
        	System.out.println("enter person id");
        	int pid=key.readInteger();
        	System.out.println("enter flight id");
        	String fid1=key.readString();
        	try{person=per.triggerViewPersonDB();
                  try {fly2=flight.triggerViewFlight();
                    if(per.triggerLinking(pid, fid1, person, fly2)==true)
                    	System.out.println("updated successfully");
                    else
                    	System.out.println("Wrong details to assign");
                  }
                    		   catch(ServiceException e1) {
                           		try {
                           			throw new ApplicationException(e1.getLocalizedMessage(),e1);
                           		}catch(ApplicationException e2) {
                           			System.out.println(e2.getMessage());
                           		}}}
        	catch(ServiceException e1) {
        		try {
        			throw new ApplicationException(e1.getLocalizedMessage(),e1);
        		}catch(ApplicationException e2) {
        			System.out.println(e2.getMessage());
        		}}
        	
        		break;
        case 5:
        	try{List<Person> per1=per.triggerViewPersonAccount();
        	if(per1!=null) {
            	displayAccount(per1);	
        		System.out.println("Successfully showed persons whose account_balance s greater than 50000 !!!!!");
        	
        	}
        	else {
        		System.out.println("No flights to show");}
        	}        	
        	catch(ServiceException e1) {
        		try {
        			throw new ApplicationException(e1.getLocalizedMessage(),e1);
        		}catch(ApplicationException e2) {
        			System.out.println(e2.getMessage());
        		}}
        	break;
        	
        		default: System.out.println("enter a valid choice");
        	flag=1;}
	}while(flag!=0);
}
}
