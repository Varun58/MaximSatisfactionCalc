package com.satisfcalc.domain;

public class Dish {

	private int id;
	private int satisfactionValue;
	private int timeToEat;
	private int satisfactionValueVsTime;
	
	public Dish(int dishNumber,int satisfactionValue,int timeToEat) {
		this.id=dishNumber;
		this.satisfactionValue=satisfactionValue;
		this.timeToEat=timeToEat;
		if(0!=timeToEat){
		this.satisfactionValueVsTime = satisfactionValue/timeToEat;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSatisfactionValue() {
		return satisfactionValue;
	}
	public void setSatisfactionValue(int satisfactionValue) {
		this.satisfactionValue = satisfactionValue;
	}
	public int getTimeToEat() {
		return timeToEat;
	}
	public void setTimeToEat(int timeToEat) {
		this.timeToEat = timeToEat;
	}
	public int getSatisfactionValueVsTime() {
		return satisfactionValueVsTime;
	}
	public void setSatisfactionValueVsTime(int satisfactionValueVsTime) {
		this.satisfactionValueVsTime = satisfactionValueVsTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + satisfactionValue;
		result = prime * result + satisfactionValueVsTime;
		result = prime * result + timeToEat;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (id != other.id)
			return false;
		if (satisfactionValue != other.satisfactionValue)
			return false;
		if (timeToEat != other.timeToEat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", satisfactionValue=" + satisfactionValue + ", timeToEat=" + timeToEat
				+ ", satisfactionValueVsTime=" + satisfactionValueVsTime + "]";
	}
	
	
}
