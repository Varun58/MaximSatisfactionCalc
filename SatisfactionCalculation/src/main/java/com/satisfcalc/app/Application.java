package com.satisfcalc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import com.satisfcalc.service.InputFileReader;
import com.satisfcalc.service.SatisfactionEvaluator;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.satisfcalc")
public class Application {
	
	/* 1. Read from the input file to set the values
	 * 2. Start calculating the result on the basis of the input received. 
	 * */
	public static void main(String[] args) throws Exception {
		ApplicationContext cxt = SpringApplication.run(Application.class);
		InputFileReader ifr = cxt.getBean(InputFileReader.class);
		ifr.readFromFile();

		SatisfactionEvaluator se = cxt.getBean(SatisfactionEvaluator.class);
		se.calculateMaxSatisfaction();
		

	}

}
