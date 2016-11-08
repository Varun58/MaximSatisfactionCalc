package com.satisfcalc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.satisfcalc.domain.Dish;
import com.satisfcalc.utils.DishComparator;

@Component
public class SatisfactionEvaluator {

	private List<Dish> dishesToEat = new ArrayList<Dish>();
	private int numberOfDishes;
	private int totalTimeToEatAllDishes;

	public void calculateMaxSatisfaction(){
		System.out.println("Dishes to eat from File are : " + dishesToEat.size());
		calculateMaxSatisfactionIfTimeIsInMinutes(totalTimeToEatAllDishes*60);			
		calculateMaxSatisfactionIfTimeIsInSeconds();	
		
	}
	
	public int calculateMaxSatisfactionIfTimeIsInSeconds() {
		int dishCount=dishesToEat.size();
		int satisfactionValues[] = new int[100];
		int timeToEatDish[] = new int[100];
		for(int i=0;i<dishesToEat.size();i++){
			satisfactionValues[i]=dishesToEat.get(i).getSatisfactionValue();
			timeToEatDish[i]=dishesToEat.get(i).getTimeToEat();
			
		}
		int maxSatisfactionValue = calculateMaxValue(totalTimeToEatAllDishes, timeToEatDish, satisfactionValues, dishCount);
		
		System.out.println("\n============== Calculating for T in Seconds =================");
		System.out.println("Maximum Satisfaction gained from eating "+dishCount+" dishes is :"+maxSatisfactionValue );
		
		return maxSatisfactionValue;
	}


	
	public int  calculateMaxSatisfactionIfTimeIsInMinutes(int totalTimeToEatAllDishes) {
		int dishCount=dishesToEat.size();
		int satisfactionValues[] = new int[100];
		int timeToEatOneDish[] = new int[100];
		for(int i=0;i<dishesToEat.size();i++){
			satisfactionValues[i]=dishesToEat.get(i).getSatisfactionValue();
			timeToEatOneDish[i]=dishesToEat.get(i).getTimeToEat();
			
		}
		int maxSatisfactionValue = calculateMaxValue(totalTimeToEatAllDishes, timeToEatOneDish, satisfactionValues, dishCount);
		
		System.out.println("\n============== Calculating for T in Minutes =================");
		System.out.println("Maximum Satisfaction gained from eating "+dishCount+" dishes is :"+maxSatisfactionValue );
		
		return maxSatisfactionValue;
		}

	
	int calculateMaxValue(int totalTime, int timeToEat[], int satisfactionValues[], int numberOfDishes) {
		int i, j;
		int k[][] = new int[numberOfDishes + 1][totalTime + 1];

		for (i = 0; i <= numberOfDishes; i++) {
			for (j = 0; j <= totalTime; j++) {
				if (i == 0 || j == 0)
					k[i][j] = 0;
				else if (timeToEat[i - 1] <= j)
					k[i][j] = max(satisfactionValues[i - 1] + k[i - 1][j - timeToEat[i - 1]], k[i - 1][j]);
				else
					k[i][j] = k[i - 1][j];
			}
		}

		return k[numberOfDishes][totalTime];
	}


	public List<Dish> getDishesToEat() {
		return dishesToEat;
	}

	public void setDishesToEat(List<Dish> dishesToEat) {
		Collections.sort(dishesToEat, new DishComparator());
		this.dishesToEat = dishesToEat;
	}

	public int getNumberOfDishes() {
		return numberOfDishes;
	}

	public void setNumberOfDishes(int numberOfDishes) {
		this.numberOfDishes = numberOfDishes;
	}

	public int getTimeToEatDishes() {
		return totalTimeToEatAllDishes;
	}

	public void setTimeToEatDishes(int timeToEatDishes) {
		this.totalTimeToEatAllDishes = timeToEatDishes ;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
