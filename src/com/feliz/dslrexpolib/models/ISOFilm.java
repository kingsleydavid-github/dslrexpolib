package com.feliz.dslrexpolib.models;

public class ISOFilm {
	private Long value;
	
	public ISOFilm(Long isoValue)
	{
		this.value = isoValue;
	}
	
	public Long getValue()
	{
		return this.value;
	}
}
