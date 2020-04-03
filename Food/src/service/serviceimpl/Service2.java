package service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import CustomExceptions.InvalidTypeException;
import entity.Food;
import service.Service1;

public class Service2 implements Service1 {
	@Override
	public List<Food> addFood1(List<Food> food, String type1) throws InvalidTypeException {
		List<Food> food2=new ArrayList<Food>();
		for(Food f:food) {
			if(f.getType().equalsIgnoreCase(type1)) {
				//System.out.println("hkjhk");
				food2.add(f);
			}
			else if(food2.isEmpty()){
				throw new InvalidTypeException("invalid type of food");
			}
		}
				return food2;  }

	}
	
	
