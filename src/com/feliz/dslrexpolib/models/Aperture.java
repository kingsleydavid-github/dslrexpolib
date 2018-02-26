package com.feliz.dslrexpolib.models;

/**
 * @author Kingsley.Davidj
 *
 */
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
