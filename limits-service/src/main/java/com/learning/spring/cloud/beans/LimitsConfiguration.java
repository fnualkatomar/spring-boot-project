package com.learning.spring.cloud.beans;

public class LimitsConfiguration {
	
	private int minimum;
	private int maximum;
	
	protected LimitsConfiguration() {}
	
	public LimitsConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
