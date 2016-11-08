package com.satisfcalc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.satisfcalc.domain.Dish;

@Component("fileReader")
public class InputFileReader {

	@Value("${input.data.file}")
	String fileName;

	@Autowired
	SatisfactionEvaluator satisfactionEvaluator;

	@Autowired
	ResourceLoader resourceLoader;

	/* Read the input from file and make the Dishes Object with their satisfaction values 
	 * and parameters.
	 * */
	public void readFromFile() throws Exception {
		
		if(null==fileName){
			throw new FileNotFoundException(" File Name Missing !!");

		}
		
		Resource resource = resourceLoader.getResource("classpath:" + fileName);
		File fileRead = resource.getFile();
		
		if(null == fileRead){
			throw new FileNotFoundException(" Please provide a valid file location ");
		}
		
		BufferedReader br = new BufferedReader(new FileReader(fileRead));

		String firstLine = br.readLine();

		String values[] = firstLine.split(" ");

		int minutesToEat = Integer.parseInt(values[0]);
		int numberOfItems = Integer.parseInt(values[1]);

		System.out.println("\nLet us find the Maximum Satisfaction from eating  " + numberOfItems + " items in "	+ minutesToEat + " units.");

		List<Dish> dishesToEat = configureDishParameters(br);
		br.close();

		setValuesForEvaluation(minutesToEat, numberOfItems, dishesToEat);
	}

	public List<Dish> configureDishParameters(BufferedReader br) throws IOException {
		String currentLine;
		String[] values;
		int dishNumber = 0;
		
		List<Dish> dishesToEat = new ArrayList<Dish>();

		while ((currentLine = br.readLine()) != null) {
			dishNumber++;

			values = currentLine.split(" ");

			int satisfactionValue = Integer.parseInt(values[0]);
			int seconds = Integer.parseInt(values[1]);

			Dish dish = new Dish(dishNumber, satisfactionValue, seconds);
			dishesToEat.add(dish);

			//System.out.println(satisfactionValue + " in  " + seconds + " seconds");

		}
		return dishesToEat;
	}

	private void setValuesForEvaluation(int minutesToEat, int numberOfItems, List<Dish> dishesToEat) {
		satisfactionEvaluator.setNumberOfDishes(numberOfItems);
		satisfactionEvaluator.setTimeToEatDishes(minutesToEat);
		satisfactionEvaluator.setDishesToEat(dishesToEat);
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
