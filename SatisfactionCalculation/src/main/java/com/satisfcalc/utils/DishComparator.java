package com.satisfcalc.utils;

import java.util.Comparator;

import com.satisfcalc.domain.Dish;

public class DishComparator implements Comparator<Dish>{

	/* Comparator to sort the dishes on the basis of the satisfaction in time ratio in descending order*/
	@Override
	public int compare(Dish o1, Dish o2) {
		
		if(o1.getSatisfactionValueVsTime()>o2.getSatisfactionValueVsTime())
			return -1;
		if(o1.getSatisfactionValueVsTime()<o2.getSatisfactionValueVsTime())
			return 1;
		
		return 0;
	}

	
}
