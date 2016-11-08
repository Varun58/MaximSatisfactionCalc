package com.satisfcalc.service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.satisfcalc.config.TestConfiguration;

public class SatisfactionEvaluatorTests extends TestConfiguration{
	
	@Autowired 
	InputFileReader ifr ;
	
	@Autowired
	SatisfactionEvaluator se;
	
	@Before
	public void setUp() throws Exception{
		ifr.readFromFile();
	}
	
	@Test
	public void ableToFindMaxValueInSeconds() {
		Assert.assertEquals(2493893, se.calculateMaxSatisfactionIfTimeIsInSeconds());
	}
	
	@Test
	public void ableToFindMaxValueInMinutes() {
		Assert.assertEquals(4488056, se.calculateMaxSatisfactionIfTimeIsInMinutes(10000*60));
	}
	
	@Test
	public void isAbleToCompareTwoValues() {
		int maxValue = se.max(20, 35);
		Assert.assertTrue(maxValue==35);
	}
	
}
