package client;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import CustomExceptions.InvalidTypeException;
import service.Service1;
import service.serviceimpl.Service2;
import service.serviceimpl.implementation.*;
import entity.Food;

public class Client {
public static void main(String[] args) {
	List<Food> food=new ArrayList<Food>();
	Scanner in = new Scanner(System.in);
	int flag = 1;
	Service2 service=new Service2();
	
		do {
			try {
			System.out.println("enter one choice");
			System.out.println("1.Add food\n2.Sort based on price\n3.Display type of food\n4.FileWriting\n5.View Food");
			int choice=in.nextInt();
			in.nextLine();
			switch(choice) {
			
			case 1:
			System.out.println("enter the name of the food");
			String foodName = in.nextLine();
			System.out.println("enter the type of the food");
			String type = in.nextLine();
			System.out.println("enter food id");
			try{int id = in.nextInt();
			     System.out.println("enter the price of food");
			     double price=in.nextDouble();
			     Service1.addFood(food,foodName,id,type,price);
			//System.out.println(food.toString());
			     }
			catch(Exception e){
				System.out.println(e+" please enter valid input");
			}
			in.nextLine();
			break;
			case 2:
				//Comparator<Food> cm1=Comparator.comparing(Food::getPrice);  
			    Collections.sort(food,new PriceComparator());
				for(Food f:food) {
					System.out.println(f.getName()+"  "+f.getPrice());
				}
				break;
			case 3:
				try{System.out.println("enter the type of food u want to see");
				String type1=in.nextLine();
				List<Food> food1=new ArrayList<Food>();
				food1=service.addFood1(food, type1);
				System.out.println("hjkh");
				food1.forEach((n)->System.out.println(n.toString()));}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				try{
					 FileWriter fileWriter = new FileWriter("output2.txt");
					 BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
					
					 food.forEach(f ->{
						 try {
						bufferedWriter.write(f.toString());
						 bufferedWriter.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					    });
					 System.out.println("file writing is done");
					 bufferedWriter.close();
					 
					 FileOutputStream fout = new FileOutputStream("output2.txt");
				 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fout);
				 food.forEach(f ->{
					 try {
						 bufferedOutputStream.write(f.toString().getBytes());
						 bufferedOutputStream.write("\r\n".getBytes());
					 }catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}});
					 System.out.println("done");
					 bufferedOutputStream.close();
			}
			
				catch(Exception e) {
					System.out.println( "Error writing to file ");
				}
			case 5:
			    System.out.println("Food items using tree map");
				Map <Integer,Food> foods=new TreeMap<Integer,Food>();
				for(Food f:food) {
					foods.put(f.getId(), f);
				}
				foods.forEach((k,v) -> System.out.println("key ="+k +" value="+v));
				 Comparator<Food> cm1=Comparator.comparing(Food::getId);  
				 System.out.println("food list using tree set :");
				Set<Food> food1=new TreeSet<Food>(cm1);
				for(Food f:food) {
					food1.add(f);
				}
				food1.forEach(foo->System.out.println(foo.toString()));
				System.out.println("food list using linked hash set");
				Set<Food> food2=new LinkedHashSet<Food>();
				Iterator<Food> itr=food.iterator();
				while(itr.hasNext()) {
					Food f=itr.next();
					food2.add(f);
				}
				food2.forEach(foo->System.out.println(foo.toString()));
			
			break;
			default :System.out.println("invalid input");
				}}
catch(Exception e) {
	System.out.println("OOps invalid input type");
	in.nextLine();
}}
		while(flag!=0);
		
}}