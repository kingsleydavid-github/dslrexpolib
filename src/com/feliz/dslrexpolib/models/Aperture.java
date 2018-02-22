package com.feliz.dslrexpolib.models;

public class Aperture {
	
	private Double value;
	
	public Aperture(Double fNumber)
	{
		this.value = fNumber;
	}
	
	public Double getValue()
	{
		return this.value;
	}
}
