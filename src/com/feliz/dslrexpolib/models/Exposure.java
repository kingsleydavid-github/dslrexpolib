package com.feliz.dslrexpolib.models;

public class Exposure {
	private static final long DEFAULT_ISO_VALUE = 100L;
	private static final float DEFAULT_SHUTTERSPEED = 1.0F;
	private static final long DEFAULT_APERTURE_VALUE = 0L;
	private int eValue;
	private Aperture aperture;
	private ShutterSpeed shutterSpeed;
	private ISOFilm isoFilm;

	public Exposure()
	{
		this.eValue = 0;
		this.aperture = new Aperture(DEFAULT_APERTURE_VALUE);
		this.shutterSpeed = new ShutterSpeed(DEFAULT_SHUTTERSPEED);
		this.isoFilm = new ISOFilm(DEFAULT_ISO_VALUE);
	}
	
	public Exposure(int eValue)
	{
		
	}
	
	private Exposure getExposure(int eValue)
	{
		Exposure exp = new Exposure();
		
		/*
		 * Logic
		 * 
		 * */
		return exp;
	}
}
