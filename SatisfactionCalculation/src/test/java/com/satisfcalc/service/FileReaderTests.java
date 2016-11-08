package com.satisfcalc.service;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.satisfcalc.config.TestConfiguration;
import com.satisfcalc.domain.Dish;

public class FileReaderTests extends TestConfiguration{
	
	@Autowired 
	InputFileReader ifr ;
	
	@Autowired
	SatisfactionEvaluator se;
	
	@Before
	public void setUp() throws Exception{
		ifr.readFromFile();
	}
	
	@Test
	public void ableToFetchCorrectFile() {
		Assert.assertEquals("data.txt", ifr.getFileName());
	}
	
	//Assuming T is in Minutes
	@Test
	public void ableToFetchCorrectInputsFromFile() {
		Assert.assertEquals(100, se.getNumberOfDishes());
		Assert.assertEquals(10000, se.getTimeToEatDishes());
	}
	
	@Test
	public void validateDataForDishesGeneratedFromFile() {
		List<Dish> dishes = se.getDishesToEat();
		Assert.assertTrue(dishes.contains(new Dish(98,61626,535)));
		Assert.assertTrue(dishes.contains(new Dish(34,40978 ,409)));
		Assert.assertTrue(dishes.contains(new Dish(64,19114,531)));
	}
	
	@Test
	public void isAbleToCalculateCorrectRatioForDishes() {
		List<Dish> dishes = se.getDishesToEat();
		/*Dish [id=78, satisfactionValue=83455, timeToEat=224, satisfactionValueVsTime=372]
		  Dish [id=19, satisfactionValue=80980, timeToEat=150, satisfactionValueVsTime=539]
		  Dish [id=24, satisfactionValue=25229, timeToEat=92, satisfactionValueVsTime=274]*/
		
		for(Dish d: dishes){
			if(d.getId()==78){
				assertThat("Satifaction Value vs Time Value for Dish 78 Calculated as  83455/224 = 372", d.getSatisfactionValueVsTime(), is(equalTo(372)));	
			}
			if(d.getId()==19){
				assertThat("Satifaction Value vs Time Value for Dish 19 Calculated as  83455/224 = 372", d.getSatisfactionValueVsTime(), is(equalTo(539)));	
			}
			
			if(d.getId()==24){
				assertThat("Satifaction Value vs Time Value for Dish 24 Calculated as  83455/224 = 372", d.getSatisfactionValueVsTime(), is(equalTo(274)));	
			}
		}
	}

}
