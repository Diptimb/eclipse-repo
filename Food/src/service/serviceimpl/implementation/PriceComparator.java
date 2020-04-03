package service.serviceimpl.implementation;

import java.util.Comparator;

import entity.Food;

public class PriceComparator implements Comparator<Food> {

	@Override
	public int compare(Food food1,Food food2) {
		
		if(food1.getPrice()<food2.getPrice())
			return -1;
		if(food1.getPrice()>food2.getPrice())
			return 1;
		else
			return 0;
	}
	}


	
	


