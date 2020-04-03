package service;

import java.util.List;

import CustomExceptions.InvalidTypeException;
import entity.Food;

public interface Service1 {
static void addFood(List<Food> food,String name, int id,String type,double price) 
	 {
		food.add(new Food(id,  name, price,type));
		System.out.println(food.toString());
	}

default void display(List<Food> food) throws InvalidTypeException{
	for(Food f:food) {
		System.out.println("food name- "+f.getName());
		System.out.println("food price- "+f.getPrice());
		System.out.println("food id-"+f.getId());
		System.out.println("---------");
	}
	
}
List<Food> addFood1(List<Food> food,String type1) throws InvalidTypeException;
}
