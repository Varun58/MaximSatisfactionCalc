package com.satisfcalc.utils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.satisfcalc.config.TestConfiguration;
import com.satisfcalc.domain.Dish;

public class DishComparatorTests extends TestConfiguration {

	@Test
	public void testIsAbleToCompareDishesOnTheBasisOfRatio() {
		Dish d1 = new Dish(1, 84, 4);
		Dish d2 = new Dish(2, 40, 5);
		Dish d3 = new Dish(3, 36, 3);

		List<Dish> dishesList = new ArrayList<Dish>();
		dishesList.add(d1);
		dishesList.add(d2);
		dishesList.add(d3);

		Collections.sort(dishesList, new DishComparator());

		assertThat(dishesList, hasSize(3));
		
		// ensure they are order on Maximum Satisfaction Ratio
		assertThat(" Id is equal to 1 ", dishesList.get(0).getId(), is(equalTo(1)));
		assertThat(" Ratio is equal to 84/4=21 ", dishesList.get(0).getSatisfactionValueVsTime(), is(equalTo(21)));
		
		assertThat(" Id is equal to  3", dishesList.get(1).getId(), is(equalTo(3)));
		assertThat(" Ratio is equal to 36/3=12 ", dishesList.get(1).getSatisfactionValueVsTime(), is(equalTo(12)));
		
		assertThat(" Id is equal to 2 ", dishesList.get(2).getId(), is(equalTo(2)));
		assertThat(" Ratio is equal to 40/5=8 ", dishesList.get(2).getSatisfactionValueVsTime(), is(equalTo(8)));
	}
}
